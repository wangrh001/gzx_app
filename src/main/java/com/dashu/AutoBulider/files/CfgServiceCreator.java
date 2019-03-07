package com.dashu.AutoBulider.files;

public class CfgServiceCreator {

    public String create(String company,
                         String sys,
                         String tableName,
                         String columnName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpColumn = Character.toUpperCase(columnName.charAt(0)) + columnName.substring(1);
        String UpEntityName = Character.toUpperCase(tableName.charAt(0)) + tableName.substring(1);

        stringBuffer.append("package com." + company + "." + sys + ".service;\n");
        stringBuffer.append("import  com." + company + "." + sys + ".entity.*;\n");
        stringBuffer.append("import java.util.List;");
        stringBuffer.append("public interface " + UpEntityName + UpColumn + "Service{ \n");
        stringBuffer.append("public List<" + UpEntityName + UpColumn + "> getAll();");
        stringBuffer.append("public " + UpEntityName + UpColumn + " get" + UpEntityName + UpColumn + "ById(int id);");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
