package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.config.ConstantCfg;
import com.dashu.AutoBulider.entity.DataModel;

import java.util.ArrayList;
import java.util.List;

public class HtmlAddCreator {

    public String create(List<DataModel> dataModelList){
        StringBuffer addHtml = new StringBuffer();
        if(dataModelList!=null){
            String entityName=dataModelList.get(0).getTableNames();
            addHtml.append(ConstantCfg.HTML_HEAD);
            addHtml.append("<body class=\"container\">\n");
            addHtml.append("<br/>\n");
            addHtml.append("<h4>新增</h4>");

            //先将dataModeList中的需要新增的列整理出来
            List<DataModel> addDataModelList = new ArrayList<DataModel>();

            for(DataModel dataModel:dataModelList){
                if(dataModel.getIfModifyable()==1){
                    addDataModelList.add(dataModel);
                }
            }
            //生成搜索区域
            addHtml.append(HtmlListCreator.createInputArea(addDataModelList,"add"));

            addHtml.append("<div class=\"form-group\">\n");
            addHtml.append("<div class=\"col-sm-2 control-label\">\n");
            addHtml.append("<a href=\"/"+entityName+"/add\" th:href=\"@{/"+entityName+"/add}\" class=\"btn btn-info\">add</a>\n");
            addHtml.append("    </div>\n");
            addHtml.append("</div>\n");
            addHtml.append(    "</body>\n");
            addHtml.append("</html>");
        }

        return addHtml.toString();
    }

    public static void main(String[] args){
        List<DataModel> dataModels = new ArrayList<DataModel>();
        DataModel dataModel = new DataModel();
        dataModel.setTableNames("TestEntity");
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


        HtmlAddCreator entityCreator = new HtmlAddCreator();
        System.out.println(entityCreator.create(dataModels));
    }
}
