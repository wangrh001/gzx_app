package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.entity.DataModel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TotalCodeCreator {

    private String javaFilesPath="/Users/wrh/Documents/wrh/work/gzx_app/src/main/java/com";
    private String htmlFilesPath="/Users/wrh/Documents/wrh/work/gzx_app/src/main/resources/templates";

    public void create(List<DataModel> dataModels,String company,String sys,String entityName){
        String UpEntityName="";
        if(entityName!=null&&!"".equals(entityName)){
            UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
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


        if(dataModels!=null){
            for(DataModel dataModel:dataModels){
                if(dataModel.getIfScatter()==1){
                    String columnNameEn = dataModel.getColumnNameEn();
                    String UpColumnName=Character.toUpperCase(columnNameEn.charAt(0))+columnNameEn.substring(1);
                    String cfgEntityFileName=javaFilesPath+"/"+company+"/"+sys+"/entity/"+UpEntityName+UpColumnName+".java";
                    createFileToPath(cfgEntityCreator.create(company,sys,entityName,dataModel.getColumnNameEn()),cfgEntityFileName);

                    String cfgServiceFileName=javaFilesPath+"/"+company+"/"+sys+"/service/"+UpEntityName+UpColumnName+"Service.java";
                    createFileToPath(cfgServiceCreator.create(company,sys,entityName,dataModel.getColumnNameEn()),cfgServiceFileName);

                    String cfgServiceImplFileName=javaFilesPath+"/"+company+"/"+sys+"/service/impl/"+UpEntityName+UpColumnName+"ServiceImpl.java";
                    createFileToPath(cfgServiceImplCreator.create(company,sys,entityName,dataModel.getColumnNameEn()),cfgServiceImplFileName);

                    String cfgRepositoryFileName=javaFilesPath+"/"+company+"/"+sys+"/repository/"+UpEntityName+UpColumnName+"Repository.java";
                    createFileToPath(cfgRepositoryCreator.create(company,sys,entityName,dataModel.getColumnNameEn()),cfgRepositoryFileName);

                }
            }
            String controllerFileName=javaFilesPath+"/"+company+"/"+sys+"/web/"+UpEntityName+"Controller.java";
            createFileToPath(controllerCreator.create(dataModels,company,sys,entityName),controllerFileName);

            String entityFileName=javaFilesPath+"/"+company+"/"+sys+"/entity/"+UpEntityName+".java";
            createFileToPath(entityCreator.create(dataModels,company,sys),entityFileName);

            String htmlAddFileName=htmlFilesPath+"/"+sys+"/"+entityName+"Add.html";
            createFileToPath(htmlAddCreator.create(dataModels,sys,entityName),htmlAddFileName);

            String htmlListFileName=htmlFilesPath+"/"+sys+"/"+entityName+"List.html";
            createFileToPath(htmlListCreator.create(dataModels,sys,entityName),htmlListFileName);

            String repositoryFileName=javaFilesPath+"/"+company+"/"+sys+"/repository/"+UpEntityName+"Repository.java";
            createFileToPath(repositoryCreator.create(company,sys,entityName),repositoryFileName);

            String formFileName=javaFilesPath+"/"+company+"/"+sys+"/form/"+UpEntityName+"SearchForm.java";
            createFileToPath(searchFormCreator.create(dataModels,company,sys),formFileName);

            String serviceFileName=javaFilesPath+"/"+company+"/"+sys+"/service/"+UpEntityName+"Service.java";
            createFileToPath(serviceCreator.create(company,sys,entityName),serviceFileName);

            String serviceImplFileName=javaFilesPath+"/"+company+"/"+sys+"/service/impl/"+UpEntityName+"ServiceImpl.java";
            createFileToPath(serviceImplCreator.create(dataModels,company,sys,entityName),serviceImplFileName);

            String voFileName=javaFilesPath+"/"+company+"/"+sys+"/vo/"+UpEntityName+"VO.java";
            createFileToPath(showListVOCreator.create(dataModels,company,sys),voFileName);
        }
    }

    //将字符串生成文件，并发到自动位置
    public void createFileToPath(String text,String fileNameWithPath){
        try {
            if(fileNameWithPath!=null && !"".equals(fileNameWithPath)){
                String dirName= fileNameWithPath.substring(0,fileNameWithPath.lastIndexOf("/"));

                File fileDir = new File(dirName);
                File file = new File(fileNameWithPath);

                if(!fileDir.exists()){
                    fileDir.mkdirs();
                }

                if(!file.exists()){
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

    public static void main(String[] args){
        List<DataModel> dataModels = new ArrayList<DataModel>();
        DataModel dataModel = new DataModel();
        dataModel.setSysName("sales");
        dataModel.setTableNames("agent");
        dataModel.setColumnNameCh("姓名");
        dataModel.setColumnNameEn("name");
        dataModel.setColumnType(3);
        dataModel.setIfBusinessDate(0);
        dataModel.setIfScatter(0);
        dataModel.setIfSearchColumn(1);
        dataModel.setIfShowColumn(1);
        dataModel.setIfModifyable(1);
        dataModels.add(dataModel);

        DataModel dataModel1 = new DataModel();
        dataModel1.setColumnNameCh("业务类型");
        dataModel1.setColumnNameEn("businessType");
        dataModel1.setColumnType(1);
        dataModel1.setIfBusinessDate(0);
        dataModel1.setIfScatter(1);
        dataModel1.setIfSearchColumn(1);
        dataModel1.setIfShowColumn(1);
        dataModel1.setIfModifyable(1);
        dataModels.add(dataModel1);

        DataModel dataModel2 = new DataModel();
        dataModel2.setColumnNameCh("渠道类型");
        dataModel2.setColumnNameEn("channelType");
        dataModel2.setColumnType(1);
        dataModel2.setIfBusinessDate(0);
        dataModel2.setIfScatter(1);
        dataModel2.setIfSearchColumn(1);
        dataModel2.setIfShowColumn(0);
        dataModel2.setIfModifyable(1);
        dataModels.add(dataModel2);

        DataModel dataModel3 = new DataModel();
        dataModel3.setColumnNameCh("员工号");
        dataModel3.setColumnNameEn("employeeCode");
        dataModel3.setColumnType(3);
        dataModel3.setIfBusinessDate(0);
        dataModel3.setIfScatter(0);
        dataModel3.setIfSearchColumn(0);
        dataModel3.setIfShowColumn(0);
        dataModel3.setIfModifyable(0);
        dataModels.add(dataModel3);

        DataModel dataModel4 = new DataModel();
        dataModel4.setColumnNameCh("银行账号");
        dataModel4.setColumnNameEn("bankCode");
        dataModel4.setColumnType(3);
        dataModel4.setIfBusinessDate(0);
        dataModel4.setIfScatter(0);
        dataModel4.setIfSearchColumn(0);
        dataModel4.setIfShowColumn(0);
        dataModel4.setIfModifyable(1);
        dataModels.add(dataModel4);

        DataModel dataModel5 = new DataModel();
        dataModel5.setColumnNameCh("合作开始日期");
        dataModel5.setColumnNameEn("cooperateBeginDate");
        dataModel5.setColumnType(4);
        dataModel5.setIfBusinessDate(1);
        dataModel5.setIfScatter(0);
        dataModel5.setIfSearchColumn(0);
        dataModel5.setIfShowColumn(0);
        dataModel5.setIfModifyable(1);
        dataModels.add(dataModel5);

        DataModel dataModel6 = new DataModel();
        dataModel6.setColumnNameCh("合作结束日期");
        dataModel6.setColumnNameEn("cooperateEndDate");
        dataModel6.setColumnType(4);
        dataModel6.setIfBusinessDate(1);
        dataModel6.setIfScatter(0);
        dataModel6.setIfSearchColumn(0);
        dataModel6.setIfShowColumn(0);
        dataModel6.setIfModifyable(1);
        dataModels.add(dataModel6);

        DataModel dataModel7 = new DataModel();
        dataModel7.setColumnNameCh("生份证号");
        dataModel7.setColumnNameEn("centiCode");
        dataModel7.setColumnType(3);
        dataModel7.setIfBusinessDate(0);
        dataModel7.setIfScatter(0);
        dataModel7.setIfSearchColumn(1);
        dataModel7.setIfShowColumn(0);
        dataModel7.setIfModifyable(1);
        dataModels.add(dataModel7);

        DataModel dataModel8 = new DataModel();
        dataModel8.setColumnNameCh("手机号");
        dataModel8.setColumnNameEn("phoneNO");
        dataModel8.setColumnType(3);
        dataModel8.setIfBusinessDate(0);
        dataModel8.setIfScatter(0);
        dataModel8.setIfSearchColumn(1);
        dataModel8.setIfShowColumn(1);
        dataModel8.setIfModifyable(1);
        dataModels.add(dataModel8);

        DataModel dataModel9 = new DataModel();
        dataModel9.setColumnNameCh("公司名");
        dataModel9.setColumnNameEn("companyName");
        dataModel9.setColumnType(3);
        dataModel9.setIfBusinessDate(0);
        dataModel9.setIfScatter(0);
        dataModel9.setIfSearchColumn(1);
        dataModel9.setIfShowColumn(1);
        dataModel9.setIfModifyable(1);
        dataModels.add(dataModel9);

        DataModel dataModel10 = new DataModel();
        dataModel10.setColumnNameCh("用户名");
        dataModel10.setColumnNameEn("userName");
        dataModel10.setColumnType(3);
        dataModel10.setIfBusinessDate(0);
        dataModel10.setIfScatter(0);
        dataModel10.setIfSearchColumn(1);
        dataModel10.setIfShowColumn(0);
        dataModel10.setIfModifyable(1);
        dataModels.add(dataModel10);

        DataModel dataModel11 = new DataModel();
        dataModel11.setColumnNameCh("从业年限");
        dataModel11.setColumnNameEn("jobYears");
        dataModel11.setColumnType(1);
        dataModel11.setIfBusinessDate(0);
        dataModel11.setIfScatter(0);
        dataModel11.setIfSearchColumn(1);
        dataModel11.setIfShowColumn(0);
        dataModel11.setIfModifyable(1);
        dataModels.add(dataModel11);

        TotalCodeCreator totalCodeCreator = new TotalCodeCreator();
        totalCodeCreator.create(dataModels,"bangnd","sales","agent");
    }
}
