package com.bangnd.util.cfg;

public class ConstantCfg {

    public static final long CUSTOMER_IDENTITY_TYPE_1 = 1;
    public static final long CUSTOMER_IDENTITY_TYPE_2 = 2;
    public static final long CUSTOMER_IDENTITY_TYPE_3 = 3;
    public static final int ORDER_PRODUCT_STATE_DELETE = 100;
    public static final String ORDER_DOC_FIXED_PATH = "uploadfile/raw/byOrder/";
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

    //订单产品状态:费用已核算
    public final static int ORDER_PRODUCT_STATE_CACLED = 51;
    //订单产品状态:支付成功
    public final static int ORDER_PRODUCT_STATE_FINISHED = 7;
    //订单产品状态：已批贷
    public final static int ORDER_PRODUCT_STATE_APPROVED = 5;
    //每页显示条数
    public final static int NUM_PER_PAGE=10;

    //实收付
    public final static int IFE_REAL_1 = 1;
    //流入
    public final static int IN_OUT_1 = 1;
    //流出
    public final static int IN_OUT_2 = 2;

    //订单录入
    public final static int ORDER_ACTION_1=1;
    //上传资料
    public final static int ORDER_ACTION_2=2;
    //录入客户
    public final static int ORDER_ACTION_3=3;
    //添加产品
    public final static int ORDER_ACTION_4=4;


}
