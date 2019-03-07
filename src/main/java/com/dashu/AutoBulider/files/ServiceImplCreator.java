package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.entity.DataModel;

import java.util.Date;
import java.util.List;

public class ServiceImplCreator {
    public String create(List<DataModel> dataModelList, String company, String sys, String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(createPackage(company, sys));
        stringBuffer.append(createImport(company, sys, entityName));
        stringBuffer.append(createClass(entityName));
        stringBuffer.append(createPrivateMember(entityName));
        stringBuffer.append(createGetList(entityName, dataModelList));
        stringBuffer.append(createSave(entityName));
        stringBuffer.append(createGetEntityById(entityName));
        stringBuffer.append(createMerge(entityName));
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private String createPackage(String company, String sys) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package com." + company + "." + sys + ".service.impl;\n");
        return stringBuffer.toString();
    }

    private String createImport(String company, String sys, String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        stringBuffer.append("import com." + company + "." + sys + ".entity." + UpEntityName + ";\n");
        stringBuffer.append("import com." + company + "." + sys + ".service.*;\n");
        stringBuffer.append("import com." + company + "." + sys + ".form." + UpEntityName + "SearchForm;\n");
        stringBuffer.append("import java.util.*;\n");
        stringBuffer.append("import com." + company + "." + sys + ".repository." + UpEntityName + "Repository;");
        stringBuffer.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        stringBuffer.append("import org.springframework.data.jpa.domain.Specification;");
        stringBuffer.append("import org.springframework.stereotype.Service;");
        stringBuffer.append("import javax.persistence.criteria.CriteriaBuilder;\n");
        stringBuffer.append("import javax.persistence.criteria.CriteriaQuery;\n");
        stringBuffer.append("import javax.persistence.criteria.Predicate;\n");
        stringBuffer.append("import javax.persistence.criteria.Root;\n");
        stringBuffer.append("import javax.transaction.Transactional;\n");
        stringBuffer.append("import java.text.SimpleDateFormat;\n");

        return stringBuffer.toString();
    }

    private String createClass(String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        stringBuffer.append("@Service\n");
        stringBuffer.append("public class " + UpEntityName + "ServiceImpl implements " + UpEntityName + "Service{\n");
        return stringBuffer.toString();
    }

    private String createPrivateMember(String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        stringBuffer.append("@Autowired\n");
        stringBuffer.append("private " + UpEntityName + "Repository " + entityName + "Repository;");
        return stringBuffer.toString();
    }

    private String createGetList(String entityName, List<DataModel> dataModels) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        stringBuffer.append("public List<" + UpEntityName + "> get" + UpEntityName + "List(" + UpEntityName + "SearchForm " + entityName + "SearchForm){");
        stringBuffer.append("Specification specification = new Specification<" + UpEntityName + ">() {");
        stringBuffer.append("@Override\n");
        stringBuffer.append("public Predicate toPredicate(Root<" + UpEntityName + "> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {");
        stringBuffer.append("List<Predicate> predicates = new ArrayList<Predicate>();");
        for (DataModel dataModel : dataModels) {
            if (dataModel.getIfSearchColumn() == 1) {
                String columnName = dataModel.getColumnNameEn();
                String UpColumnName = Character.toUpperCase(columnName.charAt(0)) + columnName.substring(1);
                //离散值要处理选择零和非零的问题
                if (dataModel.getIfScatter() == 1) {
                    stringBuffer.append("if (" + entityName + "SearchForm.get" + UpColumnName + "()!=null && !\"\".equals(" + entityName + "SearchForm.get" + UpColumnName + "())) {\n");
                    stringBuffer.append("   if(\"0\".equals(" + entityName + "SearchForm.get" + UpColumnName + "())){\n");
                    stringBuffer.append("        predicates.add(cb.notEqual(root.get(\"" + columnName + "\"), " + entityName + "SearchForm.get" + UpColumnName + "()));\n");
                    stringBuffer.append("   }else {\n");
                    stringBuffer.append("        predicates.add(cb.equal(root.get(\"" + columnName + "\"), " + entityName + "SearchForm.get" + UpColumnName + "()));\n");
                    stringBuffer.append("   }\n");
                    stringBuffer.append("}");
                    //日期要处理日期格式转换问题
                } else if (dataModel.getIfBusinessDate() == 1) {
                    stringBuffer.append("if (" + entityName + "SearchForm.get" + UpColumnName + "Start()!=null && !\"\".equals(" + entityName + "SearchForm.get" + UpColumnName + "Start())" +
                            "&&" + entityName + "SearchForm.get" + UpColumnName + "End()!=null && !\"\".equals(" + entityName + "SearchForm.get" + UpColumnName + "End())) {\n");
                    stringBuffer.append("predicates.add(cb.between(root.get(\"" + columnName + "\").as(Date.class)," + entityName + "SearchForm.get" + UpColumnName + "Start()," + entityName + "SearchForm.get" + UpColumnName + "End()));}");
                } else {
                    stringBuffer.append("if (" + entityName + "SearchForm.get" + UpColumnName + "()!=null && !\"\".equals(" + entityName + "SearchForm.get" + UpColumnName + "())) {\n");
                    stringBuffer.append("predicates.add(cb.like(root.get(\"" + columnName + "\").as(String.class), \"%\" + " + entityName + "SearchForm.get" + UpColumnName + "() + \"%\"));}\n");
                }
            }
        }
        stringBuffer.append("predicates.add(cb.notEqual(root.get(\"state\").as(Integer.class), new Integer(100)));");
        stringBuffer.append("Predicate[] p = new Predicate[predicates.size()];\n");
        stringBuffer.append("return cb.and(predicates.toArray(p));");
        stringBuffer.append("}};");
        stringBuffer.append("return " + entityName + "Repository.findAll(specification);");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private String createSave(String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        stringBuffer.append("@Override\n");
        stringBuffer.append("public void save(" + UpEntityName + " " + entityName + "){");
        stringBuffer.append(entityName + "Repository.save(" + entityName + ");");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private String createGetEntityById(String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        stringBuffer.append("@Override\n");
        stringBuffer.append("public " + UpEntityName + " get" + UpEntityName + "ById(long id){");
        stringBuffer.append("return " + entityName + "Repository.findById(id);");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private String createMerge(String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
        stringBuffer.append("@Override\n");
        stringBuffer.append("public void merge(" + UpEntityName + " " + entityName + "){");
        stringBuffer.append(entityName + "Repository.save(" + entityName + ");");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        ServiceImplCreator serviceImplCreator = new ServiceImplCreator();
        System.out.println(serviceImplCreator.create(null, "dashu", "test", "test"));
    }
}
