package com.dashu.AutoBulider.files;

/**
 * 生成Service的代码
 */
public class ServiceCreator {

    public String create(String company,String sys,String entityName){
        StringBuffer stringBuffer = new StringBuffer();
        if(entityName!=null){
            stringBuffer.append(createPackage(company,sys));
            stringBuffer.append(createImport(company,sys,entityName));
            stringBuffer.append(createClass(entityName));
            stringBuffer.append(createGetList(entityName));
            stringBuffer.append(createSave(entityName));
            stringBuffer.append(createGetEntityById(entityName));
            stringBuffer.append(createMerge(entityName));
            stringBuffer.append("}");
        }
        return stringBuffer.toString();
    }
    private String createPackage(String company,String sys){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package com."+company+"."+sys+".service;\n");
        return stringBuffer.toString();
    }
    private String createImport(String company,String sys,String entityName){
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
        stringBuffer.append("import com."+company+"."+sys+".entity."+UpEntityName+";\n");
        stringBuffer.append("import com."+company+"."+sys+".form."+UpEntityName+"SearchForm;\n");
        stringBuffer.append("import java.util.List;\n");
        return stringBuffer.toString();
    }
    private String createClass(String entityName){
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
        stringBuffer.append("public interface "+UpEntityName+"Service{\n");
        return stringBuffer.toString();
    }
    private String createGetList(String entityName){
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
        stringBuffer.append("public List<"+UpEntityName+"> get"+UpEntityName+"List("+UpEntityName+"SearchForm "+entityName+"SearchForm);");
        return stringBuffer.toString();
    }
    private String createSave(String entityName){
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
        stringBuffer.append("public void save("+UpEntityName+" "+entityName+");");
        return stringBuffer.toString();
    }
    private String createGetEntityById(String entityName){
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
        stringBuffer.append("public "+UpEntityName+" get"+UpEntityName+"ById(long id);");
        return stringBuffer.toString();
    }
    private String createMerge(String entityName){
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
        stringBuffer.append("public void merge("+UpEntityName+" "+entityName+");");
        return stringBuffer.toString();
    }

    public static void main(String[] args){
        ServiceCreator serviceCreator = new ServiceCreator();
        System.out.println(serviceCreator.create("dashu","test","test"));
    }

}
