package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.entity.DataModel;

import java.util.ArrayList;
import java.util.List;

public class TotalEntityData {
    public static void main(String[] args) {

        //销售人员
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("sales");
//        dataModel.setTableNames("agent");
//        dataModel.setColumnNameCh("姓名");
//        dataModel.setColumnNameEn("name");
//        dataModel.setColumnType(3);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("业务类型");
//        dataModel1.setColumnNameEn("businessType");
//        dataModel1.setColumnType(1);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(1);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(1);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("渠道类型");
//        dataModel2.setColumnNameEn("channelType");
//        dataModel2.setColumnType(1);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(1);
//        dataModel2.setIfSearchColumn(1);
//        dataModel2.setIfShowColumn(0);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("员工号");
//        dataModel3.setColumnNameEn("employeeCode");
//        dataModel3.setColumnType(3);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(0);
//        dataModel3.setIfSearchColumn(0);
//        dataModel3.setIfShowColumn(0);
//        dataModel3.setIfModifyable(0);
//        dataModels.add(dataModel3);
//
//        DataModel dataModel4 = new DataModel();
//        dataModel4.setColumnNameCh("银行账号");
//        dataModel4.setColumnNameEn("bankCode");
//        dataModel4.setColumnType(3);
//        dataModel4.setIfBusinessDate(0);
//        dataModel4.setIfScatter(0);
//        dataModel4.setIfSearchColumn(0);
//        dataModel4.setIfShowColumn(0);
//        dataModel4.setIfModifyable(1);
//        dataModels.add(dataModel4);
//
//        DataModel dataModel5 = new DataModel();
//        dataModel5.setColumnNameCh("合作开始日期");
          //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel5.setColumnNameEn("cooperateBeginDate");
//        dataModel5.setColumnType(4);
//        dataModel5.setIfBusinessDate(1);
//        dataModel5.setIfScatter(0);
//        dataModel5.setIfSearchColumn(0);
//        dataModel5.setIfShowColumn(0);
//        dataModel5.setIfModifyable(1);
//        dataModels.add(dataModel5);
//
//        DataModel dataModel6 = new DataModel();
//        dataModel6.setColumnNameCh("合作结束日期");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel6.setColumnNameEn("cooperateEndDate");
//        dataModel6.setColumnType(4);
//        dataModel6.setIfBusinessDate(1);
//        dataModel6.setIfScatter(0);
//        dataModel6.setIfSearchColumn(0);
//        dataModel6.setIfShowColumn(0);
//        dataModel6.setIfModifyable(1);
//        dataModels.add(dataModel6);
//
//        DataModel dataModel7 = new DataModel();
//        dataModel7.setColumnNameCh("生份证号");
//        dataModel7.setColumnNameEn("centiCode");
//        dataModel7.setColumnType(3);
//        dataModel7.setIfBusinessDate(0);
//        dataModel7.setIfScatter(0);
//        dataModel7.setIfSearchColumn(1);
//        dataModel7.setIfShowColumn(0);
//        dataModel7.setIfModifyable(1);
//        dataModels.add(dataModel7);
//
//        DataModel dataModel8 = new DataModel();
//        dataModel8.setColumnNameCh("手机号");
//        dataModel8.setColumnNameEn("phoneNO");
//        dataModel8.setColumnType(3);
//        dataModel8.setIfBusinessDate(0);
//        dataModel8.setIfScatter(0);
//        dataModel8.setIfSearchColumn(1);
//        dataModel8.setIfShowColumn(1);
//        dataModel8.setIfModifyable(1);
//        dataModels.add(dataModel8);
//
//        DataModel dataModel9 = new DataModel();
//        dataModel9.setColumnNameCh("公司名");
//        dataModel9.setColumnNameEn("companyName");
//        dataModel9.setColumnType(3);
//        dataModel9.setIfBusinessDate(0);
//        dataModel9.setIfScatter(0);
//        dataModel9.setIfSearchColumn(1);
//        dataModel9.setIfShowColumn(1);
//        dataModel9.setIfModifyable(1);
//        dataModels.add(dataModel9);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("用户名");
//        dataModel10.setColumnNameEn("userName");
//        dataModel10.setColumnType(3);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(1);
//        dataModel10.setIfShowColumn(0);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel11 = new DataModel();
//        dataModel11.setColumnNameCh("从业年限");
//        dataModel11.setColumnNameEn("jobYears");
//        dataModel11.setColumnType(1);
//        dataModel11.setIfBusinessDate(0);
//        dataModel11.setIfScatter(0);
//        dataModel11.setIfSearchColumn(1);
//        dataModel11.setIfShowColumn(0);
//        dataModel11.setIfModifyable(1);
//        dataModels.add(dataModel11);

//        //员工信息
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("hr");
//        dataModel.setTableNames("employee");
//        dataModel.setColumnNameCh("姓名");
//        dataModel.setColumnNameEn("name");
//        dataModel.setColumnType(3);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("生日");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel1.setColumnNameEn("birthday");
//        dataModel1.setColumnType(4);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(0);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(0);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("证件号码");
//        dataModel2.setColumnNameEn("certiCode");
//        dataModel2.setColumnType(3);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(0);
//        dataModel2.setIfShowColumn(0);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("城市");
//        dataModel3.setColumnNameEn("city");
//        dataModel3.setColumnType(1);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(1);
//        dataModel3.setIfSearchColumn(1);
//        dataModel3.setIfShowColumn(0);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);
//
//        DataModel dataModel4 = new DataModel();
//        dataModel4.setColumnNameCh("所在部门");
//        dataModel4.setColumnNameEn("dept");
//        dataModel4.setColumnType(1);
//        dataModel4.setIfBusinessDate(0);
//        dataModel4.setIfScatter(1);
//        dataModel4.setIfSearchColumn(1);
//        dataModel4.setIfShowColumn(1);
//        dataModel4.setIfModifyable(1);
//        dataModels.add(dataModel4);
//
//        DataModel dataModel5 = new DataModel();
//        dataModel5.setColumnNameCh("管理职级");
//        dataModel5.setColumnNameEn("manageGrade");
//        dataModel5.setColumnType(1);
//        dataModel5.setIfBusinessDate(0);
//        dataModel5.setIfScatter(1);
//        dataModel5.setIfSearchColumn(1);
//        dataModel5.setIfShowColumn(0);
//        dataModel5.setIfModifyable(1);
//        dataModels.add(dataModel5);
//
//        DataModel dataModel6 = new DataModel();
//        dataModel6.setColumnNameCh("薪酬");
//        dataModel6.setColumnNameEn("salary");
//        dataModel6.setColumnType(5);
//        dataModel6.setIfBusinessDate(0);
//        dataModel6.setIfScatter(0);
//        dataModel6.setIfSearchColumn(0);
//        dataModel6.setIfShowColumn(0);
//        dataModel6.setIfModifyable(1);
//        dataModels.add(dataModel6);
//
//        DataModel dataModel7 = new DataModel();
//        dataModel7.setColumnNameCh("技术职级");
//        dataModel7.setColumnNameEn("techGrade");
//        dataModel7.setColumnType(1);
//        dataModel7.setIfBusinessDate(0);
//        dataModel7.setIfScatter(1);
//        dataModel7.setIfSearchColumn(1);
//        dataModel7.setIfShowColumn(1);
//        dataModel7.setIfModifyable(1);
//        dataModels.add(dataModel7);
//
//        DataModel dataModel8 = new DataModel();
//        dataModel8.setColumnNameCh("雇佣时间");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel8.setColumnNameEn("hiredate");
//        dataModel8.setColumnType(4);
//        dataModel8.setIfBusinessDate(0);
//        dataModel8.setIfScatter(0);
//        dataModel8.setIfSearchColumn(0);
//        dataModel8.setIfShowColumn(0);
//        dataModel8.setIfModifyable(1);
//        dataModels.add(dataModel8);
//
//        DataModel dataModel9 = new DataModel();
//        dataModel9.setColumnNameCh("离职时间");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel9.setColumnNameEn("leavedate");
//        dataModel9.setColumnType(4);
//        dataModel9.setIfBusinessDate(0);
//        dataModel9.setIfScatter(0);
//        dataModel9.setIfSearchColumn(0);
//        dataModel9.setIfShowColumn(0);
//        dataModel9.setIfModifyable(1);
//        dataModels.add(dataModel9);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("电话");
//        dataModel10.setColumnNameEn("phone");
//        dataModel10.setColumnType(3);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(1);
//        dataModel10.setIfShowColumn(0);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel11 = new DataModel();
//        dataModel11.setColumnNameCh("家庭地址");
//        dataModel11.setColumnNameEn("address");
//        dataModel11.setColumnType(3);
//        dataModel11.setIfBusinessDate(0);
//        dataModel11.setIfScatter(0);
//        dataModel11.setIfSearchColumn(0);
//        dataModel11.setIfShowColumn(0);
//        dataModel11.setIfModifyable(1);
//        dataModels.add(dataModel11);
//
//        DataModel dataModel12 = new DataModel();
//        dataModel12.setColumnNameCh("银行卡号");
//        dataModel12.setColumnNameEn("cardNo");
//        dataModel12.setColumnType(3);
//        dataModel12.setIfBusinessDate(0);
//        dataModel12.setIfScatter(0);
//        dataModel12.setIfSearchColumn(0);
//        dataModel12.setIfShowColumn(0);
//        dataModel12.setIfModifyable(1);
//        dataModels.add(dataModel12);
//
//        DataModel dataModel13 = new DataModel();
//        dataModel13.setColumnNameCh("紧急联系人");
//        dataModel13.setColumnNameEn("emgName");
//        dataModel13.setColumnType(3);
//        dataModel13.setIfBusinessDate(0);
//        dataModel13.setIfScatter(0);
//        dataModel13.setIfSearchColumn(0);
//        dataModel13.setIfShowColumn(0);
//        dataModel13.setIfModifyable(1);
//        dataModels.add(dataModel13);
//
//        DataModel dataModel14 = new DataModel();
//        dataModel14.setColumnNameCh("紧急联系电话");
//        dataModel14.setColumnNameEn("emgPhone");
//        dataModel14.setColumnType(3);
//        dataModel14.setIfBusinessDate(0);
//        dataModel14.setIfScatter(0);
//        dataModel14.setIfSearchColumn(0);
//        dataModel14.setIfShowColumn(0);
//        dataModel14.setIfModifyable(1);
//        dataModels.add(dataModel14);
//
//        DataModel dataModel15 = new DataModel();
//        dataModel15.setColumnNameCh("岗位");
//        dataModel15.setColumnNameEn("position");
//        dataModel15.setColumnType(1);
//        dataModel15.setIfBusinessDate(0);
//        dataModel15.setIfScatter(1);
//        dataModel15.setIfSearchColumn(0);
//        dataModel15.setIfShowColumn(0);
//        dataModel15.setIfModifyable(1);
//        dataModels.add(dataModel15);
//        //客户信息
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("crm");
//        dataModel.setTableNames("cust");
//        dataModel.setColumnNameCh("姓名");
//        dataModel.setColumnNameEn("name");
//        dataModel.setColumnType(3);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("生日");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel1.setColumnNameEn("birthday");
//        dataModel1.setColumnType(4);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(0);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(0);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("证件号码");
//        dataModel2.setColumnNameEn("certiCode");
//        dataModel2.setColumnType(3);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(0);
//        dataModel2.setIfShowColumn(0);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("电话");
//        dataModel10.setColumnNameEn("phone");
//        dataModel10.setColumnType(3);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(1);
//        dataModel10.setIfShowColumn(0);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("城市");
//        dataModel3.setColumnNameEn("city");
//        dataModel3.setColumnType(1);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(1);
//        dataModel3.setIfSearchColumn(1);
//        dataModel3.setIfShowColumn(0);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);
//
//        DataModel dataModel11 = new DataModel();
//        dataModel11.setColumnNameCh("家庭地址");
//        dataModel11.setColumnNameEn("address");
//        dataModel11.setColumnType(3);
//        dataModel11.setIfBusinessDate(0);
//        dataModel11.setIfScatter(0);
//        dataModel11.setIfSearchColumn(0);
//        dataModel11.setIfShowColumn(0);
//        dataModel11.setIfModifyable(1);
//        dataModels.add(dataModel11);
//
//        DataModel dataModel12 = new DataModel();
//        dataModel12.setColumnNameCh("银行卡号");
//        dataModel12.setColumnNameEn("cardNo");
//        dataModel12.setColumnType(3);
//        dataModel12.setIfBusinessDate(0);
//        dataModel12.setIfScatter(0);
//        dataModel12.setIfSearchColumn(0);
//        dataModel12.setIfShowColumn(0);
//        dataModel12.setIfModifyable(1);
//        dataModels.add(dataModel12);
//
//        DataModel dataModel4 = new DataModel();
//        dataModel4.setColumnNameCh("性别");
//        dataModel4.setColumnNameEn("sex");
//        dataModel4.setColumnType(1);
//        dataModel4.setIfBusinessDate(0);
//        dataModel4.setIfScatter(1);
//        dataModel4.setIfSearchColumn(1);
//        dataModel4.setIfShowColumn(0);
//        dataModel4.setIfModifyable(1);
//        dataModels.add(dataModel4);
//
//        DataModel dataModel5 = new DataModel();
//        dataModel5.setColumnNameCh("销售状态");
//        //是准客户、在服务客户、已服务客户
//        dataModel5.setColumnNameEn("salesState");
//        dataModel5.setColumnType(1);
//        dataModel5.setIfBusinessDate(0);
//        dataModel5.setIfScatter(1);
//        dataModel5.setIfSearchColumn(1);
//        dataModel5.setIfShowColumn(0);
//        dataModel5.setIfModifyable(1);
//        dataModels.add(dataModel5);
//
//        DataModel dataModel6 = new DataModel();
//        dataModel6.setColumnNameCh("信息来源");
//        //1、陌拜客户；2、互联网客户；3、电话筛客户；4、朋友介绍；
//        dataModel6.setColumnNameEn("infoOriginal");
//        dataModel6.setColumnType(1);
//        dataModel6.setIfBusinessDate(0);
//        dataModel6.setIfScatter(1);
//        dataModel6.setIfSearchColumn(1);
//        dataModel6.setIfShowColumn(0);
//        dataModel6.setIfModifyable(1);
//        dataModels.add(dataModel6);
//
//        DataModel dataModel7 = new DataModel();
//        dataModel7.setColumnNameCh("用钱目的");
//        //1、做生意；2、垫资过桥；3、二抵；
//        dataModel7.setColumnNameEn("whyBorrow");
//        dataModel7.setColumnType(1);
//        dataModel7.setIfBusinessDate(0);
//        dataModel7.setIfScatter(1);
//        dataModel7.setIfSearchColumn(1);
//        dataModel7.setIfShowColumn(0);
//        dataModel7.setIfModifyable(1);
//        dataModels.add(dataModel7);
//
//        DataModel dataModel8 = new DataModel();
//        dataModel8.setColumnNameCh("职业");
//        dataModel8.setColumnNameEn("job");
//        dataModel8.setColumnType(1);
//        dataModel8.setIfBusinessDate(0);
//        dataModel8.setIfScatter(1);
//        dataModel8.setIfSearchColumn(1);
//        dataModel8.setIfShowColumn(0);
//        dataModel8.setIfModifyable(1);
//        dataModels.add(dataModel8);
//
//        DataModel dataModel9 = new DataModel();
//        dataModel9.setColumnNameCh("是否是新股东");
//        dataModel9.setColumnNameEn("isNewStockholder");
//        dataModel9.setColumnType(1);
//        dataModel9.setIfBusinessDate(0);
//        dataModel9.setIfScatter(1);
//        dataModel9.setIfSearchColumn(0);
//        dataModel9.setIfShowColumn(0);
//        dataModel9.setIfModifyable(1);
//        dataModels.add(dataModel9);
//
//        DataModel dataModel13 = new DataModel();
//        dataModel13.setColumnNameCh("成为新股东月数");
//        dataModel13.setColumnNameEn("beStockholderMonths");
//        dataModel13.setColumnType(1);
//        dataModel13.setIfBusinessDate(0);
//        dataModel13.setIfScatter(0);
//        dataModel13.setIfSearchColumn(0);
//        dataModel13.setIfShowColumn(0);
//        dataModel13.setIfModifyable(1);
//        dataModels.add(dataModel13);
        //财务收付费表
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("finance");
//        dataModel.setTableNames("payment");
//        dataModel.setColumnNameCh("收付费");
//        dataModel.setColumnNameEn("inOut");
//        dataModel.setColumnType(1);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(1);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("金额");
//        dataModel1.setColumnNameEn("amount");
//        dataModel1.setColumnType(5);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(0);
//        dataModel1.setIfSearchColumn(0);
//        dataModel1.setIfShowColumn(0);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("公司银行卡");
//        dataModel2.setColumnNameEn("compCardNo");
//        dataModel2.setColumnType(3);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(0);
//        dataModel2.setIfShowColumn(0);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("对方银行卡号");
//        dataModel10.setColumnNameEn("otherCardNo");
//        dataModel10.setColumnType(3);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(0);
//        dataModel10.setIfShowColumn(0);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("费用类型");
//        dataModel3.setColumnNameEn("payType");
//        dataModel3.setColumnType(1);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(1);
//        dataModel3.setIfSearchColumn(1);
//        dataModel3.setIfShowColumn(0);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);
//
//        DataModel dataModel11 = new DataModel();
//        dataModel11.setColumnNameCh("订单号");
//        dataModel11.setColumnNameEn("orderId");
//        dataModel11.setColumnType(1);
//        dataModel11.setIfBusinessDate(0);
//        dataModel11.setIfScatter(0);
//        dataModel11.setIfSearchColumn(0);
//        dataModel11.setIfShowColumn(0);
//        dataModel11.setIfModifyable(0);
//        dataModels.add(dataModel11);
//
//        DataModel dataModel12 = new DataModel();
//        dataModel12.setColumnNameCh("支付日期");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel12.setColumnNameEn("payDate");
//        dataModel12.setColumnType(4);
//        dataModel12.setIfBusinessDate(1);
//        dataModel12.setIfScatter(0);
//        dataModel12.setIfSearchColumn(1);
//        dataModel12.setIfShowColumn(1);
//        dataModel12.setIfModifyable(1);
//        dataModels.add(dataModel12);
//
//        DataModel dataModel4 = new DataModel();
//        dataModel4.setColumnNameCh("出纳");
//        dataModel4.setColumnNameEn("operatorId");
//        dataModel4.setColumnType(1);
//        dataModel4.setIfBusinessDate(0);
//        dataModel4.setIfScatter(0);
//        dataModel4.setIfSearchColumn(0);
//        dataModel4.setIfShowColumn(0);
//        dataModel4.setIfModifyable(0);
//        dataModels.add(dataModel4);
//
//        DataModel dataModel5 = new DataModel();
//        dataModel5.setColumnNameCh("对方姓名");
//        //是准客户、在服务客户、已服务客户
//        dataModel5.setColumnNameEn("accountName");
//        dataModel5.setColumnType(3);
//        dataModel5.setIfBusinessDate(0);
//        dataModel5.setIfScatter(0);
//        dataModel5.setIfSearchColumn(1);
//        dataModel5.setIfShowColumn(1);
//        dataModel5.setIfModifyable(1);
//        dataModels.add(dataModel5);
//
//        DataModel dataModel6 = new DataModel();
//        dataModel6.setColumnNameCh("支付状态");
//        //0、待支付；1、支付中；2、支付成功；3、支付失败
//        dataModel6.setColumnNameEn("payState");
//        dataModel6.setColumnType(1);
//        dataModel6.setIfBusinessDate(0);
//        dataModel6.setIfScatter(1);
//        dataModel6.setIfSearchColumn(1);
//        dataModel6.setIfShowColumn(0);
//        dataModel6.setIfModifyable(0);
//        dataModels.add(dataModel6);
//
//        DataModel dataModel7 = new DataModel();
//        dataModel7.setColumnNameCh("类型");
//        //1、应收付；2、实收付
//        dataModel7.setColumnNameEn("payDataType");
//        dataModel7.setColumnType(1);
//        dataModel7.setIfBusinessDate(0);
//        dataModel7.setIfScatter(1);
//        dataModel7.setIfSearchColumn(1);
//        dataModel7.setIfShowColumn(0);
//        dataModel7.setIfModifyable(0);
//        dataModels.add(dataModel7);
        //任务管理
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("mis");
//        dataModel.setTableNames("task");
//        dataModel.setColumnNameCh("任务名");
//        dataModel.setColumnNameEn("taskName");
//        dataModel.setColumnType(3);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("任务类型");
//        //1、业务任务；2、日常任务；
//        dataModel1.setColumnNameEn("type");
//        dataModel1.setColumnType(1);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(1);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(0);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("任务描述");
//        dataModel2.setColumnNameEn("taskDesc");
//        dataModel2.setColumnType(3);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(0);
//        dataModel2.setIfShowColumn(0);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel6 = new DataModel();
//        dataModel6.setColumnNameCh("任务周期");
//        dataModel6.setColumnNameEn("taskPeriod");
//        dataModel6.setColumnType(1);
//        dataModel6.setIfBusinessDate(0);
//        dataModel6.setIfScatter(1);
//        dataModel6.setIfSearchColumn(1);
//        dataModel6.setIfShowColumn(0);
//        dataModel6.setIfModifyable(1);
//        dataModels.add(dataModel6);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("开始时间");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel10.setColumnNameEn("beginDate");
//        dataModel10.setColumnType(4);
//        dataModel10.setIfBusinessDate(1);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(0);
//        dataModel10.setIfShowColumn(0);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("结束时间");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel3.setColumnNameEn("endDate");
//        dataModel3.setColumnType(1);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(1);
//        dataModel3.setIfSearchColumn(0);
//        dataModel3.setIfShowColumn(1);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);
//
//        DataModel dataModel11 = new DataModel();
//        dataModel11.setColumnNameCh("任务负责人");
//        dataModel11.setColumnNameEn("employeeId");
//        dataModel11.setColumnType(1);
//        dataModel11.setIfBusinessDate(0);
//        dataModel11.setIfScatter(0);
//        dataModel11.setIfSearchColumn(0);
//        dataModel11.setIfShowColumn(0);
//        dataModel11.setIfModifyable(1);
//        dataModels.add(dataModel11);
//
//        DataModel dataModel12 = new DataModel();
//        dataModel12.setColumnNameCh("任务目标");
//        dataModel12.setColumnNameEn("amount");
//        dataModel12.setColumnType(5);
//        dataModel12.setIfBusinessDate(1);
//        dataModel12.setIfScatter(0);
//        dataModel12.setIfSearchColumn(0);
//        dataModel12.setIfShowColumn(1);
//        dataModel12.setIfModifyable(1);
//        dataModels.add(dataModel12);
//
//        DataModel dataModel4 = new DataModel();
//        dataModel4.setColumnNameCh("任务状态");
//        dataModel4.setColumnNameEn("taskState");
//        dataModel4.setColumnType(1);
//        dataModel4.setIfBusinessDate(0);
//        dataModel4.setIfScatter(1);
//        dataModel4.setIfSearchColumn(1);
//        dataModel4.setIfShowColumn(1);
//        dataModel4.setIfModifyable(1);
//        dataModels.add(dataModel4);
//
//        DataModel dataModel5 = new DataModel();
//        dataModel5.setColumnNameCh("完成数量");
//        //是准客户、在服务客户、已服务客户
//        dataModel5.setColumnNameEn("completeAmount");
//        dataModel5.setColumnType(5);
//        dataModel5.setIfBusinessDate(0);
//        dataModel5.setIfScatter(0);
//        dataModel5.setIfSearchColumn(0);
//        dataModel5.setIfShowColumn(1);
//        dataModel5.setIfModifyable(1);
//        dataModels.add(dataModel5);

//        产品
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("cbs");
//        dataModel.setTableNames("product");
//        dataModel.setColumnNameCh("产品名称");
//        dataModel.setColumnNameEn("productName");
//        dataModel.setColumnType(3);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("银行");
//        dataModel1.setColumnNameEn("bankId");
//        dataModel1.setColumnType(1);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(1);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(0);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("产品类型");
//        dataModel2.setColumnNameEn("productType");
//        dataModel2.setColumnType(1);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(1);
//        dataModel2.setIfSearchColumn(1);
//        dataModel2.setIfShowColumn(0);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("产品手续费");
//        dataModel3.setColumnNameEn("brokerage");
//        dataModel3.setColumnType(5);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(0);
//        dataModel3.setIfSearchColumn(0);
//        dataModel3.setIfShowColumn(0);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);
//
//        DataModel dataModel4 = new DataModel();
//        dataModel4.setColumnNameCh("产品利息");
//        dataModel4.setColumnNameEn("interest");
//        dataModel4.setColumnType(5);
//        dataModel4.setIfBusinessDate(0);
//        dataModel4.setIfScatter(0);
//        dataModel4.setIfSearchColumn(0);
//        dataModel4.setIfShowColumn(0);
//        dataModel4.setIfModifyable(1);
//        dataModels.add(dataModel4);
//
//        //对公司而言是支出利息，还是收入利息
//        DataModel dataModel5 = new DataModel();
//        dataModel5.setColumnNameCh("利息方向");
//        dataModel5.setColumnNameEn("interestWay");
//        dataModel5.setColumnType(1);
//        dataModel5.setIfBusinessDate(0);
//        dataModel5.setIfScatter(1);
//        dataModel5.setIfSearchColumn(1);
//        dataModel5.setIfShowColumn(0);
//        dataModel5.setIfModifyable(1);
//        dataModels.add(dataModel5);
//
//        DataModel dataModel6 = new DataModel();
//        dataModel6.setColumnNameCh("产品状态");
//        dataModel6.setColumnNameEn("productState");
//        dataModel6.setColumnType(1);
//        dataModel6.setIfBusinessDate(0);
//        dataModel6.setIfScatter(1);
//        dataModel6.setIfSearchColumn(0);
//        dataModel6.setIfShowColumn(0);
//        dataModel6.setIfModifyable(1);
//        dataModels.add(dataModel6);
//
//        DataModel dataModel7 = new DataModel();
//        dataModel7.setColumnNameCh("产品律师费");
//        dataModel7.setColumnNameEn("lawFee");
//        dataModel7.setColumnType(5);
//        dataModel7.setIfBusinessDate(0);
//        dataModel7.setIfScatter(0);
//        dataModel7.setIfSearchColumn(0);
//        dataModel7.setIfShowColumn(0);
//        dataModel7.setIfModifyable(1);
//        dataModels.add(dataModel7);
//
//        DataModel dataModel8 = new DataModel();
//        dataModel8.setColumnNameCh("产品公正费");
//        dataModel8.setColumnNameEn("fairFee");
//        dataModel8.setColumnType(5);
//        dataModel8.setIfBusinessDate(0);
//        dataModel8.setIfScatter(0);
//        dataModel8.setIfSearchColumn(0);
//        dataModel8.setIfShowColumn(0);
//        dataModel8.setIfModifyable(1);
//        dataModels.add(dataModel8);
//
//        DataModel dataModel9 = new DataModel();
//        dataModel9.setColumnNameCh("产品执照费");
//        dataModel9.setColumnNameEn("licenseFee");
//        dataModel9.setColumnType(5);
//        dataModel9.setIfBusinessDate(0);
//        dataModel9.setIfScatter(0);
//        dataModel9.setIfSearchColumn(0);
//        dataModel9.setIfShowColumn(0);
//        dataModel9.setIfModifyable(1);
//        dataModels.add(dataModel9);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("开始时间");
//        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel10.setColumnNameEn("beginDate");
//        dataModel10.setColumnType(4);
//        dataModel10.setIfBusinessDate(1);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(0);
//        dataModel10.setIfShowColumn(0);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel11 = new DataModel();
//        dataModel11.setColumnNameCh("结束时间");
//        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel11.setColumnNameEn("endDate");
//        dataModel11.setColumnType(4);
//        dataModel11.setIfBusinessDate(0);
//        dataModel11.setIfScatter(0);
//        dataModel11.setIfSearchColumn(0);
//        dataModel11.setIfShowColumn(0);
//        dataModel11.setIfModifyable(1);
//        dataModels.add(dataModel11);


//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("finance");
//        dataModel.setTableNames("account");
//        dataModel.setColumnNameCh("账号名");
//        dataModel.setColumnNameEn("accountNames");
//        dataModel.setColumnType(3);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("账号");
//        dataModel1.setColumnNameEn("amountNo");
//        dataModel1.setColumnType(3);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(0);
//        dataModel1.setIfSearchColumn(0);
//        dataModel1.setIfShowColumn(1);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("银行");
//        dataModel2.setColumnNameEn("bank");
//        dataModel2.setColumnType(1);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(1);
//        dataModel2.setIfSearchColumn(1);
//        dataModel2.setIfShowColumn(1);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("账号状态");
//        dataModel10.setColumnNameEn("accountState");
//        dataModel10.setColumnType(1);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(1);
//        dataModel10.setIfSearchColumn(0);
//        dataModel10.setIfShowColumn(0);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("公司");
//        dataModel3.setColumnNameEn("company");
//        dataModel3.setColumnType(1);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(1);
//        dataModel3.setIfSearchColumn(0);
//        dataModel3.setIfShowColumn(0);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);
          //提成配置
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("sales");
//        dataModel.setTableNames("commission");
          //1、抵押贷；2、居间业务；3、垫资过桥
//        dataModel.setColumnNameCh("业务类型");
//        dataModel.setColumnNameEn("businessType");
//        dataModel.setColumnType(1);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(1);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
          //1、无关；2、
//        dataModel1.setColumnNameCh("产品类型");
//        dataModel1.setColumnNameEn("productType");
//        dataModel1.setColumnType(1);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(1);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(1);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("产品");
//        dataModel2.setColumnNameEn("productId");
//        dataModel2.setColumnType(1);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(1);
//        dataModel2.setIfShowColumn(1);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("销售等级");
//        //1、普通销售；2、团队负责人；3、部门负责人
//        dataModel3.setColumnNameEn("level");
//        dataModel3.setColumnType(1);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(1);
//        dataModel3.setIfSearchColumn(0);
//        dataModel3.setIfShowColumn(0);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);
//
//        DataModel dataModel4 = new DataModel();
//        dataModel4.setColumnNameCh("提成人员");
//        //1、销售提成；2、服务提成；3、风控提成
//        dataModel4.setColumnNameEn("type");
//        dataModel4.setColumnType(1);
//        dataModel4.setIfBusinessDate(0);
//        dataModel4.setIfScatter(1);
//        dataModel4.setIfSearchColumn(0);
//        dataModel4.setIfShowColumn(0);
//        dataModel4.setIfModifyable(1);
//        dataModels.add(dataModel4);
//
//        DataModel dataModel5 = new DataModel();
//        dataModel5.setColumnNameCh("提成方式");
//        //1、简单比例；2、累进比例（比如超过100万，全量按照10%）；3、累进（超过100万，超过部分10%，未超过部分5%）
//        dataModel5.setColumnNameEn("way");
//        dataModel5.setColumnType(1);
//        dataModel5.setIfBusinessDate(0);
//        dataModel5.setIfScatter(1);
//        dataModel5.setIfSearchColumn(0);
//        dataModel5.setIfShowColumn(0);
//        dataModel5.setIfModifyable(1);
//        dataModels.add(dataModel5);
//
//        DataModel dataModel6 = new DataModel();
//        dataModel6.setColumnNameCh("提成比例");
//        dataModel6.setColumnNameEn("percent");
//        dataModel6.setColumnType(5);
//        dataModel6.setIfBusinessDate(0);
//        dataModel6.setIfScatter(0);
//        dataModel6.setIfSearchColumn(0);
//        dataModel6.setIfShowColumn(0);
//        dataModel6.setIfModifyable(1);
//        dataModels.add(dataModel6);
//
//        DataModel dataModel7 = new DataModel();
//        dataModel7.setColumnNameCh("累进阶段");
//        dataModel7.setColumnNameEn("sum");
//        dataModel7.setColumnType(5);
//        dataModel7.setIfBusinessDate(0);
//        dataModel7.setIfScatter(0);
//        dataModel7.setIfSearchColumn(0);
//        dataModel7.setIfShowColumn(0);
//        dataModel7.setIfModifyable(1);
//        dataModels.add(dataModel7);
//
//        DataModel dataModel8 = new DataModel();
//        dataModel8.setColumnNameCh("计算基础");
//        //1、放款额；2、客户手续费；
//        dataModel8.setColumnNameEn("baseType");
//        dataModel8.setColumnType(1);
//        dataModel8.setIfBusinessDate(0);
//        dataModel8.setIfScatter(1);
//        dataModel8.setIfSearchColumn(0);
//        dataModel8.setIfShowColumn(0);
//        dataModel8.setIfModifyable(1);
//        dataModels.add(dataModel8);
//
//        DataModel dataModel9 = new DataModel();
//        dataModel9.setColumnNameCh("渠道类型");
//        dataModel9.setColumnNameEn("channelType");
//        dataModel9.setColumnType(1);
//        dataModel9.setIfBusinessDate(0);
//        dataModel9.setIfScatter(1);
//        dataModel9.setIfSearchColumn(1);
//        dataModel9.setIfShowColumn(0);
//        dataModel9.setIfModifyable(1);
//        dataModels.add(dataModel9);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("开始日期");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel10.setColumnNameEn("startDate");
//        dataModel10.setColumnType(4);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(0);
//        dataModel10.setIfShowColumn(0);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel11 = new DataModel();
//        dataModel11.setColumnNameCh("结束日期");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel11.setColumnNameEn("endDate");
//        dataModel11.setColumnType(4);
//        dataModel11.setIfBusinessDate(0);
//        dataModel11.setIfScatter(0);
//        dataModel11.setIfSearchColumn(0);
//        dataModel11.setIfShowColumn(0);
//        dataModel11.setIfModifyable(1);
//        dataModels.add(dataModel11);

          //薪酬管理
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("hr");
//        dataModel.setTableNames("salary");
//        dataModel.setColumnNameCh("员工号");
//        dataModel.setColumnNameEn("empId");
//        dataModel.setColumnType(1);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(0);
//        dataModel.setIfShowColumn(0);
//        dataModel.setIfModifyable(0);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("员工名称");
//        dataModel1.setColumnNameEn("empName");
//        dataModel1.setColumnType(3);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(0);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(1);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("年月");
//        //注意：不能用yearMonth，mysql的关键字
//        dataModel2.setColumnNameEn("month");
//        dataModel2.setColumnType(3);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(1);
//        dataModel2.setIfShowColumn(0);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("基本薪酬");
//        dataModel10.setColumnNameEn("basicSalary");
//        dataModel10.setColumnType(5);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(0);
//        dataModel10.setIfShowColumn(1);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("当月薪酬");
//        dataModel3.setColumnNameEn("currentSalary");
//        dataModel3.setColumnType(5);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(0);
//        dataModel3.setIfSearchColumn(0);
//        dataModel3.setIfShowColumn(1);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);
//
//        DataModel dataModel4 = new DataModel();
//        dataModel4.setColumnNameCh("发放状态");
//        //1、已计算；2、核对；3、发放中；4、已经发放；
//        dataModel4.setColumnNameEn("extendState");
//        dataModel4.setColumnType(1);
//        dataModel4.setIfBusinessDate(0);
//        dataModel4.setIfScatter(1);
//        dataModel4.setIfSearchColumn(1);
//        dataModel4.setIfShowColumn(1);
//        dataModel4.setIfModifyable(1);
//        dataModels.add(dataModel4);
//
//        DataModel dataModel5 = new DataModel();
//        dataModel5.setColumnNameCh("发放时间");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel5.setColumnNameEn("extendDate");
//        dataModel5.setColumnType(4);
//        dataModel5.setIfBusinessDate(1);
//        dataModel5.setIfScatter(0);
//        dataModel5.setIfSearchColumn(0);
//        dataModel5.setIfShowColumn(0);
//        dataModel5.setIfModifyable(1);
//        dataModels.add(dataModel5);

        //客服工单
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("cs");
//        dataModel.setTableNames("workOrder");
//        dataModel.setColumnNameCh("工单名称");
//        dataModel.setColumnNameEn("csName");
//        dataModel.setColumnType(3);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("工单类型");
//        //1、回访工单；2、补充资料工单；3、客户投诉工单；4、客户通知工单
//        dataModel1.setColumnNameEn("cstype");
//        dataModel1.setColumnType(1);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(1);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(1);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("工单描述");
//        //注意：不能用yearMonth，mysql的关键字
//        dataModel2.setColumnNameEn("csDesc");
//        dataModel2.setColumnType(3);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(0);
//        dataModel2.setIfShowColumn(0);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("订单id");
//        dataModel10.setColumnNameEn("orderId");
//        dataModel10.setColumnType(2);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(1);
//        dataModel10.setIfShowColumn(1);
//        dataModel10.setIfModifyable(0);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("客户姓名");
//        dataModel3.setColumnNameEn("customerName");
//        dataModel3.setColumnType(3);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(0);
//        dataModel3.setIfSearchColumn(1);
//        dataModel3.setIfShowColumn(1);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);
//
//        DataModel dataModel4 = new DataModel();
//        dataModel4.setColumnNameCh("客户ID");
//        //1、已计算；2、核对；3、发放中；4、已经发放；
//        dataModel4.setColumnNameEn("customerId");
//        dataModel4.setColumnType(2);
//        dataModel4.setIfBusinessDate(0);
//        dataModel4.setIfScatter(0);
//        dataModel4.setIfSearchColumn(0);
//        dataModel4.setIfShowColumn(0);
//        dataModel4.setIfModifyable(0);
//        dataModels.add(dataModel4);
//
//        DataModel dataModel5 = new DataModel();
//        dataModel5.setColumnNameCh("处理状态");
//        dataModel5.setColumnNameEn("csState");
//        dataModel5.setColumnType(1);
//        dataModel5.setIfBusinessDate(0);
//        dataModel5.setIfScatter(1);
//        dataModel5.setIfSearchColumn(1);
//        dataModel5.setIfShowColumn(1);
//        dataModel5.setIfModifyable(1);
//        dataModels.add(dataModel5);

//        培训管理
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("hr");
//        dataModel.setTableNames("curriculum");
//        dataModel.setColumnNameCh("课程名称");
//        dataModel.setColumnNameEn("name");
//        dataModel.setColumnType(3);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("课程类型");
//        //1、销售技巧类；2、产品类；3、管理类
//        dataModel1.setColumnNameEn("type");
//        dataModel1.setColumnType(1);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(1);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(1);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("授课老师");
//        //注意：不能用yearMonth，mysql的关键字
//        dataModel2.setColumnNameEn("teacherName");
//        dataModel2.setColumnType(3);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(1);
//        dataModel2.setIfShowColumn(1);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("授课老师ID");
//        dataModel10.setColumnNameEn("empId");
//        dataModel10.setColumnType(1);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(0);
//        dataModel10.setIfShowColumn(0);
//        dataModel10.setIfModifyable(0);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("听课岗位");
//        dataModel3.setColumnNameEn("posId");
//        dataModel3.setColumnType(1);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(1);
//        dataModel3.setIfSearchColumn(1);
//        dataModel3.setIfShowColumn(1);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);

          //查询自己的业绩和提成
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("sales");
//        dataModel.setTableNames("PerformanceCommission");
//        dataModel.setColumnNameCh("销售ID");
//        dataModel.setColumnNameEn("agentId");
//        dataModel.setColumnType(2);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(0);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("年月");
//        dataModel1.setColumnNameEn("month");
//        dataModel1.setColumnType(3);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(0);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(1);
//        dataModel1.setIfModifyable(0);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("姓名");
//        //注意：不能用yearMonth，mysql的关键字
//        dataModel2.setColumnNameEn("agentName");
//        dataModel2.setColumnType(3);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(1);
//        dataModel2.setIfShowColumn(1);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("提成");
//        dataModel10.setColumnNameEn("commission");
//        dataModel10.setColumnType(5);
//        dataModel10.setIfBusinessDate(0);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(0);
//        dataModel10.setIfShowColumn(1);
//        dataModel10.setIfModifyable(1);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel11 = new DataModel();
//        dataModel11.setColumnNameCh("业绩");
//        dataModel11.setColumnNameEn("performance");
//        dataModel11.setColumnType(5);
//        dataModel11.setIfBusinessDate(0);
//        dataModel11.setIfScatter(0);
//        dataModel11.setIfSearchColumn(0);
//        dataModel11.setIfShowColumn(1);
//        dataModel11.setIfModifyable(1);
//        dataModels.add(dataModel11);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("核算发放进度");
//        //1、已核算；2、已确认；3、已发放；
//        dataModel3.setColumnNameEn("process");
//        dataModel3.setColumnType(1);
//        dataModel3.setIfBusinessDate(0);
//        dataModel3.setIfScatter(1);
//        dataModel3.setIfSearchColumn(1);
//        dataModel3.setIfShowColumn(1);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);

//        批处理配置
//        List<DataModel> dataModels = new ArrayList<DataModel>();
//        DataModel dataModel = new DataModel();
//        dataModel.setSysName("batch");
//        dataModel.setTableNames("job");
//        dataModel.setColumnNameCh("批处理名称");
//        dataModel.setColumnNameEn("batchName");
//        dataModel.setColumnType(3);
//        dataModel.setIfBusinessDate(0);
//        dataModel.setIfScatter(0);
//        dataModel.setIfSearchColumn(1);
//        dataModel.setIfShowColumn(1);
//        dataModel.setIfModifyable(1);
//        dataModels.add(dataModel);
//
//        DataModel dataModel1 = new DataModel();
//        dataModel1.setColumnNameCh("类型");
//        //1、按分钟；2、按小时；3、按天；4、按周；5、按月；6、按季度；7、按年
//        dataModel1.setColumnNameEn("type");
//        dataModel1.setColumnType(1);
//        dataModel1.setIfBusinessDate(0);
//        dataModel1.setIfScatter(1);
//        dataModel1.setIfSearchColumn(1);
//        dataModel1.setIfShowColumn(1);
//        dataModel1.setIfModifyable(1);
//        dataModels.add(dataModel1);
//
//        DataModel dataModel2 = new DataModel();
//        dataModel2.setColumnNameCh("周期数");
//        dataModel2.setColumnNameEn("periodNum");
//        dataModel2.setColumnType(1);
//        dataModel2.setIfBusinessDate(0);
//        dataModel2.setIfScatter(0);
//        dataModel2.setIfSearchColumn(0);
//        dataModel2.setIfShowColumn(1);
//        dataModel2.setIfModifyable(1);
//        dataModels.add(dataModel2);
//
//        DataModel dataModel10 = new DataModel();
//        dataModel10.setColumnNameCh("最后执行时间");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel10.setColumnNameEn("lastTime");
//        dataModel10.setColumnType(4);
//        dataModel10.setIfBusinessDate(1);
//        dataModel10.setIfScatter(0);
//        dataModel10.setIfSearchColumn(0);
//        dataModel10.setIfShowColumn(1);
//        dataModel10.setIfModifyable(0);
//        dataModels.add(dataModel10);
//
//        DataModel dataModel11 = new DataModel();
//        dataModel11.setColumnNameCh("上线时间");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel11.setColumnNameEn("startTime");
//        dataModel11.setColumnType(4);
//        dataModel11.setIfBusinessDate(1);
//        dataModel11.setIfScatter(0);
//        dataModel11.setIfSearchColumn(0);
//        dataModel11.setIfShowColumn(1);
//        dataModel11.setIfModifyable(1);
//        dataModels.add(dataModel11);
//
//        DataModel dataModel3 = new DataModel();
//        dataModel3.setColumnNameCh("下次执行时间");
//        //1、待执行；2、执行中
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
//        dataModel3.setColumnNameEn("nextTime");
//        dataModel3.setColumnType(4);
//        dataModel3.setIfBusinessDate(1);
//        dataModel3.setIfScatter(0);
//        dataModel3.setIfSearchColumn(1);
//        dataModel3.setIfShowColumn(1);
//        dataModel3.setIfModifyable(1);
//        dataModels.add(dataModel3);

    }
}
