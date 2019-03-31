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
        dataModel.setSysName("sales");
        dataModel.setTableNames("group");
        dataModel.setColumnNameCh("组名");
        dataModel.setColumnNameEn("name");
        dataModel.setColumnType(3);
        dataModel.setIfBusinessDate(0);
        dataModel.setIfScatter(0);
        dataModel.setIfSearchColumn(1);
        dataModel.setIfShowColumn(1);
        dataModel.setIfModifyable(1);
        dataModels.add(dataModel);

        DataModel dataModel1 = new DataModel();
        dataModel1.setColumnNameCh("级别");
        dataModel1.setColumnNameEn("grade");
        dataModel1.setColumnType(1);
        dataModel1.setIfBusinessDate(0);
        dataModel1.setIfScatter(1);
        dataModel1.setIfSearchColumn(1);
        dataModel1.setIfShowColumn(1);
        dataModel1.setIfModifyable(1);
        dataModels.add(dataModel1);

        DataModel dataModel2 = new DataModel();
        dataModel2.setColumnNameCh("父组");
        dataModel2.setColumnNameEn("parentId");
        dataModel2.setColumnType(1);
        dataModel2.setIfBusinessDate(0);
        dataModel2.setIfScatter(1);
        dataModel2.setIfSearchColumn(1);
        dataModel2.setIfShowColumn(1);
        dataModel2.setIfModifyable(1);
        dataModels.add(dataModel2);

        DataModel dataModel3 = new DataModel();
        dataModel3.setColumnNameCh("负责人");
        dataModel3.setColumnNameEn("employeeId");
        dataModel3.setColumnType(2);
        dataModel3.setIfBusinessDate(0);
        dataModel3.setIfScatter(1);
        dataModel3.setIfSearchColumn(1);
        dataModel3.setIfShowColumn(1);
        dataModel3.setIfModifyable(1);
        dataModels.add(dataModel);

        TotalCodeCreator totalCodeCreator = new TotalCodeCreator();
        totalCodeCreator.create(dataModels, "bangnd", "sales", "group");
    }
}
