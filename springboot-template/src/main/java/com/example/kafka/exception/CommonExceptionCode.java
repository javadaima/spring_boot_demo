package com.example.kafka.exception;

public enum CommonExceptionCode implements ExceptionCodeSet {

    /********************************
     **  用户域
     ********************************/
    USER_NOT_AUTHENTICATED(401, "User is NOT authenticated.", "用户未登录。"),
    USER_NOT_AUTHORIZED(403, "User is NOT authorized.", "用户未授权。"),
    VERIFICATION_CODE_INCORRECT(405, "Verification code incorrect", "验证码不正确。"),
    USER_NOT_EXIST(406,"User is NOT exist","用户名不存在，或密码错误。"),
    PASSWORD_WRONG(407,"Password is wrong","登录密码错误。"),
    MAIL_ADDRESS_WRONG(408,"E-Mail is wrong","电子邮箱错误。"),
    FAILED_SEND_MAIL(409,"Failed to send mail","邮件发送失败。"),
    USERCODE_IS_NULL(410,"UserCode is NULL","登录用户名不能为空。"),
    USER_RELOAD(411,"Please change your password","请修改密码。"),
    USER_NOT_ALLOW_LOGIN(412, "Contact Administrator for Logon Permissions.", "联系管理员获取登录权限。"),
    USER_IS_EXIST(413,"User is exist","用户已存在。"),
    ROLE_NOT_EXIST(414,"Role is NOT exist","角色不存在。"),
    VERIFICATION_CODE_EXPIRED(415, "Verification code expired", "验证码失效。"),
    PASSWORD_IS_NULL(416,"Password is NULL","密码不能为空。"),
    USERNAME_IS_NULL(417,"UserName is NULL","姓名不能为空。"),
    EMAIL_IS_NULL(418,"Email is NULL","用户邮箱不能为空。"),
    PHONE_IS_NULL(419,"Phone is NULL","电话不能为空。"),
    LANGUAGE_IS_NULL(420,"Language is NULL","语言不能为空。"),
    SEX_IS_NULL(421,"Sex is NULL","性别不能为空。"),
    STYLE_IS_NULL(422,"Style is NULL","样式不能为空。"),
    ROLE_IS_NULL(422,"Role is NULL","角色不能为空。"),
    REDIS_RETURN_RESOURCE(423,"Redis resource recovery failure","Redis资源回收失败。"),
    REDIS_GET_RESOURCE(424,"Failed to obtain redis resources","获取Redis资源失败。"),
    REDIS_SET_EXPIRE(425,"Redis set expiration time failed","Redis设置过期时间失败。"),
    PHOTO_IS_NULL(426,"Photo is NULL","头像不能为空。"),
    PHOTO_NOT_EXIST(427,"Please set up photo","请设置头像。"),
    OLD_PASSWORD_NOT_EXIST(428,"OLDPwd is Wrong","旧密码不正确。"),
    NEW_PASSWORD_NOT_EXIST(429,"NEWPwd is Wrong","新密码不能为空。"),
    UPDATE_PASSWORD_NOT_EXIST(430,"Update NEWPwd is Wrong","更新新密码错误。"),
    USERNAME_NOT_EXIST(431,"UserName is NOT exist","用户不存在。"),
    UNP_NOT_PASS(432,"UNP connect error","UNP消息平台连接不通。"),
    BYTE_IS_NULL(433,"BYTE is NULL","流参数不能为空。"),
    RESET_PASSWORD(434,"Reset password","重置密码。"),
    SAME_OLD_PASSWORD(435,"Same as the old password","新旧密码不能一致。"),
    UPDATE_USER_SELF_FAILED(436,"update user self fail","个人设置修改失败。"),
    PASSWORD_UNREPEATABLE(437,"password unrepeatable last six times","密码不能是最近使用过密码。"),
    USER_NO_ORGANIZATION(438,"please set user organization","请设置用户所属组织。"),
    EMAIL_INVALID(439,"Email input not equals to registered","输入的邮箱与注册邮箱不一致。"),
    PERMISSION_IS_NULL(440, "permission is null", "权限编码和描述不能为空。"),






    /********************************
     **  系统公共域
     ********************************/
    SERVER_COMMON_EXCEPTION(500, "System common exception.", "服务器异常。"),
    ENTITY_DUPLICATED(501, "Entity duplicated.", "记录已存在。"),
    DATE_PARSE_EXCEPTION(502, "Date parse exception.", "日期转换异常。"),
    ACCESS_DENIED(503, "Access denied.", "您没有权限访问该系统。"),
    COMPANY_CODE_BLANK(504, "Company code is blank.", "组织不能为空。"),
    COMPANY_CODE_NOT_SUPPORTED(505, "Company is NOT supported.", "组织不支持。"),
    ENTITY_NOT_EXIST(506, "Entity not exist..", "记录不存在。"),



    /********************************
     **  基础数据域
     ********************************/



    /********************************
     **  商品域
     ********************************/
    ITEM_NOT_EXSIT(1001, "Item does not exist.", "商品主数据不存在。"),
    ITEM_NOT_ACTIVE(1002, "Item is not active.", "商品处于未激活状态。"),



    /********************************
     **  订单域
     ********************************/
    BLANK_ERP_ORDER_NO(2901, "Erp order no is blank.", "订单号为空。"),
    EMPTY_ORDER_DETAILS(2902, "Order details is empty.", ""),
    BLANK_ITEM_CODE(2903, "Item code is blank.", "商品条码为空。"),
    BLANK_ITEM_QTY(2904, "Item quantity is blank.", "商品数量为空。"),
    BLANK_WAREHOUSE_CODE(2905, "Warehouse code is blank.", "仓库编码为空。"),
    STATUS_NO_SUPPORT(2906, "Status code is NOT supported.", "状态码不受支持。"),
    CHANGE_ERP_ORDER_NO(2907,"Erp order no change","订单号不可修改"),
    // 销售订单
    SALE_ORDER_NOT_EXSIT(2001, "Sale order does not exist.", "销售订单不存在。"),
    SALE_ORDER_CANCELED(2002, "Sale order is canceled.", "销售订单已取消。"),
    SALE_ORDER_EXSIT(2003, "Sale order does exist.", "销售订单已存在。"),

    // 调拨单
    ALLOT_ORDER_NOT_EXSIT(2101, "Allot order does not exist.", "调拨单不存在。"),
    ALLOT_ORDER_CANCELED(2102, "Allot order is canceled.", "调拨单已取消。"),

    // 退供单
    RETURN_ORDER_NOT_EXSIT(2201, "Return order does not exist.", "退供单不存在。"),
    RETURN_ORDER_CANCELED(2202, "Return order is canceled.", "退供单已取消。"),
    RETURN_ORDER_ITEM_REPEAT(2203, "Item Code in return order is repeated.", "退供单商品重复。"),
    RETURN_ORDER_ITEM_NOT_EXIST(2204, "Item Code in return order does not exist.", "退供单商品在原出库单中不存在。"),
    RETURN_ORDER_NOT_FINISHED(2205, "Return order is not finished.", "退供单不是出库完成状态。"),
    RETURN_ORDER_EXIST(2206, "Return order already exist.", "退供单已存在。"),
    RETURN_ORDER_QUANTITY_EXCESSIVE(2207, "Return order has excessive quantity.", "退供单退货量大于原出库量。"),

    // 采购订单
    PURCHASE_ORDER_NOT_EXSIT(2301, "Purchase order does not exist.", "采购订单不存在。"),
    PURCHASE_ORDER_CANCELED(2302, "Purchase order is canceled.", "采购订单已取消。"),


    /********************************
     **  出库单域
     ********************************/
    // 出库单
    OUTBOUND_ORDER_NOT_EXSIT(3001, "Outbound order does not exist.", "出库单不存在。"),
    OUTBOUND_ORDER_CANCELED(3002, "Outbound order is canceled.", "出库单已取消。"),
    OUTBOUND_ORDER_NO_CANCEL(3003, "Outbound order is NOT allowed cancelling.", "出库单不允许取消。"),

    // 库存分配
    OUTBOUND_ALLOCATION_NOT_FAILED(3101, "Inventory allocation fails.", "库存分配失败。"),

    // 波次
    OUTBOUND_WAVE_NOT_EXSIT(3201, "Wave does not exist.", "波次不存在。"),
    OUTBOUND_WAVE_CANCELED(3202, "Wave is canceled.", "波次已取消。"),

    // 拣货
    OUTBOUND_WORK_PICK_NOT_EXSIT(3301, "Picking work does not exist.", "拣货任务不存在。"),
    OUTBOUND_WORK_PICK_CANCELED(3302, "Picking work is canceled.", "拣货任务已取消。"),

    // 集货
    OUTBOUND_GATHER_TIMEOUT(3401, "Work group gathers timeout.", "批次集货超时。"),

    // 分拣
    OUTBOUND_SORT_NOT_MATCH(3501, "Total item quantity does not match order requires.", "商品分拣数量与订单不匹配。"),

    // 包装
    OUTBOUND_OQC_NOT_MATCH(3701, "Total item quantity does not match order requires.", "商品包装数量与订单不匹配。"),

    // 出库
    PACKAGE_NOT_EXSIT(3901, "Package does NOT exist.", "包裹不存在。"),



    /********************************
     **  入库单域
     ********************************/
    INBOUND_ORDER_NOT_EXSIT(4001, "Inbound order does not exist.", "入库单不存在。"),
    INBOUND_ORDER_CANCELED(4002, "Inbound order is canceled.", "入库单已取消。"),



    /********************************
     **  运单域
     ********************************/
    // 运单
    WAYBILL_NOT_EXSIT(5001, "Waybill does NOT exist.", "运单不存在。"),




    /********************************
     **  库存域
     ********************************/
    INVENTORY_NOT_EXSIT(6001, "Inventory does NOT exist.", "库存不存在。"),
    INVENTORY_DUPLICATE(6002, "Inventory duplicate.", "存在重复库存，请添加额外库存维度进行筛选。"),
    INVENTORY_INSUFFICIENT(6003, "Inventory insufficient .", "库存不足。"),

    /********************************
     **  报表域
     ********************************/
    REPORT_NOT_EXIST(7001, "report does not exist.", "报表主数据不存在。"),

    /********************************
     **  集成域
     ********************************/
    INTEGRATION_NOT_ACCESS(9001, "Target system does NOT accessible.", "目标系统无法访问。"),
    PARAM_NOT_NULL(9002, "param does not null.", "查询参数不能为空。"),

    /********************************
     **  webservice域
     ********************************/
    WEBSERVICE_CONNECTION_ERROR(10001, "webservice connect error", "webservice连接异常"),

    /********************************
     **  文件下载
     ********************************/
    DOWNLOAD_FAIL(11001,"download fail","下载失败"),

    /********************************
     **  客户配置域
     ********************************/
    TENANT_NO_ORGANIZATION(10000, "TENANT_NO_ORGANIZATION", "用户无组织，无法获取配置信息"),
    TENANT_ORDER_STATUS_DUPLICATE(10001, "TENANT_ORDER_STATUS_DUPLICATE", "订单状态值重复"),
    TENANT_ORDER_STATUS_CODE_ERROR(10002, "TENANT_ORDER_STATUS_CODE_ERROR", "状态值配置code错误"),
    TENANT_ORDER_STATE_TRACKING_DUPLICATE(10101, "TENANT_ORDER_STATE_TRACKING_DUPLICATE", "订单状态追踪值重复"),
    TENANT_ORDER_STATE_TRACKING_CODE_ERROR(10102, "TENANT_ORDER_STATE_TRACKING_CODE_ERROR", "状态追踪值配置code错误"),
    TENANT_ORDER_TABLE_CODE_ERROR(10202, "TENANT_ORDER_TABLE_CODE_ERROR", "列表配置code错误"),
    TENANT_ORDER_SEARCH_CODE_ERROR(10302, "TENANT_ORDER_SEARCH_CODE_ERROR", "简单搜索配置code错误"),
    TENANT_ORDER_ADVANCED_SEARCH_CODE_ERROR(10402, "TENANT_ORDER_ADVANCED_SEARCH_CODE_ERROR", "高级搜索配置code错误"),
    TENANT_ORDER_BASIC_INFO_CODE_ERROR(10502, "TENANT_ORDER_BASIC_INFO_CODE_ERROR", "订单详情配置code错误"),
    TENANT_ORDER_INFO_CODE_ERROR(11112, "TENANT_ORDER_INFO_CODE_ERROR", "订单信息配置code错误"),
    TENANT_ORDER_STORAGE_INFO_CODE_ERROR(10602, "TENANT_ORDER_STORAGE_INFO_CODE_ERROR", "仓储作业配置code错误"),
    TENANT_LAZADA_INFO_CODE_ERROR(10701, "TENANT_LAZADA_INFO_CODE_ERROR", "LAZADA配置信息错误"),

    /********************************
     **  excel导入
     ********************************/
    FILE_TYPE_ERROR(12001,"file type error","文件格式错误"),
    FILE_READ_ERROR(12002,"read file  error","文件读取错误"),
    FILE_IMPORT_ERROR(12003," file import  error","模板文件导入失败"),
    FILE_NOT_EXIST(12004," file not  exist","文件不存在"),
    REQUIRED_SHEET_NOT_EXIST(12005," required sheet not  exist","必填sheet不存在"),
    REQUIRED_SHEET_NOT_DATA(12006," required sheet  not  data","必填sheet无数据"),


    /********************************
     **  BI工具
     ********************************/
    SENSITIVE_CODE(19000," SENSITIVE_CODE","sql存在非法语法"),
    DATASET_HAS_ELEMENT(19001," DATASET_HAS_ELEMENT","数据集存在组件，请先删除组件"),
    SQL_FAIL(19002," SQL_FAIL","sql执行错误"),

    /********************************
     **  工作流
     ********************************/
    UPDATE_FLOW_DEFINITION_ERROR(14000,"update flowDefinition error","更新工作流定义失败"),
    FLOW_DEFINITION_NOT_EXIST(14001,"flowDefinition not exist","流程定义不存在"),
    TASK_NOT_EXIST(14002,"task not exist","审批任务不存在或已过期"),
    START_NODE_NOT_EXIST(14003,"start node not exist","开始节点不存在"),
    NODE_NOT_SET(14004,"node not set","审批节点未设置"),
    NODE_TOO_LESS(14005,"node too less","设置节点过少"),
    ACTIVATE_TYPE_NOT_SET(14006,"activate type not set","激活类型未配置"),
    APPROVE_TYPE_NOT_SET(14006,"approve type not set","审批类型未配置"),
    APPROVER_NOT_SET(14006,"approver not set","审批人未配置"),
    FLOW_PATH_TOO_LESS(14007,"flow path tpp less","流程路径过少"),
    FLOW_NODE_NOT_EXIST(14008,"flow node not exist","流程对应节点不存在"),
    FLOW_STARTED(14009,"flow started","订单流程已是开启状态"),
    FLOW_ORDER_TYPE_ERR(14010,"flow order type error","不支持订单类型"),

    /********************************
     **  web api client
     ********************************/
    API_SERVICE_ERROR(15001,"api service error","外部接口服务异常"),
    API_TIME_OUT(15001,"api timeout" ,"外部接口访问超时"),

    NO_COMPANY_CODE(20000,"no companyCode" ,"没有组织代码"),
    NO_OWNER_CODE(20001,"no ownerCode" ,"没有货主代码"),


    /********************************
     **  oms 筛单
     ********************************/
    OMS_WAREHOUSE_NOT_EXIST(16001,"no warehouseCode","未查询到对应的仓库代码"),
    OMS_CUSTOMER_NOT_EXIST(16002,"no Customer info","收件人信息为空" ),
    OMS_CUSTOMER_CITY_NOT_EXIST(16003,"no Customer city info","收件人城市信息信息为空" ),
    OMS_NETWORK_NOT_EXIST(16004,"no network city info","未查询到网点信息" ),
    OMS_SHIPMENT_DETAIL_NOT_EXIST(16005,"no shipment detail","出库单未查询到明细信息"),
    OMS_INVENTORY_NOT_EXIST(16006,"no inventory","库存不足"),
    OMS_ADDRESS_NOT_EXIST(16007,"no address","请求的详细地址为空"),
    OMS_TEL_NOT_EXIST(16007,"no tel","请求的电话号码为空"),

    /********************************
     **  gather表
     ********************************/
    REDIS_NO_WAYBILL_NO(22000,"redis no waybillNo","redis没有对应运单号"),

    /**
     *  统计报表
     */
    TIME_NOT_EXIST(23000,"no time","时间不能为空"),

    /********************************
     **  外部api
     ********************************/
    SIGN_CHECK_FAIL(30000,"sign check fail","数据签名验证失败"),
    SIGN_NOT_EXIST(30001,"no sign","数据签名不存在"),
    DATA_NOT_EXIST(30002,"no data","数据体不存在")
    ;




    // 异常编码
    private Integer exceptionCode;
    // 异常英文消息
    private String exceptionMessageEn;
    // 异常中文消息
    private String exceptionMessageCn;

    CommonExceptionCode(Integer exceptionCode, String exceptionMessageEn, String exceptionMessageCn){
        this.exceptionCode = exceptionCode;
        this.exceptionMessageEn = exceptionMessageEn;
        this.exceptionMessageCn = exceptionMessageCn;
    }

    @Override
    public Integer getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(Integer exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
    @Override
    public String getExceptionMessageEn() {
        return exceptionMessageEn;
    }

    public void setExceptionMessageEn(String exceptionMessageEn) {
        this.exceptionMessageEn = exceptionMessageEn;
    }

    @Override
    public String getExceptionMessageCn() {
        return exceptionMessageCn;
    }

    public void setExceptionMessageCn(String exceptionMessageCn) {
        this.exceptionMessageCn = exceptionMessageCn;
    }
}
