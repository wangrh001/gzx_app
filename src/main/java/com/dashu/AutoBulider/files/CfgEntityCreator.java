package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.entity.DataModel;

import java.util.ArrayList;
import java.util.List;

//如果某个entity中的column是一个配置信息的离散值，那么这个类是创建这个配置实体
public class CfgEntityCreator {
    /**
     * 创建配置实体
     *
     * @param tableName
     * @param columnName
     * @return
     */
    public String create(String company,
                         String sys,
                         String tableName,
                         String columnName) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package com." + company + "." + sys + ".entity;\n");
        stringBuffer.append("import javax.persistence.*;");
        stringBuffer.append("@Entity \n");
        stringBuffer.append("@Table(name=\"cfg_" + tableName + "_" + columnName).append("\") \n");
        String UpColumn = Character.toUpperCase(columnName.charAt(0)) + columnName.substring(1);
        String UpEntityName = Character.toUpperCase(tableName.charAt(0)) + tableName.substring(1);
        stringBuffer.append("public class " + UpEntityName + UpColumn + "{ \n");
        stringBuffer.append("@Id \n");
        stringBuffer.append("private int id;\n");
        stringBuffer.append("@Column(nullable = false)\n");
        stringBuffer.append("private String name;\n");

        stringBuffer.append("public int getId() {\n");
        stringBuffer.append("return id;\n");
        stringBuffer.append("}\n");

        stringBuffer.append("public void setId(int id) {\n");
        stringBuffer.append("this.id = id;\n");
        stringBuffer.append("}\n");

        stringBuffer.append("public String getName() {\n");
        stringBuffer.append("return name;\n");
        stringBuffer.append("}\n");

        stringBuffer.append("public void setName(String name) {\n");
        stringBuffer.append("this.name = name;\n");
        stringBuffer.append("}");
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    /**
     * 创建生成配置表数据的insert脚本
     *
     * @param tableName
     * @param columnName
     * @param scatterValues
     * @return
     */
    public String createInsertScript(String tableName,
                                     String columnName,
                                     List<String> scatterValues) {
        StringBuffer stringBuffer = new StringBuffer();
        if (scatterValues != null) {
            for (String s : scatterValues) {
                stringBuffer.append("insert into t_" + tableName + "_" + columnName + " (name) value(\'" + s + "\')\n");
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
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
        CfgEntityCreator cfgEntityCreator = new CfgEntityCreator();

        for (DataModel dataModel2 : dataModels) {
            if (dataModel2.getIfScatter() == 1) {
                System.out.println(cfgEntityCreator.create(dataModel2.getTableNames(),
                        dataModel2.getColumnNameEn(),
                        "dashu", "test"));
            }
        }
    }
}
