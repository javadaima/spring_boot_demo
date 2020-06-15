package com.example.kafka.util;

import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
 
/**
 * AES 加密工具类
 */
public class AesUtil{
 
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
 
    /**
     * 加盐内容
     */
    private static final String SALTPRE="TEST";
 
    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) throws Exception {
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        byte[] byteContent = content.getBytes(DEFAULT_CHARSET);
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
        byte[] result = cipher.doFinal(byteContent);
        return parseByte2HexStr(result);
    }
 
    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
        //执行操作
        byte[] result = cipher.doFinal(parseHexStr2Byte(content));
        return new String(result, DEFAULT_CHARSET);
    }

    public static void main(String[] args) throws Exception {
        String str = "<Request lang=\"zh-CN\" service=\"OrderService\"> \n" +
                "  <Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"bspOrderServiceBody\">  \n" +
                "    <Order cargo_total_weight=\"0.5\" custid=\"9999999999\" d_address=\"陆家嘴大厦550号17楼\" d_city=\"昆明\" d_company=\"测试\" d_contact=\"测试\" d_country=\"中国\" d_county=\"伍角\" d_mobile=\"1234567890\" d_post_code=\"54321\" d_province=\"云南省\" d_tel=\"1234567890\" declared_value=\"10000\" declared_value_currency=\"CNY\" expected_delivery_date=\"2020-06-13T11:20:07+08:00\" expected_pickup_date=\"2020-06-12T11:20:07+08:00\" express_type=\"1\" is_gen_bill_no=\"1\" j_address=\"华新路555号\" j_city=\"上海\" OrderResponse=\"EH\" j_contact=\"小雷\" j_country=\"中国\" j_county=\"青浦区\" j_mobile=\"1234567890\" j_post_code=\"12345\" j_province=\"上海市\" j_shippercode=\"EH\" j_tel=\"1234567890\" need_return_tracking_no=\"1\" orderid=\"EH20200612-02\" pallet_quantity=\"1\" parcel_quantity=\"4\" pay_method=\"1\" receiver_ID=\"R2020060901\" remark=\"测试备注0612-1\" routelabelForReturn=\"1\" routelabelService=\"1\" sender_ID=\"S2020061201\" total_net_weight=\"20\" volume=\"10.2\"> \n" +
                "      <AddedService name=\"INSURE\" value=\"0\"/>  \n" +
                "      <Cargo count=\"2\" line_number=\"10\" name=\"test1\" sku_name=\"test123\" sku_number=\"12345\" sku_qty=\"2\" sku_uom=\"a\" unit=\"a\"/>  \n" +
                "      <Cargo count=\"6\" line_number=\"11\" name=\"test1\" sku_name=\"test321\" sku_number=\"54321\" sku_qty=\"4\" sku_uom=\"kg\" unit=\"a\"/>  \n" +
                "      <Cargo amount=\"172\" count=\"6\" currency=\"CNY\" hs_code=\"210293\" line_number=\"12\" name=\"test1\" sku_name=\"我是谁\" sku_number=\"1234\" sku_qty=\"5\" sku_uom=\"kg\" source_area=\"CN\" unit=\"a\"/>  \n" +
                "      <Extra e14=\"singBackInfo\" e15=\"1\"/> \n" +
                "    </Order> \n" +
                "  </Body>  \n" +
                "  <Head>HZZTKJ</Head>\n" +
                "</Request>";
        String encrypt = encrypt(str, "314");
        System.out.println(encrypt);
        String decrypt = decrypt(encrypt, "314");
        System.out.println(decrypt);
    }
 
    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String password) throws Exception {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
        secureRandom.setSeed(password.getBytes());
        kg.init(128, secureRandom);
        SecretKey secretKey = kg.generateKey();
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    }
 
    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
 
    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
 
    /**
     * 自定义内容加盐
     * @return 返回结果传入encrypt、decrypt方法的password参数
     */
    public static String customSaltContent(){
        return DigestUtils.md5Hex(SALTPRE).substring(8, 24);
    }
}
