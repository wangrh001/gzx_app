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
                    String fileName=javaFilesPath+"/"+company+"/"+sys+"/entity/"+UpEntityName+UpColumnName+".java";
                    createFileToPath(cfgEntityCreator.create(company,sys,entityName,dataModel.getColumnNameEn()),fileName);
                }
            }
            String controllerFileName=javaFilesPath+"/"+company+"/"+sys+"/web/"+UpEntityName+"Controller.java";
            createFileToPath(controllerCreator.create(dataModels,company,sys),controllerFileName);

            String entityFileName=javaFilesPath+"/"+company+"/"+sys+"/entity/"+UpEntityName+".java";
            createFileToPath(entityCreator.create(dataModels,company,sys),entityFileName);

            String htmlAddFileName=htmlFilesPath+"/"+sys+"/"+entityName+"Add.html";
            createFileToPath(htmlAddCreator.create(dataModels),htmlAddFileName);

            String htmlListFileName=htmlFilesPath+"/"+sys+"/"+entityName+"List.html";
            createFileToPath(htmlListCreator.create(dataModels),htmlListFileName);

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
        dataModel.setSysName("sales");
        dataModel.setTableNames("agent");
        dataModel1.setColumnNameCh("申请日期");
        dataModel1.setColumnNameEn("applyDate");
        dataModel1.setColumnType(4);
        dataModel1.setIfBusinessDate(1);
        dataModel1.setIfScatter(0);
        dataModel1.setIfSearchColumn(1);
        dataModel1.setIfShowColumn(1);
        dataModel1.setIfModifyable(1);
        dataModels.add(dataModel1);
        TotalCodeCreator totalCodeCreator = new TotalCodeCreator();
        totalCodeCreator.create(dataModels,"bangnd","sales","agent");
//        totalCodeCreator.createFileToPath("aa",totalCodeCreator.javaFilesPath+"/test/web/1.java");
    }
}
