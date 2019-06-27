package com.bangnd.util.web;

import com.bangnd.ums.entity.RoleResource;
import com.bangnd.ums.service.ResourceService;
import com.bangnd.ums.service.RoleResourceService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.entity.Attribute;
import com.bangnd.util.entity.Entitys;
import com.bangnd.util.service.AttributeService;
import com.bangnd.util.service.EntitysService;
import com.dashu.AutoBulider.entity.DataModel;
import com.dashu.AutoBulider.files.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CodeCreatorController {
    @Resource
    private AttributeService attributeService;
    @Resource
    private EntitysService entitysService;
    @Resource
    private ResourceService resourceService;
    @Resource
    private RoleResourceService roleResourceService;

    private String javaFilesPath = "/Users/wrh/Documents/wrh/work/gzx_app/src/main/java/com";
    private String htmlFilesPath = "/Users/wrh/Documents/wrh/work/gzx_app/src/main/resources/templates";

    @RequestMapping("/util/createCode")
    public String create(Model model,String enName) {
        List<DataModel> dataModels = new ArrayList<DataModel>();
        System.out.println("enName====="+enName);
        List<Attribute> attributes = attributeService.getAttributeListByObj(enName);
        Entitys entitys = entitysService.getEntitysByObjStr(enName);
        com.bangnd.ums.entity.Resource parentResource =resourceService.getResourceById(entitys.getParentMenu());
        //一、生成文件
        if(attributes!=null && attributes.size()>0){
            for(Attribute attribute:attributes){
                DataModel dataModel = new DataModel();
                dataModel.setColumnNameCh(attribute.getChName());
                dataModel.setColumnNameEn(attribute.getEnName());
                dataModel.setColumnType(attribute.getDataType());
                dataModel.setIfBusinessDate(attribute.getIfBusinessDate());
                dataModel.setIfScatter(attribute.getIfScatter());
                dataModel.setIfSearchColumn(attribute.getIfSearch());
                dataModel.setIfShowColumn(attribute.getIfShow());
                dataModel.setIfModifyable(attribute.getIfModify());

                dataModel.setIfMoreSelect(attribute.getIfMoreSelect());
                dataModel.setIfNeed(attribute.getIfNeed());
                dataModel.setForeignObject(attribute.getForeignObject());
                dataModel.setWhoObject(attribute.getWhoObject());
                dataModel.setIfCreateScatter(attribute.getIfCreateScatter());
                dataModels.add(dataModel);
            }
        }
        CodeCreatorController totalCodeCreator = new CodeCreatorController();
        totalCodeCreator.createTotal(dataModels, "bangnd", parentResource.getEnName(), entitys.getEnName());
        System.out.println("文件生成完成！");

        //二、将生成的页面挂到某个菜单下
        com.bangnd.ums.entity.Resource resource = new com.bangnd.ums.entity.Resource();
        //1：是链接
        resource.setType(1);
        //2：是二级目录
        resource.setGrade(2);
        resource.setState(ConstantCfg.STATE_1);
        resource.setCreator(0);
        resource.setCreateTime(new Date());
        resource.setName(entitys.getChName()+"管理");
        resource.setParentId(entitys.getParentMenu());
        resource.setResUrl("/"+parentResource.getEnName()+"/"+entitys.getEnName());
        resource.setBusiType(ConstantCfg.STANDARD_BUSI);
        resource=resourceService.save(resource);
        System.out.println("资源生成完成！");

        //三：给该目录添加基本角色
        //将该功能给基本的角色
        RoleResource roleResource =  new RoleResource();
        roleResource.setState(ConstantCfg.STATE_1);
        roleResource.setCreator(0);
        roleResource.setCreateTime(new Date());
        roleResource.setResId(resource.getId());
        roleResource.setRoleId(entitys.getBasicRole());
        //1、代表可读；
        roleResource.setType(1);
        roleResourceService.save(roleResource);
        System.out.println("角色配置完成！");

        return "redirect:/util/entitys";
    }

    public void createTotal(List<DataModel> dataModels, String company, String sys, String entityName) {
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
        HtmlEditCreator htmlEditCreator = new HtmlEditCreator();
        HtmlListCreator htmlListCreator = new HtmlListCreator();
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        SearchFormCreator searchFormCreator = new SearchFormCreator();
        ServiceCreator serviceCreator = new ServiceCreator();
        ServiceImplCreator serviceImplCreator = new ServiceImplCreator();
        ShowListVOCreator showListVOCreator = new ShowListVOCreator();

        if (dataModels != null) {
            for (DataModel dataModel : dataModels) {
                if (dataModel.getIfScatter() == 1 && dataModel.getIfCreateScatter() == 1) {
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

            String htmlEditFileName = htmlFilesPath + "/" + sys + "/" + entityName + "Edit.html";
            createFileToPath(htmlEditCreator.create(dataModels, sys, entityName), htmlEditFileName);

            String htmlListFileName = htmlFilesPath + "/" + sys + "/" + entityName + "List.html";
            createFileToPath(htmlListCreator.create(dataModels, sys, entityName), htmlListFileName);

            String formFileName = javaFilesPath + "/" + company + "/" + sys + "/form/" + UpEntityName + "SearchForm.java";
            createFileToPath(searchFormCreator.create(dataModels, company, sys,entityName), formFileName);

            String voFileName = javaFilesPath + "/" + company + "/" + sys + "/vo/" + UpEntityName + "VO.java";
            createFileToPath(showListVOCreator.create(dataModels, company, sys,entityName), voFileName);

            String entityFileName = javaFilesPath + "/" + company + "/" + sys + "/entity/" + UpEntityName + ".java";
            createFileToPath(entityCreator.create(dataModels, company, sys,entityName), entityFileName);

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



}
