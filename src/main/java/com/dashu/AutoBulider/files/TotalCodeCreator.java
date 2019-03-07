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
        //产品利息表
        DataModel dataModel = new DataModel();
        dataModel.setSysName("cbs");
        dataModel.setTableNames("prodInterest");
        dataModel.setColumnNameCh("产品id");
        dataModel.setColumnNameEn("productId");
        dataModel.setColumnType(1);
        dataModel.setIfBusinessDate(0);
        dataModel.setIfScatter(0);
        dataModel.setIfSearchColumn(0);
        dataModel.setIfShowColumn(1);
        dataModel.setIfModifyable(1);
        dataModels.add(dataModel);

        DataModel dataModel2 = new DataModel();
        dataModel2.setColumnNameCh("结算周期");
        dataModel2.setColumnNameEn("periodType");
        dataModel2.setColumnType(1);
        dataModel2.setIfBusinessDate(0);
        dataModel2.setIfScatter(1);
        dataModel2.setIfSearchColumn(1);
        dataModel2.setIfShowColumn(1);
        dataModel2.setIfModifyable(1);
        dataModels.add(dataModel2);

        DataModel dataModel4 = new DataModel();
        dataModel4.setColumnNameCh("产品利息");
        dataModel4.setColumnNameEn("interest");
        dataModel4.setColumnType(5);
        dataModel4.setIfBusinessDate(0);
        dataModel4.setIfScatter(0);
        dataModel4.setIfSearchColumn(0);
        dataModel4.setIfShowColumn(0);
        dataModel4.setIfModifyable(1);
        dataModels.add(dataModel4);


        DataModel dataModel10 = new DataModel();
        dataModel10.setColumnNameCh("开始时间");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
        dataModel10.setColumnNameEn("beginDate");
        dataModel10.setColumnType(4);
        dataModel10.setIfBusinessDate(1);
        dataModel10.setIfScatter(0);
        dataModel10.setIfSearchColumn(0);
        dataModel10.setIfShowColumn(0);
        dataModel10.setIfModifyable(1);
        dataModels.add(dataModel10);

        DataModel dataModel11 = new DataModel();
        dataModel11.setColumnNameCh("结束时间");
        //前端传的字符串日期格式必须是：MM/DD/YYYY，后端会自动存储成日期类型
        dataModel11.setColumnNameEn("endDate");
        dataModel11.setColumnType(4);
        dataModel11.setIfBusinessDate(0);
        dataModel11.setIfScatter(0);
        dataModel11.setIfSearchColumn(0);
        dataModel11.setIfShowColumn(0);
        dataModel11.setIfModifyable(1);
        dataModels.add(dataModel11);

        TotalCodeCreator totalCodeCreator = new TotalCodeCreator();
        totalCodeCreator.create(dataModels, "bangnd", "cbs", "prodInterest");
    }
}
