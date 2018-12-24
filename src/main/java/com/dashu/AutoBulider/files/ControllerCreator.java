package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.entity.DataModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ControllerCreator {
    public String create(List<DataModel> dataModelList,String company,String sys){
        StringBuffer controllerCode = new StringBuffer();
        controllerCode.append(createPackage(dataModelList,company,sys));
        controllerCode.append(createImport(dataModelList,company,sys));
        controllerCode.append(createClass(dataModelList));
        controllerCode.append(createPrivateMembers(dataModelList));
        controllerCode.append(createHome(dataModelList));
        controllerCode.append(createSearch(dataModelList));
        controllerCode.append(createToAdd(dataModelList));
        controllerCode.append(createAdd(dataModelList));
        controllerCode.append(createToModify(dataModelList));
        controllerCode.append(createModify(dataModelList));
        controllerCode.append(createDelete(dataModelList));
        //类的结束括号
        controllerCode.append("}");
        return controllerCode.toString();
    }
    private String createPackage(List<DataModel> dataModelList,String company,String sys){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            controllerCode.append("package com."+company+"."+sys+".web;\n");
        }
        return controllerCode.toString();
    }
    private String createImport(List<DataModel> dataModelList,String company,String sys){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            controllerCode.append("import org.springframework.stereotype.Controller;\n");
            controllerCode.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
            controllerCode.append("import javax.annotation.Resource;\n");
            controllerCode.append("import org.springframework.ui.Model;\n");
            controllerCode.append("import java.util.*;\n");
            controllerCode.append("import com.dashu.AutoBulider.config.*;\n");
            controllerCode.append("import com."+company+"."+sys+".web.*;\n");
            controllerCode.append("import com."+company+"."+sys+".entity.*;\n");
            controllerCode.append("import com."+company+"."+sys+".form.*;\n");
            controllerCode.append("import com."+company+"."+sys+".service.*;\n");
            controllerCode.append("import com."+company+"."+sys+".service.impl.*;\n");
            controllerCode.append("import com."+company+"."+sys+".vo.*;\n");
        }
        return controllerCode.toString();
    }

    private String createClass(List<DataModel> dataModelList){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            String entityName = dataModelList.get(0).getTableNames();
            String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
            controllerCode.append("@Controller\n");
            controllerCode.append("public class "+UpEntityName+"Controller {\n");
        }
        return controllerCode.toString();
    }

    private String createPrivateMembers(List<DataModel> dataModelList){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            String entityName = dataModelList.get(0).getTableNames();
            String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
            controllerCode.append("@Resource\n");
            controllerCode.append("private "+UpEntityName+"Service "+entityName+"Service;\n");
            for(DataModel dataModel:dataModelList){
                if(dataModel.getIfScatter()==1){
                    String columnName=dataModel.getColumnNameEn();
                    String UpColumn=Character.toUpperCase(columnName.charAt(0))+columnName.substring(1);
                    controllerCode.append("Resouce\n");
                    controllerCode.append(UpEntityName+UpColumn+"Service "+entityName+UpColumn+"Service;\n");
                }
            }
        }
        return controllerCode.toString();
    }

    /**
     * 生成首页
     * @param dataModelList
     * @return
     */
    private String createHome(List<DataModel> dataModelList){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            String entityName = dataModelList.get(0).getTableNames();
            String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
            controllerCode.append("@RequestMapping(\"/"+entityName+"/home\")");
            controllerCode.append("public String home(Model model,"+UpEntityName+"SearchForm "+entityName+"SearchForm){\n");
            controllerCode.append("List<"+UpEntityName+"> "+entityName+"s ="+entityName+"Service.get"+UpEntityName+"List("+entityName+"SearchForm);\n" );

            for (Iterator<DataModel> iterator = dataModelList.iterator(); iterator.hasNext(); ) {
                DataModel dataModel = iterator.next();
                String columnName = dataModel.getColumnNameEn();
                String UpColumn = Character.toUpperCase(columnName.charAt(0)) + columnName.substring(1);
                if (dataModel.getIfScatter() == 1) {
                    controllerCode.append("model.addAttribute(\"" + columnName + "s\", " + entityName + UpColumn + "Service.getAll());\n");
                }
            }

            controllerCode.append("List<"+UpEntityName+"VO> "+entityName+"VOs = new ArrayList<>();\n");
            controllerCode.append("if("+entityName+"s!=null){\n");
            controllerCode.append("for("+UpEntityName+" "+entityName+":"+entityName+"s){\n");
            controllerCode.append(UpEntityName+"VO "+entityName+"VO = new "+UpEntityName+"VO();\n");

            for(DataModel dataModel:dataModelList){
                String columnName=dataModel.getColumnNameEn();
                String UpColumn=Character.toUpperCase(columnName.charAt(0))+columnName.substring(1);
                if(dataModel.getIfShowColumn()==1){
                    if(dataModel.getIfScatter()!=1){
                        controllerCode.append(entityName+"VO.set"+UpColumn+"("+entityName+".get"+UpColumn+"());\n");
                    }else {
                        controllerCode.append(entityName+"VO.set"+UpColumn+"Name" +
                                "(("+entityName+UpColumn+"Service.get"+UpEntityName+UpColumn+"("+entityName+".get"+UpEntityName+UpColumn+"())).getName());\n");
                    }
                }
            }
            controllerCode.append(entityName+"VOs.add("+entityName+"VO);\n");
            controllerCode.append("}}");
            controllerCode.append("model.addAttribute(\""+entityName+"VOs\","+entityName+"VOs);\n");
            controllerCode.append("return \"/"+entityName+"/"+entityName+"List\";\n");
            controllerCode.append("}\n");
        }
        return controllerCode.toString();
    }
    private String createSearch(List<DataModel> dataModelList){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){

        }
        return controllerCode.toString();
    }

    private String createToAdd(List<DataModel> dataModelList){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            String entityName = dataModelList.get(0).getTableNames();
            String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
            controllerCode.append("@RequestMapping(\"/"+entityName+"/toAdd\")");
            controllerCode.append("public String toAdd(Model model){");
            controllerCode.append(UpEntityName+" "+entityName+" = new "+UpEntityName+"();\n");
            controllerCode.append("model.addAttribute(\""+entityName+"\", "+entityName+");\n");

            for(DataModel dataModel:dataModelList){
                String columnName=dataModel.getColumnNameEn();
                String UpColumn=Character.toUpperCase(columnName.charAt(0))+columnName.substring(1);
                if (dataModel.getIfScatter() == 1) {
                    controllerCode.append("model.addAttribute(\""+columnName+"s\", "+entityName+UpColumn+"Service.getAll());\n");
                }
            }
            controllerCode.append("return \"/"+entityName+"/"+entityName+"Add\";\n");
            controllerCode.append("}\n");
        }
        return controllerCode.toString();
    }
    private String createAdd(List<DataModel> dataModelList){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            String entityName = dataModelList.get(0).getTableNames();
            String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
            controllerCode.append("@RequestMapping(\"/"+entityName+"/add\")\n");
            controllerCode.append("public String add("+UpEntityName+" "+entityName+"){\n");
            controllerCode.append(entityName+".setState(ConstantCfg.ORDER_STATE_INITIAL);\n");
            controllerCode.append(entityName+".setCreator(0);\n");
            controllerCode.append(entityName+".setCreateTime(new Date());\n");
            controllerCode.append(entityName+"Service.save("+entityName+");\n");
            controllerCode.append("return \"redirect:/"+entityName+"/home\";\n");
            controllerCode.append("}\n");
        }
        return controllerCode.toString();
    }
    private String createToModify(List<DataModel> dataModelList){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            String entityName = dataModelList.get(0).getTableNames();
            String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
            controllerCode.append("@RequestMapping(\"/"+entityName+"/toModify\")\n");
            controllerCode.append("public String toModify(Model model,Long id){\n");

            controllerCode.append(UpEntityName+" "+entityName+"="+entityName+"Service.get"+UpEntityName+"ById(id);\n");
            controllerCode.append("model.addAttribute(\""+entityName+"\", "+entityName+");\n");

            controllerCode.append("return \"/"+entityName+"/"+entityName+"Add\";\n");
            controllerCode.append("}\n");
        }
        return controllerCode.toString();
    }
    private String createModify(List<DataModel> dataModelList){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            String entityName = dataModelList.get(0).getTableNames();
            String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
            controllerCode.append("@RequestMapping(\"/"+entityName+"/modify\")\n");
            controllerCode.append("public String modify("+UpEntityName+" "+entityName+",Long id){\n");
            controllerCode.append(UpEntityName+" old"+UpEntityName+"="+entityName+"Service.get"+UpEntityName+"ById(id);\n");
            for(DataModel dataModel:dataModelList){
                String columnName=dataModel.getColumnNameEn();
                String UpColumn=Character.toUpperCase(columnName.charAt(0))+columnName.substring(1);
                if(dataModel.getIfModifyable()==1){
                    controllerCode.append("old"+UpEntityName+".set"+UpColumn+"("+entityName+".get"+UpColumn+"());\n");
                }
            }
            controllerCode.append("old"+UpEntityName+".setUpdator(0);\n");
            controllerCode.append("old"+UpEntityName+".setUpdateTime(new Date());\n");
            controllerCode.append(entityName+"Service.merge(old"+UpEntityName+");\n");
            controllerCode.append("return \"redirect:/"+entityName+"/toModify?id=\"+id;\n");
            controllerCode.append("}\n");
        }
        return controllerCode.toString();
    }
    private String createDelete(List<DataModel> dataModelList){
        StringBuffer controllerCode = new StringBuffer();
        if(dataModelList!=null){
            String entityName = dataModelList.get(0).getTableNames();
            String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
            controllerCode.append("@RequestMapping(\"/"+entityName+"/delete\")\n");
            controllerCode.append("public String delete(Long id){\n");
            controllerCode.append(UpEntityName+" old"+UpEntityName+"="+entityName+"Service.get"+UpEntityName+"ById(id);\n");
            controllerCode.append("old"+UpEntityName+".setState(0);\n");
            controllerCode.append("old"+UpEntityName+".setUpdator(0);\n");
            controllerCode.append("old"+UpEntityName+".setUpdateTime(new Date());\n");
            controllerCode.append(entityName+"Service.merge(old"+UpEntityName+");\n");
            controllerCode.append("return \"redirect:/"+entityName+"/home\";\n");
            controllerCode.append("}");
        }
        return controllerCode.toString();
    }

    public static void main(String[] args){
        List<DataModel> dataModels = new ArrayList<DataModel>();
        DataModel dataModel = new DataModel();
        dataModel.setSysName("cbs");
        dataModel.setTableNames("test");
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
        dataModel1.setColumnNameCh("申请日期");
        dataModel1.setColumnNameEn("applyDate");
        dataModel1.setColumnType(4);
        dataModel1.setIfBusinessDate(1);
        dataModel1.setIfScatter(0);
        dataModel1.setIfSearchColumn(1);
        dataModel1.setIfShowColumn(1);
        dataModel1.setIfModifyable(1);
        dataModels.add(dataModel1);
        ControllerCreator controllerCreator = new ControllerCreator();
        System.out.println(controllerCreator.create(dataModels,"dashu","test"));
    }
}
