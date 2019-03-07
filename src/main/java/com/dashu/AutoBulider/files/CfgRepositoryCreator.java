package com.dashu.AutoBulider.files;

public class CfgRepositoryCreator {

    public String create(String company,
                         String sys,
                         String entity,
                         String columnName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpColumn = Character.toUpperCase(columnName.charAt(0)) + columnName.substring(1);
        String UpEntityName = Character.toUpperCase(entity.charAt(0)) + entity.substring(1);

        stringBuffer.append("package com." + company + "." + sys + ".repository;\n");
        stringBuffer.append("import  com." + company + "." + sys + ".entity.*;\n");
        stringBuffer.append("import org.springframework.data.jpa.repository.JpaRepository;");
        stringBuffer.append("public interface " + UpEntityName + UpColumn + "Repository extends JpaRepository<" + UpEntityName + UpColumn + ", Integer> { \n");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
