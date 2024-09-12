package com.example.kafka.util;

import com.example.kafka.aspect.ExcelColumn;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 将excel表格数据映射为带有@ExcelColumn的实体类对象
 */
public class ExcelUtils {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 将单个excel转化为对象集合(中转化第一个sheet,且默认第一行为表头)
     * @param multipartFile	excel
     * @param tClass 需要映射的类
     * @return
     */
    public static  <T> List<T> convertExcelToObject(MultipartFile multipartFile, Class<T> tClass){
        logger.info("[START] convertExcelToObject(InputPart part, Class<T> tClass,int columnSize)");
        String fileName = multipartFile.getOriginalFilename();
        List<T> ts = new ArrayList<>();
        //指定每列对应的类属性
        LinkedHashMap<String, String> alias = new LinkedHashMap<>();
        Field[] declaredFields = tClass.getDeclaredFields();
        for(Field filed:declaredFields){
            String filedName = filed.getName();
            if(filed.isAnnotationPresent(ExcelColumn.class)){
                ExcelColumn excelColumnAnnotation = filed.getDeclaredAnnotation(ExcelColumn.class);
                String columnName = excelColumnAnnotation.columnName();
                alias.put(columnName,filedName);
            }

        }
        try {
            InputStream inputStream = multipartFile.getInputStream();
            Workbook workbook;
            if (judegExcelEdition(Objects.requireNonNull(fileName))) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                workbook = new HSSFWorkbook(inputStream);
            }
            //获取第一张工作表
            Sheet sheet = workbook.getSheetAt(0);
            Map<String, Integer> propertyMap = generateColumnPropertyMap(sheet, alias);
            ts = generateList(sheet, propertyMap, tClass);
            //更新导入信息
            logger.info("[END] convertExcelToObject(InputPart part, Class<T> tClass,int columnSize)");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("错误文件上传失败");
        }
        return ts;

    }

 /*   public static <T> List<T> convertExcelToObject2(InputStream inputStream, Class<T> tClass,LinkedHashMap<String, String> alias) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        logger.info("[START] convertExcelToObject(InputPart part, Class<T> tClass,int columnSize)");
        List<T> ts;
        Workbook workbook = null;
        workbook = new XSSFWorkbook(inputStream);

        //获取第一张工作表
        Sheet sheet = workbook.getSheetAt(0);
        Map<String, Integer> propertyMap = generateColumnPropertyMap(sheet, alias);
        ts = generateList(sheet, propertyMap, tClass);
        return ts;
    }*/

    /**
     * 生成一个属性-列的对应关系的map
     */
    public static Map<String,Integer> generateColumnPropertyMap(Sheet sheet, Map<String,String> alias) {
        Map<String,Integer> propertyMap=new HashMap<>();

        Row propertyRow = sheet.getRow(0);
        short firstCellNum = propertyRow.getFirstCellNum();
        short lastCellNum = propertyRow.getLastCellNum();

        for(int i=firstCellNum;i<lastCellNum;i++) {
            Cell cell = propertyRow.getCell(i);
            if(cell==null) {
                continue;
            }
            String cellValue = getCellValue(cell);

            //对应属性名
            String propertyName = alias.get(cellValue);
            if(StringUtils.isNotBlank(propertyName)){
                propertyMap.put(propertyName, i);
            }
        }
        return propertyMap;
    }

    /**
     * 根据指定关系将表数据转换成对象数组
     */
    public static <T>List<T> generateList(Sheet sheet,Map<String,Integer> propertyMap,Class<T> claz) throws InstantiationException, IllegalAccessException, InvocationTargetException{
        //对象数组
        List<T> pojoList=new ArrayList<>();
        for (Row row : sheet) {
            //跳过列名
            if(row.getRowNum()<1) {
                continue;
            }
            T instance = claz.newInstance();
            Set<Map.Entry<String, Integer>> entrySet = propertyMap.entrySet();
            for (Map.Entry<String, Integer> entry : entrySet) {
                //获取此行指定列的值,即为属性对应的值
                Cell cell = row.getCell(entry.getValue());
                String cellValue = getCellValue(cell);
                BeanUtils.setProperty(instance, entry.getKey(), cellValue);
            }
            pojoList.add(instance);
        }
        return pojoList;
    }

    private static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell.getCellTypeEnum() != CellType.STRING && HSSFDateUtil.isCellDateFormatted(cell)){
            cellValue = getCellValueByCell(cell);
        }else{
            cellValue = cell.toString();
        }
        return cellValue;
    }
    /**
     * 判断上传的excel文件版本（xls为2003，xlsx为2017）
     * @param fileName 文件路径
     * @return excel2007及以上版本返回true，excel2007以下版本返回false
     */
    public static boolean judegExcelEdition(String fileName){
        if (fileName.matches("^.+\\.(?i)(xls)$")){
            return false;
        }else {
            return true;
        }
    }
    //获取单元格各类型值，返回字符串类型
    public static String getCellValueByCell(Cell cell) {
        //判断是否为null或空串
        if (cell==null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        short format = cell.getCellStyle().getDataFormat();
        if (DateUtil.isCellDateFormatted(cell)) {
            SimpleDateFormat sdf = null;
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                cellValue = sdf.format(cell.getDateCellValue());// 日期
            } catch (Exception e) {
                try {
                    throw new Exception("exception on get date data !".concat(e.toString()));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }finally{
                sdf = null;
            }
        }  else {
            BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
            cellValue = bd.toPlainString();// 数值 这种用BigDecimal包装再获取plainString，可以防止获取到科学计数值
        }
        return cellValue;
    }

  /*  public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //指定输入文件
        FileInputStream fis = new FileInputStream("D:\\项目需求\\订单标记\\orderMarkRule.xlsx");
        //指定每列对应的类属性
        LinkedHashMap<String, String> alias = new LinkedHashMap<>();
        Field[] declaredFields = RuleImportRule.class.getDeclaredFields();
        for(Field filed:declaredFields){
            String filedName = filed.getName();
            if(filed.isAnnotationPresent(ExcelColumn.class)){
                ExcelColumn excelColumnAnnotation = filed.getDeclaredAnnotation(ExcelColumn.class);
                String columnName = excelColumnAnnotation.columnName();
                alias.put(columnName,filedName);
            }

        }
        List<RuleImportRule> pojoList = convertExcelToObject2(fis, RuleImportRule.class, alias);

        //转换成指定类型的对象数组
        logger.info(pojoList.toString());
    }*/
}
