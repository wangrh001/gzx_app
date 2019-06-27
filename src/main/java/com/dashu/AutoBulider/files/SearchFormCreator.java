package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.config.ConstantCfg;
import com.dashu.AutoBulider.entity.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询需要的Form生成器
 */
public class SearchFormCreator {
    /**
     * 根据列生成Form对象代码，核心是对于查询日期范围的处理、查询状态中"全部的处理"
     *
     * @param dataModels
     * @return
     */
    public String create(List<DataModel> dataModels, String company, String sys,String entityName) {
        StringBuffer stringBuffer = new StringBuffer();
        if (dataModels != null) {
            String UpEntityName = Character.toUpperCase(entityName.charAt(0)) + entityName.substring(1);
            stringBuffer.append("package com." + company + "." + sys + ".form;\n");
            stringBuffer.append("import javax.persistence.*;\n");
            stringBuffer.append("import java.util.*;\n");
            stringBuffer.append("public class " + UpEntityName + "SearchForm {");
            List<DataModel> dataModels1 = new ArrayList<DataModel>();
            for (DataModel dataModel : dataModels) {
                //是查询列
                if (dataModel.getIfSearchColumn() == 1) {
                    DataModel dataModel1 = new DataModel();
                    //如果是业务日期，需要生成查询的开始时间和结束时间
                    if (dataModel.getIfBusinessDate() == 1) {
                        DataModel dataModel2 = new DataModel();
                        dataModel1.setColumnType(dataModel.getColumnType());
                        dataModel1.setColumnNameEn(dataModel.getColumnNameEn() + "Start");
                        dataModel2.setColumnType(dataModel.getColumnType());
                        dataModel2.setColumnNameEn(dataModel.getColumnNameEn() + "End");
                        dataModels1.add(dataModel2);
                    } else {
                        dataModel1.setColumnNameEn(dataModel.getColumnNameEn());
                        dataModel1.setColumnType(ConstantCfg.COLUMN_TYPE_STRING);

                    }
                    dataModels1.add(dataModel1);
                }
            }
            stringBuffer.append(EntityCreator.createBusinessColumn(dataModels1));
            stringBuffer.append("}");
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
        SearchFormCreator searchFormCreator = new SearchFormCreator();
        System.out.println(searchFormCreator.create(dataModels, "dashu", "test","test"));
    }
}
