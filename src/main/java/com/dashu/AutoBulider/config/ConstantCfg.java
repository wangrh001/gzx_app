package com.dashu.AutoBulider.config;

public class ConstantCfg {
    public final static int COLUMN_TYPE_INT=1;
    public final static int COLUMN_TYPE_LONG=2;
    public final static int COLUMN_TYPE_STRING=3;
    public final static int COLUMN_TYPE_DATE=4;
    public final static int COLUMN_TYPE_BIGDECIMAL=5;

    public final static int ORDER_STATE_INITIAL=1;

    //每行的列数
    public final static int COLUMNS_PRE_ROW=6;

    //html固定的引用文件
    public final static String HTML_HEAD="<!DOCTYPE html>\n" +
            "<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\"/>\n" +
            "    <title>customerList</title>\n" +
            "    <link rel=\"stylesheet\" type = \"text/css\" th:href=\"@{/css/bootstrap.css}\"/>\n" +
            "    <link rel=\"stylesheet\" type = \"text/css\" th:href=\"@{/css/daterangepicker.css}\"/>\n" +
            "    <link rel=\"stylesheet\" th:href=\"@{/css/table.css}\"/>\n" +
            "    <script type=\"text/javascript\" th:src=\"@{/css/date.js}\"/>\n" +
            "    <script type=\"text/javascript\" th:src=\"@{/css/daterangepicker.js}\"/>\n" +
            "    <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js\"/>\n" +
            "    <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.1/moment.min.js\"/>\n" +
            "</head>";

}
