package com.bangnd.batch.jobs.finance;

//生成账务
public class AccountingHandler {
    //期末结转利润时:
    //借：主营业务收入、其他业务收入、补贴收入、营业外收入；
    //    贷：本年利润
    //借：本年利润；
    //    贷：主营业务成本、主营业务税金及附加、其他业务支出、营业费用、管理费用、财务费用、营业外支出、所得税
    //1、年度终了时本科目为贷方余额，反映的是本年实现的净利润，这时应
    // 借：本年利润、贷：利润分配
    //2、年度终了时本科目为借方余额，反映的是本年发生净亏损，这时应
    // 借：利润分配、贷：本年利润

    //股东拿走利润的会计分录：
    //提取时：
    //借：利润分配--未分配利润
    //   贷：应付股利
    //支付时：
    //借：应付股利
    //   贷：银行存款
}