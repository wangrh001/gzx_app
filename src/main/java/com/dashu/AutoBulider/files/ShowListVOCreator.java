package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.entity.DataModel;
import com.dashu.AutoBulider.config.ConstantCfg;

import java.util.ArrayList;
import java.util.List;

/*
查询列表需要的vo生成器，主要有散列值需要显示对应的中文名字，而不是id
 */
public class ShowListVOCreator {

    /**
     * 生成查询列表需要的vo
     *
     * @param dataModelList
     * @return
     */
    public String create(List<DataModel> dataModelList, String company, String sys,String entityName) {
        StringBuffer voCode = new StringBuffer();
        if (dataModelList != null) {
            String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
            voCode.append("package com." + company + "." + sys + ".vo;\n");
            voCode.append("import javax.persistence.*;\n");
            voCode.append("import java.util.*;\n");
            voCode.append("import java.math.BigDecimal;\n");
            voCode.append("public class " + UpEntityName + "VO {");
            voCode.append("@Column\n");
            voCode.append("private long id;");
            voCode.append("public long getId() { return id; }");
            voCode.append("public void setId(long id) { this.id = id; }");

            List<DataModel> dataModels1 = new ArrayList<DataModel>();
            for (DataModel dataModel : dataModelList) {
                if (dataModel.getIfShowColumn() == 1) {
                    DataModel dataModel1 = new DataModel();
                    //如果是散列值，需要显示该列的中文名称
                    if (dataModel.getIfScatter() == 1) {
                        dataModel1.setColumnType(ConstantCfg.COLUMN_TYPE_STRING);
                        dataModel1.setColumnNameEn(dataModel.getColumnNameEn() + "Name");
                    } else {
                        dataModel1.setColumnType(dataModel.getColumnType());
                        dataModel1.setColumnNameEn(dataModel.getColumnNameEn());
                    }
                    dataModels1.add(dataModel1);
                }
            }
            voCode.append(EntityCreator.createBusinessColumn(dataModels1));
            voCode.append("}");
        }
        return voCode.toString();
    }

    public static void main(String[] args) {
        List<DataModel> dataModels = new ArrayList<DataModel>();
        DataModel dataModel = new DataModel();
        dataModel.setSysName("test");
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
        dataModel1.setSysName("test");
        dataModel1.setTableNames("test");
        dataModel1.setColumnNameCh("申请日期");
        dataModel1.setColumnNameEn("applyDate");
        dataModel1.setColumnType(4);
        dataModel1.setIfBusinessDate(1);
        dataModel1.setIfScatter(0);
        dataModel1.setIfSearchColumn(1);
        dataModel1.setIfShowColumn(1);
        dataModel1.setIfModifyable(1);
        dataModels.add(dataModel1);
        ShowListVOCreator showListVOCreator = new ShowListVOCreator();
        System.out.println(showListVOCreator.create(dataModels, "dashu", "test","test"));
    }
}
