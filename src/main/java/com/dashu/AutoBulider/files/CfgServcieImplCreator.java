package com.dashu.AutoBulider.files;

public class CfgServcieImplCreator {

    public String create(String company,
                         String sys,
                         String entity,
                         String columnName) {

        StringBuffer stringBuffer = new StringBuffer();
        String UpColumn = Character.toUpperCase(columnName.charAt(0)) + columnName.substring(1);
        String UpEntityName = Character.toUpperCase(entity.charAt(0)) + entity.substring(1);

        stringBuffer.append("package com." + company + "." + sys + ".service.impl;\n");
        stringBuffer.append("import  com." + company + "." + sys + ".entity.*;\n");
        stringBuffer.append("import  com." + company + "." + sys + ".service.*;\n");
        stringBuffer.append("import  com." + company + "." + sys + ".repository.*;\n");
        stringBuffer.append("import java.util.List;");
        stringBuffer.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        stringBuffer.append("import org.springframework.stereotype.Service;\n");

        stringBuffer.append("@Service\n");
        stringBuffer.append("public class " + UpEntityName + UpColumn + "ServiceImpl implements " + UpEntityName + UpColumn + "Service { \n");
        stringBuffer.append("@Autowired\n");
        stringBuffer.append("private " + UpEntityName + UpColumn + "Repository " + entity + UpColumn + "Repository;\n");

        stringBuffer.append("@Override\n");
        stringBuffer.append("public List<" + UpEntityName + UpColumn + "> getAll(){");
        stringBuffer.append("return " + entity + UpColumn + "Repository.findAll();");
        stringBuffer.append("}");

        stringBuffer.append("@Override\n");
        stringBuffer.append("public " + UpEntityName + UpColumn + " get" + UpEntityName + UpColumn + "ById(int id){");
        stringBuffer.append("return " + entity + UpColumn + "Repository.findOne(id);");
        stringBuffer.append("}");


        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
