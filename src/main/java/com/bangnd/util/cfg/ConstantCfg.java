package com.bangnd.util.cfg;

public class ConstantCfg {

    public static final long CUSTOMER_IDENTITY_TYPE_1 = 1;
    public static final long CUSTOMER_IDENTITY_TYPE_2 = 2;
    public static final long CUSTOMER_IDENTITY_TYPE_3 = 3;
    public static final int ORDER_PRODUCT_STATE_DELETE = 100;
    public static final String ORDER_DOC_FIXED_PATH = "uploadfile/raw/byOrder/";
    public static final String ORDER_DOC_BASE_PATH = "/Users/wrh/Documents/wrh/work/gzx_app/";

    public static final int ACTION_ALLOCATION_HANDLER = 57;

    public static final int STANDARD_BUSI = 3;
    public static final int DOC_TYPE_1 = 1;
    public static final int DOC_TYPE_2 = 2;
    public static final int DOC_TYPE_3 = 3;
    public static final int DOC_TYPE_5 = 5;
    public static final int DOC_TYPE_6 = 6;
    public static final int DOC_TYPE_7 = 7;

    public static final int PUBLIC_VALID_STATE = 1;
    public static final int PUBLIC_INVALID_STATE = 0;
    public static final int NO_BUSI_FEE_2 = 2;
    //费用已核销
    public final static int OFF_SET_CLOSE = 1;
    //费用状态:支付成功
    public final static int PAY_STATE_FINISHED = 5;

    //订单状态：已经创建
    public static final int ORDER_STATE_INITIAL = 1;
    //订单状态：已汽配
    public static final int ORDER_STATE_MATCHED = 2;
    //订单状态：已签约
    public static final int ORDER_STATE_SIGNED = 4;
    public static final int ORDER_STATE_101 = 101;
    public static final int ORDER_STATE_102 = 102;
    public static final int ORDER_STATE_103 = 103;
    public static final int ORDER_STATE_104 = 104;
    public static final int ORDER_STATE_131 = 131;
    public static final int ORDER_STATE_157 = 157;

    //订单产品状态:费用已核算
    public final static int ORDER_PRODUCT_STATE_CACLED = 51;
    //订单产品状态:支付成功
    public final static int ORDER_PRODUCT_STATE_FINISHED = 7;
    //订单产品状态：已批贷
    public final static int ORDER_PRODUCT_STATE_APPROVED = 5;
    //每页显示条数
    public final static int NUM_PER_PAGE = 10;

    //实收付
    public final static int IFE_REAL_1 = 1;
    //流入
    public final static int IN_OUT_1 = 1;
    //流出
    public final static int IN_OUT_2 = 2;

    //上传资料
    public final static int ORDER_BUTTON_UPLOADDOC = 101;
    //录入客户
    public final static int ORDER_BUTTON_ADDCUST = 102;
    //添加产品
    public final static int ORDER_BUTTON_ADDPROD = 103;
    //订单关闭
    public final static int ORDER_STATE_136 = 136;
    //复审通过
    public final static int ORDER_STATE_108 = 108;
    //已签约
    public final static int ORDER_STATE_116 = 116;
    //同意放款
    public final static int ORDER_STATE_119 = 119;
    //下家已经抵押
    public final static int ORDER_STATE_124 = 124;

    public final static int ORDER_STATE_126 = 126;
    //已完结
    public final static int ORDER_STATE_127 = 127;


    //销售渠道，外部销售
    public final static int OUT_SALES_2 = 2;

    //资源
    public final static int RESOURCE_GRADE_1 = 1;
    public final static int RESOURCE_TYPE_2 = 2;
    public final static int BUTTON_ID_71 = 71;//订单暂存
    public final static int BUTTON_ID_72 = 72;//提交订单
    public final static int BUTTON_ID_74 = 74;//初审通过
    public final static int BUTTON_ID_73 = 73;//初审不通过
    public final static int BUTTON_ID_125 = 125;//初审不通过
    public final static int BUTTON_ID_133 = 133;//终审不通过
    public final static int BUTTON_ID_141 = 141;//不同意
    public final static int BUTTON_ID_130 = 130;//已安排下户


    //数据废弃状态
    public final static int STATE_100 = 100;
    public final static String STATE_100_NAME = "已作废";
    //数据生效中
    public final static int STATE_1 = 1;
    public final static String STATE_1_NAME = "生效中";

    //订单池中，正在处理的状态
    public final static int POOL_DOSTATE_2 = 2;
    public final static int POOL_DOSTATE_3 = 3;
    public final static int POOL_DOSTATE_1 = 1;

    //业务员岗位
    public final static int POSITION_SALES_11 = 11;

    //业务员岗位
    public final static int POSITION_OPERTION_8 = 8;

    //风控专员岗
    public final static int POSITION_RISK_7 = 7;
    //资金分配岗
    public final static int POSITION_CAPITAL_18 = 18;

    public final static int DAY = 1;
    public final static int THREEDAY = 2;
    public final static int WEEK = 3;
    public final static int TENDAY = 4;
    public final static int MONTH = 5;
    public final static int YEAR = 6;

    //收入费用类型：下户费
    public final static int CALC_TYPE_2 = 2;
    public final static int FEE_TYPE_DOWN = 30;
    //收入费用类型：利息
    public final static int CALC_TYPE_1 = 1;
    public final static int FEE_TYPE_INTEREST = 1;
    //收入费用类型：律师费
    public final static int CALC_TYPE_3 = 3;
    public final static int FEE_TYPE_LAWFEE = 9;
    public final static int FEE_TYPE_OUTAMOUNT = 21;
    public final static int FEE_TYPE_INAMOUNT = 26;
    public final static int FEE_TYPE_REAL_INAMOUNT = 28;
    public final static int FEE_TYPE_COMMISSION = 6;

    //业务员提成
    public final static int CALC_TYPE_5 = 5;
    //经理提成
    public final static int CALC_TYPE_7 = 7;
    //业务员最低提成
    public final static int CALC_TYPE_8 = 8;
    //业务员最高提成
    public final static int CALC_TYPE_9 = 9;
    //外勤业务员逐单提成
    public final static int CALC_TYPE_10 = 10;
    public final static int CALC_TYPE_11 = 11;
    public final static int CALC_TYPE_12 = 12;

    public final static int CHANNEL_TYPE_1 = 1;
    public final static int CHANNEL_TYPE_2 = 2;
    public final static String COMPANY_NAME = "贯泽信";

    public final static int PERIOD_TYPE_CURRENT_WEEK = 1;
    public final static int PERIOD_TYPE_CURRENT_MONTH = 2;
    public final static int PERIOD_TYPE_LAST_WEEK = 3;
    public final static int PERIOD_TYPE_LAST_MONTH = 4;
    public final static int PERIOD_TYPE_THREE_MONTHS = 5;
    public final static int PERIOD_TYPE_HALF_YEAR = 6;
    public final static int PERIOD_TYPE_ONE_YEAR = 7;
    public final static int PERIOD_TYPE_LAST_YEAR = 8;

    public final static int PERIOD_TYPE_BY_DAY = 1;


    /**
     * 北京大数科技有限公司
     */
    public final static String DD_CROP_ID = "dinge29e3909392432cf35c2f4657eb6378f";
    /**
     * 微应用-企业内部应用-报单管理H5
     */
    public final static Long DD_AGENT_ID = 250341250L;
    public final static String DD_H5_CONSULT_APP_KEY = "dingiw2xnv2sn0buaedk";
    public final static String DD_H5_CONSULT_APP_SECRET = "aZwljuGaTh-gXBQXKBq4P0i33U6vZ30E0pEcB5qrNdaHgEwlKsIeR_w-LH1pwcPT";
    public final static String DD_ACCESS_TOKEN_URL = "https://oapi.dingtalk.com/gettoken";
    public final static String DD_SEND_MESSAGE_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2";
    public final static String DD_RESPONSE_SUCESS = "成功";
    public final static String DD_RESPONSE_agree = "agree";
    public final static String DD_RESPONSE_refuse = "refuse";
    public final static String DD_RESPONSE_COMPLETED = "COMPLETED";

    public final static String DD_RESPONSE_AMOUNTNAME = "金额（元）";

    public final static String DD_RESPONSE_LAST_AMOUNT = "垫资金额（元）";
    public final static String DD_RESPONSE_NEXT_AMOUNT = "批贷金额（元）";
    public final static String DD_RESPONSE_COMMENTS = "备注";
    public final static String DD_RESPONSE_USEDATE = "用款日期";
    public final static String DD_RESPONSE_DAYS_USING = "用款天数";
    public final static String DD_RESPONSE_NEXT_ORGAN = "下家机构";
    public final static String DD_RESPONSE_LAST_ORGAN = "上家机构";
    public final static String DD_RESPONSE_CUSTOMER_NAME = "姓名";
    public final static String DD_RESPONSE_CERTI_PIC = "产权人身份证";
    public final static String DD_RESPONSE_MATE_CERTI_PIC = "配偶身份证";
    public final static String DD_RESPONSE_MARRY_PIC = "结婚证";
    public final static String DD_RESPONSE_HUKOU_PIC = "户口本";
    public final static String DD_RESPONSE_CRIDET_PIC = "征信报告";
    public final static String DD_RESPONSE_HOUSE_PIC = "房产证";
    public final static String DD_RESPONSE_BUSI_TYPE = "业务类型";
    public final static String DD_RESPONSE_PROD_TYPE = "产品类型";

    public final static long DD_RESPONSE_SALES_DEPT = 113208476L;

    public final static int BUSI_TYPE_2 = 2;

    public final static int INPUT_CAN_MODIFY = 1;
    public final static int INPUT_CAN_NOT_MODIFY = 2;
    public final static int INPUT_NEED = 1;
    public final static int INPUT_DONOT_NEED = 2;

    public final static int CERTIFICATE_OPT_TYPE_BORROW = 1;
    public final static int CERTIFICATE_OPT_TYPE_REVERT = 2;

    public final static int CUST_RELATION_PROPERTY = 8;


}
