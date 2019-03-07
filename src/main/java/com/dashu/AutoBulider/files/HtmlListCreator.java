package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.config.ConstantCfg;
import com.dashu.AutoBulider.entity.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询页面的html生成器
 */
public class HtmlListCreator {

    /**
     * 核心在于处理：1、日期搜索，需要增加开始和结束日期；2、散列配置搜索
     *
     * @return
     */
    public String create(List<DataModel> dataModelList, String sys, String entityName) {
        StringBuffer htmlCode = new StringBuffer();

        if (dataModelList != null) {
            htmlCode.append(ConstantCfg.HTML_HEAD);
            htmlCode.append("<body class=\"container\">\n");
            htmlCode.append("<br/>\n");
            htmlCode.append("<h4>列表</h4>");

            //先将dataModeList中的需要查询和显示的列整理出来
            List<DataModel> searchDataModelList = new ArrayList<DataModel>();
            List<DataModel> showDataModelList = new ArrayList<DataModel>();
            for (DataModel dataModel : dataModelList) {
                if (dataModel.getIfSearchColumn() == 1) {
                    searchDataModelList.add(dataModel);
                }
                if (dataModel.getIfShowColumn() == 1) {
                    showDataModelList.add(dataModel);
                }
            }
            //生成搜索区域
            htmlCode.append(createInputArea(searchDataModelList, sys, entityName, "search"));
            //生成列表区域
            htmlCode.append(createListArea(showDataModelList, sys, entityName));

            //新增按钮
            htmlCode.append("<div class=\"form-group\">\n");
            htmlCode.append("<div class=\"col-sm-2 control-label\">\n");
            htmlCode.append("<a href=\"/" + sys + "/" + entityName + "/toAdd\" th:href=\"@{/" + sys + "/" + entityName + "/toAdd}\" class=\"btn btn-info\">add</a>\n");
            htmlCode.append("    </div>\n");
            htmlCode.append("</div>\n");
            htmlCode.append("</body>\n");
            htmlCode.append("</html>");
        }

        return htmlCode.toString();
    }

    /**
     * 生成输入框的html
     *
     * @param inputDataModelList
     * @return
     */
    public static String createInputArea(List<DataModel> inputDataModelList, String sys, String entityName, String toDo) {
        StringBuffer htmlInputCode = new StringBuffer();
        int notDateinputItemsCount = 0;
        int hasDateinputItemsCount = 0;

        if (inputDataModelList != null) {
            for (DataModel dataModel : inputDataModelList) {
                hasDateinputItemsCount++;
                if (dataModel.getIfBusinessDate() != 1)
                    notDateinputItemsCount++;
            }
        }

        if (inputDataModelList != null) {
            htmlInputCode.append("<div> \n");
            if ("search".equals(toDo)) {
                htmlInputCode.append("<form class=\"form-horizontal\" th:action=\"@{/" + sys + "/" + entityName + "}\" th:object=\"${" + entityName + "SearchForm}\" method=\"post\">");
            } else if ("add".equals(toDo)) {
                htmlInputCode.append("<form class=\"form-horizontal\" th:action=\"@{/" + sys + "/" + entityName + "/" + toDo + "}\" th:object=\"${" + entityName + "}\" method=\"post\">");
            }

            htmlInputCode.append("<table>");

            int rowNum = 0;
            int i = 2 * notDateinputItemsCount % ConstantCfg.COLUMNS_PRE_ROW;
            int j = 2 * hasDateinputItemsCount % ConstantCfg.COLUMNS_PRE_ROW;
            //总需要显示的行数，是列数的两倍除以每行最大列数，向上取整后得到的数
            if ("search".equals(toDo)) {
                if (i == 0) {
                    rowNum = (2 * notDateinputItemsCount / ConstantCfg.COLUMNS_PRE_ROW);
                } else {
                    rowNum = (2 * notDateinputItemsCount / ConstantCfg.COLUMNS_PRE_ROW) + 1;
                }
            } else if ("add".equals(toDo)) {
                if (j == 0) {
                    rowNum = (2 * hasDateinputItemsCount / ConstantCfg.COLUMNS_PRE_ROW);
                } else {
                    rowNum = (2 * hasDateinputItemsCount / ConstantCfg.COLUMNS_PRE_ROW) + 1;
                }
            }
            for (int r = 0; r < rowNum; r++) {
                htmlInputCode.append("<tr>");
                for (int c = 0; c < ConstantCfg.COLUMNS_PRE_ROW / 2 && c < inputDataModelList.size() - r * 3; c++) {
                    //对不是业务日期查询的列查询，或者是添加业务，不是查询业务
                    if (inputDataModelList.get(3 * r + c).getIfBusinessDate() != 1 || "add".equals(toDo)) {
                        String columnNameCh = inputDataModelList.get(3 * r + c).getColumnNameCh();
                        String columnNameEn = inputDataModelList.get(3 * r + c).getColumnNameEn();

                        htmlInputCode.append("<td>" + columnNameCh + "</td>");
                        htmlInputCode.append("<td>");
                        if (inputDataModelList.get(3 * r + c).getIfScatter() != 1) {
                            htmlInputCode.append("<input th:field=\"*{" + columnNameEn + "}\"  value=\"\" class=\"form-control\"/>");
                        } else {
                            System.out.println("the column name = " + columnNameCh);
                            System.out.println("the if scatter is = " + inputDataModelList.get(c).getIfScatter());
                            htmlInputCode.append("<select th:field=\"*{" + columnNameEn + "}\" th:remove=\"all-but-first\">\n");
                            htmlInputCode.append("<option th:each=\"" + columnNameEn + " : ${" + columnNameEn + "s}\"\n");
                            htmlInputCode.append("th:value=\"${" + columnNameEn + ".id}\" th:text=\"${" + columnNameEn + ".name}\">Credit card</option>\n");
                            htmlInputCode.append("</select>");
                        }
                        htmlInputCode.append("</td>");
                    }
                }
                htmlInputCode.append("</tr>");
            }

            if ("search".equals(toDo)) {
                //对日期查询单独起一行
                for (DataModel dataModel : inputDataModelList) {
                    if (dataModel.getIfBusinessDate() == 1 && dataModel.getIfSearchColumn() == 1) {
                        htmlInputCode.append("<tr>");
                        htmlInputCode.append("<td>" + dataModel.getColumnNameCh() + "开始</td>");
                        htmlInputCode.append("<td>");
                        htmlInputCode.append("<input th:field=\"*{" + dataModel.getColumnNameEn() + "Start}\"  value=\"\" class=\"form-control\"/>");
                        htmlInputCode.append("</td>");

                        htmlInputCode.append("<td>" + dataModel.getColumnNameCh() + "结束</td>");
                        htmlInputCode.append("<td>");
                        htmlInputCode.append("<input th:field=\"*{" + dataModel.getColumnNameEn() + "End}\"  value=\"\" class=\"form-control\"/>");
                        htmlInputCode.append("</td>");
                        htmlInputCode.append("</tr>");
                    }
                }
            }
            if ("search".equals(toDo)) {
                htmlInputCode.append("<tr><td><input type=\"submit\" value=\"Search\" class=\"btn btn-info\"/></td></tr>");
            } else if ("add".equals(toDo)) {
                htmlInputCode.append("<tr><td><input type=\"submit\" value=\"保存\" class=\"btn btn-info\" /></td></tr>");
            }
            htmlInputCode.append("</table>");
            htmlInputCode.append("</form>");
            htmlInputCode.append("</div>");
        }
        return htmlInputCode.toString();
    }

    /**
     * 生成列表区域
     *
     * @param dataModels
     * @return
     */
    public String createListArea(List<DataModel> dataModels, String sys, String entityName) {
        StringBuffer listAreaCode = new StringBuffer();

        //下面显示列表内容
        listAreaCode.append("<div class=\"with:80%\">");
        listAreaCode.append("<table class=\"table table-hover\">");

        listAreaCode.append("<thead>");
        listAreaCode.append("<tr>");
        listAreaCode.append("<th>序号</th>");
        for (DataModel dataModel : dataModels) {
            listAreaCode.append("<th>" + dataModel.getColumnNameCh() + "</th>");
        }
        listAreaCode.append("<th>编辑</th>\n");
        listAreaCode.append("<th>删除</th>\n");
        listAreaCode.append("</tr>\n");
        listAreaCode.append("</thead>\n");

        listAreaCode.append("<tbody>");
        listAreaCode.append("<tr  th:each=\"" + entityName + "VO : ${" + entityName + "VOs}\">\n");
        listAreaCode.append("<td th:text=\"${" + entityName + "VO.id}\">1</td>\n");
        for (DataModel dataModel : dataModels) {
            if (dataModel.getIfScatter() == 1) {
                listAreaCode.append("<td th:text=\"${" + entityName + "VO." + dataModel.getColumnNameEn() + "Name}\">1</td>\n");
            } else {
                listAreaCode.append("<td th:text=\"${" + entityName + "VO." + dataModel.getColumnNameEn() + "}\">1</td>\n");
            }

        }
        listAreaCode.append("<td><a th:href=\"@{/" + sys + "/" + entityName + "/toModify(id=${" + entityName + "VO.id})}\">edit</a></td>\n");
        listAreaCode.append("<td><a th:href=\"@{/" + sys + "/" + entityName + "/delete(id=${" + entityName + "VO.id})}\">delete</a></td>");
        listAreaCode.append("</tr>\n");
        listAreaCode.append("</tbody>\n");

        listAreaCode.append("</table>\n");
        listAreaCode.append("</div>\n");
        return listAreaCode.toString();
    }

    public static void main(String[] args) {
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
        dataModels.add(dataModel);

        DataModel dataModel1 = new DataModel();
        dataModel1.setColumnNameCh("申请日期");
        dataModel1.setColumnNameEn("applyDate");
        dataModel1.setColumnType(4);
        dataModel1.setIfBusinessDate(1);
        dataModel1.setIfScatter(0);
        dataModel1.setIfSearchColumn(1);
        dataModel1.setIfShowColumn(1);
        dataModels.add(dataModel1);


        HtmlListCreator entityCreator = new HtmlListCreator();
        System.out.println(entityCreator.create(dataModels, "test", "test"));
    }

}
