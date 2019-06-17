package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.entity.DataModel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TotalCodeCreator {

    private String javaFilesPath = "/Users/wrh/Documents/wrh/work/gzx_app/src/main/java/com";
    private String htmlFilesPath = "/Users/wrh/Documents/wrh/work/gzx_app/src/main/resources/templates";

    public void create(List<DataModel> dataModels, String company, String sys, String entityName) {
        String UpEntityName = "";
        if (entityName != null && !"".equals(entityName)) {
            UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        }
        CfgEntityCreator cfgEntityCreator = new CfgEntityCreator();
        CfgServiceCreator cfgServiceCreator = new CfgServiceCreator();
        CfgServcieImplCreator cfgServiceImplCreator = new CfgServcieImplCreator();
        CfgRepositoryCreator cfgRepositoryCreator = new CfgRepositoryCreator();
        ControllerCreator controllerCreator = new ControllerCreator();
        EntityCreator entityCreator = new EntityCreator();
        HtmlAddCreator htmlAddCreator = new HtmlAddCreator();
        HtmlListCreator htmlListCreator = new HtmlListCreator();
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        SearchFormCreator searchFormCreator = new SearchFormCreator();
        ServiceCreator serviceCreator = new ServiceCreator();
        ServiceImplCreator serviceImplCreator = new ServiceImplCreator();
        ShowListVOCreator showListVOCreator = new ShowListVOCreator();


        if (dataModels != null) {
            for (DataModel dataModel : dataModels) {
                if (dataModel.getIfScatter() == 1) {
                    String columnNameEn = dataModel.getColumnNameEn();
                    String UpColumnName = Character.toUpperCase(columnNameEn.charAt(0)) + columnNameEn.substring(1);
                    String cfgEntityFileName = javaFilesPath + "/" + company + "/" + sys + "/entity/" + UpEntityName + UpColumnName + ".java";
                    createFileToPath(cfgEntityCreator.create(company, sys, entityName, dataModel.getColumnNameEn()), cfgEntityFileName);

                    String cfgServiceFileName = javaFilesPath + "/" + company + "/" + sys + "/service/" + UpEntityName + UpColumnName + "Service.java";
                    createFileToPath(cfgServiceCreator.create(company, sys, entityName, dataModel.getColumnNameEn()), cfgServiceFileName);

                    String cfgServiceImplFileName = javaFilesPath + "/" + company + "/" + sys + "/service/impl/" + UpEntityName + UpColumnName + "ServiceImpl.java";
                    createFileToPath(cfgServiceImplCreator.create(company, sys, entityName, dataModel.getColumnNameEn()), cfgServiceImplFileName);

                    String cfgRepositoryFileName = javaFilesPath + "/" + company + "/" + sys + "/repository/" + UpEntityName + UpColumnName + "Repository.java";
                    createFileToPath(cfgRepositoryCreator.create(company, sys, entityName, dataModel.getColumnNameEn()), cfgRepositoryFileName);

                }
            }
            String controllerFileName = javaFilesPath + "/" + company + "/" + sys + "/web/" + UpEntityName + "Controller.java";
            createFileToPath(controllerCreator.create(dataModels, company, sys, entityName), controllerFileName);

            String htmlAddFileName = htmlFilesPath + "/" + sys + "/" + entityName + "Add.html";
            createFileToPath(htmlAddCreator.create(dataModels, sys, entityName), htmlAddFileName);

            String htmlListFileName = htmlFilesPath + "/" + sys + "/" + entityName + "List.html";
            createFileToPath(htmlListCreator.create(dataModels, sys, entityName), htmlListFileName);

            String formFileName = javaFilesPath + "/" + company + "/" + sys + "/form/" + UpEntityName + "SearchForm.java";
            createFileToPath(searchFormCreator.create(dataModels, company, sys), formFileName);

            String voFileName = javaFilesPath + "/" + company + "/" + sys + "/vo/" + UpEntityName + "VO.java";
            createFileToPath(showListVOCreator.create(dataModels, company, sys), voFileName);


            String entityFileName = javaFilesPath + "/" + company + "/" + sys + "/entity/" + UpEntityName + ".java";
            createFileToPath(entityCreator.create(dataModels, company, sys), entityFileName);

            String repositoryFileName = javaFilesPath + "/" + company + "/" + sys + "/repository/" + UpEntityName + "Repository.java";
            createFileToPath(repositoryCreator.create(company, sys, entityName), repositoryFileName);

            String serviceFileName = javaFilesPath + "/" + company + "/" + sys + "/service/" + UpEntityName + "Service.java";
            createFileToPath(serviceCreator.create(company, sys, entityName), serviceFileName);

            String serviceImplFileName = javaFilesPath + "/" + company + "/" + sys + "/service/impl/" + UpEntityName + "ServiceImpl.java";
            createFileToPath(serviceImplCreator.create(dataModels, company, sys, entityName), serviceImplFileName);


        }
    }

    //将字符串生成文件，并发到自动位置
    public void createFileToPath(String text, String fileNameWithPath) {
        try {
            if (fileNameWithPath != null && !"".equals(fileNameWithPath)) {
                String dirName = fileNameWithPath.substring(0, fileNameWithPath.lastIndexOf("/"));

                File fileDir = new File(dirName);
                File file = new File(fileNameWithPath);

                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }

                if (!file.exists()) {
                    file.createNewFile();
                }

                //再将字符串写入到文件中
                FileOutputStream fos = new FileOutputStream(fileNameWithPath);
                fos.write(text.getBytes());
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<DataModel> dataModels = new ArrayList<DataModel>();
        DataModel dataModel = new DataModel();
        dataModel.setSysName("bridgecbs");
        dataModel.setTableNames("bridgeOrder");

        dataModel.setColumnNameCh("订单名称");
        dataModel.setColumnNameEn("projectName");
        dataModel.setColumnType(3);
        dataModel.setIfBusinessDate(0);
        dataModel.setIfScatter(0);
        dataModel.setIfSearchColumn(0);
        dataModel.setIfShowColumn(0);
        dataModel.setIfModifyable(1);
        dataModels.add(dataModel);

        DataModel dataModel1 = new DataModel();
        dataModel1.setColumnNameCh("订单编号");
        dataModel1.setColumnNameEn("orderCode");
        dataModel1.setColumnType(3);
        dataModel1.setIfBusinessDate(0);
        dataModel1.setIfScatter(0);
        dataModel1.setIfSearchColumn(1);
        dataModel1.setIfShowColumn(1);
        dataModel1.setIfModifyable(1);
        dataModels.add(dataModel1);

        DataModel dataModel5 = new DataModel();
        dataModel5.setColumnNameCh("产品名称");
        dataModel5.setColumnNameEn("productId");
        dataModel5.setColumnType(1);
        dataModel5.setIfBusinessDate(0);
        dataModel5.setIfScatter(1);
        dataModel5.setIfSearchColumn(1);
        dataModel5.setIfShowColumn(1);
        dataModel5.setIfModifyable(1);
        dataModels.add(dataModel5);

        DataModel dataModel2 = new DataModel();
        dataModel2.setColumnNameCh("业务类型");
        dataModel2.setColumnNameEn("busiType");
        dataModel2.setColumnType(1);
        dataModel2.setIfBusinessDate(0);
        dataModel2.setIfScatter(1);
        dataModel2.setIfSearchColumn(0);
        dataModel2.setIfShowColumn(0);
        dataModel2.setIfModifyable(1);
        dataModels.add(dataModel2);

        DataModel dataModel3 = new DataModel();
        dataModel3.setColumnNameCh("收费类型");
        dataModel3.setColumnNameEn("payType");
        dataModel3.setColumnType(1);
        dataModel3.setIfBusinessDate(0);
        dataModel3.setIfScatter(1);
        dataModel3.setIfSearchColumn(0);
        dataModel3.setIfShowColumn(0);
        dataModel3.setIfModifyable(1);
        dataModels.add(dataModel3);

        DataModel dataModel4 = new DataModel();
        dataModel4.setColumnNameCh("所属城市");
        dataModel4.setColumnNameEn("city");
        dataModel4.setColumnType(1);
        dataModel4.setIfBusinessDate(0);
        dataModel4.setIfScatter(1);
        dataModel4.setIfSearchColumn(0);
        dataModel4.setIfShowColumn(0);
        dataModel4.setIfModifyable(1);
        dataModels.add(dataModel4);

        DataModel dataModel6 = new DataModel();
        dataModel6.setColumnNameCh("借款人");
        dataModel6.setColumnNameEn("loanName");
        dataModel6.setColumnType(3);
        dataModel6.setIfBusinessDate(0);
        dataModel6.setIfScatter(0);
        dataModel6.setIfSearchColumn(1);
        dataModel6.setIfShowColumn(1);
        dataModel6.setIfModifyable(1);
        dataModels.add(dataModel6);

        DataModel dataModel7 = new DataModel();
        dataModel7.setColumnNameCh("性别");
        dataModel7.setColumnNameEn("sex");
        dataModel7.setColumnType(1);
        dataModel7.setIfBusinessDate(0);
        dataModel7.setIfScatter(1);
        dataModel7.setIfSearchColumn(0);
        dataModel7.setIfShowColumn(0);
        dataModel7.setIfModifyable(1);
        dataModels.add(dataModel7);

        DataModel dataModel8 = new DataModel();
        dataModel8.setColumnNameCh("婚姻状况");
        dataModel8.setColumnNameEn("marriage");
        dataModel8.setColumnType(1);
        dataModel8.setIfBusinessDate(0);
        dataModel8.setIfScatter(1);
        dataModel8.setIfSearchColumn(0);
        dataModel8.setIfShowColumn(0);
        dataModel8.setIfModifyable(1);
        dataModels.add(dataModel8);

        DataModel dataModel9 = new DataModel();
        dataModel9.setColumnNameCh("证件类型");
        dataModel9.setColumnNameEn("certiType");
        dataModel9.setColumnType(1);
        dataModel9.setIfBusinessDate(0);
        dataModel9.setIfScatter(1);
        dataModel9.setIfSearchColumn(0);
        dataModel9.setIfShowColumn(0);
        dataModel9.setIfModifyable(1);
        dataModels.add(dataModel9);

        DataModel dataModel10 = new DataModel();
        dataModel10.setColumnNameCh("手机号码");
        dataModel10.setColumnNameEn("phoneNO");
        dataModel10.setColumnType(3);
        dataModel10.setIfBusinessDate(0);
        dataModel10.setIfScatter(0);
        dataModel10.setIfSearchColumn(0);
        dataModel10.setIfShowColumn(0);
        dataModel10.setIfModifyable(1);
        dataModels.add(dataModel10);

        DataModel dataModel11 = new DataModel();
        dataModel11.setColumnNameCh("证件号码");
        dataModel11.setColumnNameEn("certiCode");
        dataModel11.setColumnType(3);
        dataModel11.setIfBusinessDate(0);
        dataModel11.setIfScatter(0);
        dataModel11.setIfSearchColumn(0);
        dataModel11.setIfShowColumn(0);
        dataModel11.setIfModifyable(1);
        dataModels.add(dataModel11);

        DataModel dataModel12 = new DataModel();
        dataModel12.setColumnNameCh("现居住地址");
        dataModel12.setColumnNameEn("address");
        dataModel12.setColumnType(3);
        dataModel12.setIfBusinessDate(0);
        dataModel12.setIfScatter(0);
        dataModel12.setIfSearchColumn(0);
        dataModel12.setIfShowColumn(0);
        dataModel12.setIfModifyable(1);
        dataModels.add(dataModel12);

        DataModel dataModel13 = new DataModel();
        dataModel13.setColumnNameCh("总登记价(元)");
        dataModel13.setColumnNameEn("totalRegisterPrice");
        dataModel13.setColumnType(5);
        dataModel13.setIfBusinessDate(0);
        dataModel13.setIfScatter(0);
        dataModel13.setIfSearchColumn(0);
        dataModel13.setIfShowColumn(0);
        dataModel13.setIfModifyable(1);
        dataModels.add(dataModel13);

        DataModel dataModel15 = new DataModel();
        dataModel15.setColumnNameCh("总评估价(元)");
        dataModel15.setColumnNameEn("totalEstimatePrice");
        dataModel15.setColumnType(5);
        dataModel15.setIfBusinessDate(0);
        dataModel15.setIfScatter(0);
        dataModel15.setIfSearchColumn(0);
        dataModel15.setIfShowColumn(0);
        dataModel15.setIfModifyable(1);
        dataModels.add(dataModel15);

        DataModel dataModel14 = new DataModel();
        dataModel14.setColumnNameCh("原贷款总金额(元)");
        dataModel14.setColumnNameEn("originalLoadAmount");
        dataModel14.setColumnType(5);
        dataModel14.setIfBusinessDate(0);
        dataModel14.setIfScatter(0);
        dataModel14.setIfSearchColumn(0);
        dataModel14.setIfShowColumn(0);
        dataModel14.setIfModifyable(1);
        dataModels.add(dataModel14);

        DataModel dataModel16 = new DataModel();
        dataModel16.setColumnNameCh("原贷款本息总余额(元)");
        dataModel16.setColumnNameEn("originalCaptialInterest");
        dataModel16.setColumnType(5);
        dataModel16.setIfBusinessDate(0);
        dataModel16.setIfScatter(0);
        dataModel16.setIfSearchColumn(0);
        dataModel16.setIfShowColumn(0);
        dataModel16.setIfModifyable(1);
        dataModels.add(dataModel16);

        DataModel dataModel17 = new DataModel();
        dataModel17.setColumnNameCh("收款户名");
        dataModel17.setColumnNameEn("acceptionAccountName");
        dataModel17.setColumnType(3);
        dataModel17.setIfBusinessDate(0);
        dataModel17.setIfScatter(0);
        dataModel17.setIfSearchColumn(0);
        dataModel17.setIfShowColumn(0);
        dataModel17.setIfModifyable(1);
        dataModels.add(dataModel17);

        DataModel dataModel18 = new DataModel();
        dataModel18.setColumnNameCh("收款卡号");
        dataModel18.setColumnNameEn("acceptionCardNO");
        dataModel18.setColumnType(3);
        dataModel18.setIfBusinessDate(0);
        dataModel18.setIfScatter(0);
        dataModel18.setIfSearchColumn(0);
        dataModel18.setIfShowColumn(0);
        dataModel18.setIfModifyable(1);
        dataModels.add(dataModel18);

        DataModel dataModel19 = new DataModel();
        dataModel19.setColumnNameCh("收款开户行");
        dataModel19.setColumnNameEn("acceptionBankCode");
        dataModel19.setColumnType(1);
        dataModel19.setIfBusinessDate(0);
        dataModel19.setIfScatter(1);
        dataModel19.setIfSearchColumn(0);
        dataModel19.setIfShowColumn(0);
        dataModel19.setIfModifyable(1);
        dataModels.add(dataModel19);

        DataModel dataModel20 = new DataModel();
        dataModel20.setColumnNameCh("收款开户行支行");
        dataModel20.setColumnNameEn("acceptionBranchBank");
        dataModel20.setColumnType(3);
        dataModel20.setIfBusinessDate(0);
        dataModel20.setIfScatter(0);
        dataModel20.setIfSearchColumn(0);
        dataModel20.setIfShowColumn(0);
        dataModel20.setIfModifyable(1);
        dataModels.add(dataModel20);

        DataModel dataModel21 = new DataModel();
        dataModel21.setColumnNameCh("总批复金额(元)");
        dataModel21.setColumnNameEn("totalApproveAmount");
        dataModel21.setColumnType(5);
        dataModel21.setIfBusinessDate(0);
        dataModel21.setIfScatter(0);
        dataModel21.setIfSearchColumn(0);
        dataModel21.setIfShowColumn(0);
        dataModel21.setIfModifyable(1);
        dataModels.add(dataModel21);

        DataModel dataModel22 = new DataModel();
        dataModel22.setColumnNameCh("借款金额(元)");
        dataModel22.setColumnNameEn("loanAmount");
        dataModel22.setColumnType(5);
        dataModel22.setIfBusinessDate(0);
        dataModel22.setIfScatter(0);
        dataModel22.setIfSearchColumn(0);
        dataModel22.setIfShowColumn(0);
        dataModel22.setIfModifyable(1);
        dataModels.add(dataModel22);

        DataModel dataModel23 = new DataModel();
        dataModel23.setColumnNameCh("借款天数");
        dataModel23.setColumnNameEn("loanDays");
        dataModel23.setColumnType(1);
        dataModel23.setIfBusinessDate(0);
        dataModel23.setIfScatter(0);
        dataModel23.setIfSearchColumn(0);
        dataModel23.setIfShowColumn(0);
        dataModel23.setIfModifyable(1);
        dataModels.add(dataModel23);

        DataModel dataModel24 = new DataModel();
        dataModel24.setColumnNameCh("计划放款日期");
        dataModel24.setColumnNameEn("planLoanDate");
        dataModel24.setColumnType(4);
        dataModel24.setIfBusinessDate(0);
        dataModel24.setIfScatter(0);
        dataModel24.setIfSearchColumn(0);
        dataModel24.setIfShowColumn(0);
        dataModel24.setIfModifyable(1);
        dataModels.add(dataModel24);

        DataModel dataModel25 = new DataModel();
        dataModel25.setColumnNameCh("赎楼成数");
        dataModel25.setColumnNameEn("percent");
        dataModel25.setColumnType(5);
        dataModel25.setIfBusinessDate(0);
        dataModel25.setIfScatter(0);
        dataModel25.setIfSearchColumn(0);
        dataModel25.setIfShowColumn(0);
        dataModel25.setIfModifyable(1);
        dataModels.add(dataModel25);

        DataModel dataModel26 = new DataModel();
        dataModel26.setColumnNameCh("咨询费(元)");
        dataModel26.setColumnNameEn("consultFee");
        dataModel26.setColumnType(5);
        dataModel26.setIfBusinessDate(0);
        dataModel26.setIfScatter(0);
        dataModel26.setIfSearchColumn(0);
        dataModel26.setIfShowColumn(0);
        dataModel26.setIfModifyable(1);
        dataModels.add(dataModel26);

        DataModel dataModel27 = new DataModel();
        dataModel27.setColumnNameCh("手续费(元)");
        dataModel27.setColumnNameEn("fee");
        dataModel27.setColumnType(5);
        dataModel27.setIfBusinessDate(0);
        dataModel27.setIfScatter(0);
        dataModel27.setIfSearchColumn(0);
        dataModel27.setIfShowColumn(0);
        dataModel27.setIfModifyable(1);
        dataModels.add(dataModel27);

        DataModel dataModel28 = new DataModel();
        dataModel28.setColumnNameCh("手续费补贴(元)");
        dataModel28.setColumnNameEn("feeAllowance");
        dataModel28.setColumnType(5);
        dataModel28.setIfBusinessDate(0);
        dataModel28.setIfScatter(0);
        dataModel28.setIfSearchColumn(0);
        dataModel28.setIfShowColumn(0);
        dataModel28.setIfModifyable(1);
        dataModels.add(dataModel28);

        DataModel dataModel30 = new DataModel();
        dataModel30.setColumnNameCh("应付佣金(元)");
        dataModel30.setColumnNameEn("commission");
        dataModel30.setColumnType(5);
        dataModel30.setIfBusinessDate(0);
        dataModel30.setIfScatter(0);
        dataModel30.setIfSearchColumn(0);
        dataModel30.setIfShowColumn(0);
        dataModel30.setIfModifyable(1);
        dataModels.add(dataModel30);

        DataModel dataModel31= new DataModel();
        dataModel31.setColumnNameCh("待收费用(元)");
        dataModel31.setColumnNameEn("dueFee");
        dataModel31.setColumnType(5);
        dataModel31.setIfBusinessDate(0);
        dataModel31.setIfScatter(0);
        dataModel31.setIfSearchColumn(0);
        dataModel31.setIfShowColumn(0);
        dataModel31.setIfModifyable(1);
        dataModels.add(dataModel31);

        DataModel dataModel32= new DataModel();
        dataModel32.setColumnNameCh("总成交价(元)");
        dataModel32.setColumnNameEn("totalDealPrice");
        dataModel32.setColumnType(5);
        dataModel32.setIfBusinessDate(0);
        dataModel32.setIfScatter(0);
        dataModel32.setIfSearchColumn(0);
        dataModel32.setIfShowColumn(0);
        dataModel32.setIfModifyable(1);
        dataModels.add(dataModel32);

        DataModel dataModel33= new DataModel();
        dataModel33.setColumnNameCh("定金(元)");
        dataModel33.setColumnNameEn("frontMoney");
        dataModel33.setColumnType(5);
        dataModel33.setIfBusinessDate(0);
        dataModel33.setIfScatter(0);
        dataModel33.setIfSearchColumn(0);
        dataModel33.setIfShowColumn(0);
        dataModel33.setIfModifyable(1);
        dataModels.add(dataModel33);

        DataModel dataModel34= new DataModel();
        dataModel34.setColumnNameCh("首付款金额(元");
        dataModel34.setColumnNameEn("firstAmount");
        dataModel34.setColumnType(5);
        dataModel34.setIfBusinessDate(0);
        dataModel34.setIfScatter(0);
        dataModel34.setIfSearchColumn(0);
        dataModel34.setIfShowColumn(0);
        dataModel34.setIfModifyable(1);
        dataModels.add(dataModel34);

        DataModel dataModel35= new DataModel();
        dataModel35.setColumnNameCh("资金监管金额(元)");
        dataModel35.setColumnNameEn("captialWatchAmount");
        dataModel35.setColumnType(5);
        dataModel35.setIfBusinessDate(0);
        dataModel35.setIfScatter(0);
        dataModel35.setIfSearchColumn(0);
        dataModel35.setIfShowColumn(0);
        dataModel35.setIfModifyable(1);
        dataModels.add(dataModel35);

        DataModel dataModel36= new DataModel();
        dataModel36.setColumnNameCh("资金监管银行");
        dataModel36.setColumnNameEn("watchBank");
        dataModel36.setColumnType(1);
        dataModel36.setIfBusinessDate(0);
        dataModel36.setIfScatter(1);
        dataModel36.setIfSearchColumn(0);
        dataModel36.setIfShowColumn(0);
        dataModel36.setIfModifyable(1);
        dataModels.add(dataModel36);

        DataModel dataModel37= new DataModel();
        dataModel37.setColumnNameCh("资金监管收款账号");
        dataModel37.setColumnNameEn("captialWatchAccount");
        dataModel37.setColumnType(3);
        dataModel37.setIfBusinessDate(0);
        dataModel37.setIfScatter(0);
        dataModel37.setIfSearchColumn(0);
        dataModel37.setIfShowColumn(0);
        dataModel37.setIfModifyable(1);
        dataModels.add(dataModel37);

        DataModel dataModel38= new DataModel();
        dataModel38.setColumnNameCh("监管账号开户行");
        dataModel38.setColumnNameEn("watchAccountBank");
        dataModel38.setColumnType(3);
        dataModel38.setIfBusinessDate(0);
        dataModel38.setIfScatter(0);
        dataModel38.setIfSearchColumn(0);
        dataModel38.setIfShowColumn(0);
        dataModel38.setIfModifyable(1);
        dataModels.add(dataModel38);

        DataModel dataModel39= new DataModel();
        dataModel39.setColumnNameCh("资金监管解冻收款户名");
        dataModel39.setColumnNameEn("watchUnfreezeAccount");
        dataModel39.setColumnType(3);
        dataModel39.setIfBusinessDate(0);
        dataModel39.setIfScatter(0);
        dataModel39.setIfSearchColumn(0);
        dataModel39.setIfShowColumn(0);
        dataModel39.setIfModifyable(1);
        dataModels.add(dataModel39);

        DataModel dataModel40= new DataModel();
        dataModel40.setColumnNameCh("公积金贷款金额(元)");
        dataModel40.setColumnNameEn("publicFundAmount");
        dataModel40.setColumnType(5);
        dataModel40.setIfBusinessDate(0);
        dataModel40.setIfScatter(0);
        dataModel40.setIfSearchColumn(0);
        dataModel40.setIfShowColumn(0);
        dataModel40.setIfModifyable(1);
        dataModels.add(dataModel40);

        DataModel dataModel41= new DataModel();
        dataModel41.setColumnNameCh("公积金银行");
        dataModel41.setColumnNameEn("publicFundBank");
        dataModel41.setColumnType(1);
        dataModel41.setIfBusinessDate(0);
        dataModel41.setIfScatter(1);
        dataModel41.setIfSearchColumn(0);
        dataModel41.setIfShowColumn(0);
        dataModel41.setIfModifyable(1);
        dataModels.add(dataModel41);

        DataModel dataModel42= new DataModel();
        dataModel42.setColumnNameCh("公积金户名");
        dataModel42.setColumnNameEn("publicFundName");
        dataModel42.setColumnType(5);
        dataModel42.setIfBusinessDate(0);
        dataModel42.setIfScatter(0);
        dataModel42.setIfSearchColumn(0);
        dataModel42.setIfShowColumn(0);
        dataModel42.setIfModifyable(1);
        dataModels.add(dataModel42);

        DataModel dataModel43= new DataModel();
        dataModel43.setColumnNameCh("公积金开户行");
        dataModel43.setColumnNameEn("publicFundAccountBank");
        dataModel43.setColumnType(3);
        dataModel43.setIfBusinessDate(0);
        dataModel43.setIfScatter(0);
        dataModel43.setIfSearchColumn(0);
        dataModel43.setIfShowColumn(0);
        dataModel43.setIfModifyable(1);
        dataModels.add(dataModel43);

        DataModel dataModel44= new DataModel();
        dataModel44.setColumnNameCh("公积金卡号");
        dataModel44.setColumnNameEn("publicFundCardNO");
        dataModel44.setColumnType(3);
        dataModel44.setIfBusinessDate(0);
        dataModel44.setIfScatter(0);
        dataModel44.setIfSearchColumn(0);
        dataModel44.setIfShowColumn(0);
        dataModel44.setIfModifyable(1);
        dataModels.add(dataModel44);


        TotalCodeCreator totalCodeCreator = new TotalCodeCreator();
        totalCodeCreator.create(dataModels, "bangnd", "bridgecbs", "bridgeOrder");
    }
}
