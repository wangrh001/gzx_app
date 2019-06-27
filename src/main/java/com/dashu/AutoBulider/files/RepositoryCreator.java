package com.dashu.AutoBulider.files;

public class RepositoryCreator {

    public String create(String company, String sys, String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(createPackage(company, sys, entityName));
        stringBuffer.append(createImport(company, sys, entityName));
        stringBuffer.append(createClass(entityName));
        return stringBuffer.toString();
    }

    private String createPackage(String company, String sys, String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package com." + company + "." + sys + ".repository;\n");
        return stringBuffer.toString();
    }

    private String createImport(String company, String sys, String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        stringBuffer.append("import com." + company + "." + sys + ".entity." + UpEntityName + ";");
        stringBuffer.append("import org.springframework.data.jpa.repository.JpaRepository;\n");
        stringBuffer.append("import org.springframework.data.jpa.repository.JpaSpecificationExecutor;");
        stringBuffer.append("import org.springframework.data.jpa.repository.Modifying;");
        stringBuffer.append("import org.springframework.data.jpa.repository.Query;");
        stringBuffer.append("import org.springframework.data.repository.query.Param;");
        stringBuffer.append("import javax.transaction.Transactional;");
        stringBuffer.append("import java.util.List;");
        return stringBuffer.toString();
    }

    private String createClass(String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        stringBuffer.append("public interface " + UpEntityName + "Repository extends JpaRepository<" + UpEntityName + ", Long>,JpaSpecificationExecutor{\n");
        stringBuffer.append("public " + UpEntityName + " findById(@Param(value=\"id\") long id);");
        stringBuffer.append("public List<" + UpEntityName + "> findByStateNot(@Param(value=\"status\") int status);");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

}
