package com.dashu.AutoBulider.files;

import com.dashu.AutoBulider.entity.DataModel;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuffer;
import com.dashu.AutoBulider.config.ConstantCfg;

public class EntityCreator {
    public String create(List<DataModel> dataModels,String company,String sys){
        StringBuffer javaCode= new StringBuffer();
        if(dataModels!=null && dataModels.size()>0){
            String entityName = dataModels.get(0).getTableNames();
            String UpEntityName=Character.toUpperCase(entityName.charAt(0))+entityName.substring(1);
            javaCode.append("package com."+company+"."+sys+".entity;");
            javaCode.append("import javax.persistence.*;");
            javaCode.append("import java.math.BigDecimal;");
            javaCode.append("import java.util.Date;");
            javaCode.append("@Entity");
            javaCode.append("@Table(name=\""+entityName+"\")");
            javaCode.append("public class "+UpEntityName+"{");
            javaCode.append("@Id");
            javaCode.append("@GeneratedValue ");
            javaCode.append("public long id;");
            javaCode.append("public long getId() { return id; }");
            javaCode.append("public void setId(long id) { this.id = id; }");

            //添加业务字段
            javaCode.append(createBusinessColumn(dataModels));
            //添加业务表基础字段
            javaCode.append(createBasisColumn());
            //添加类结束括号
            javaCode.append("}");
        }
        System.out.println(javaCode.toString());
        return javaCode.toString();
    }

    //生成业务元素
    public static String createBusinessColumn(List<DataModel> dataModels){
        StringBuffer javaCode = new StringBuffer();
        for(DataModel dataModel:dataModels){
            //javaCode.append("//").append(dataModel.getColumnNameCh());
            javaCode.append("@Column \n");
            switch (dataModel.getColumnType()){
                case ConstantCfg.COLUMN_TYPE_INT:
                    javaCode.append("public int ");
                    break;
                case ConstantCfg.COLUMN_TYPE_LONG:
                    javaCode.append("public long ");
                    break;
                case ConstantCfg.COLUMN_TYPE_STRING:
                    javaCode.append("public String ");
                    break;
                case ConstantCfg.COLUMN_TYPE_DATE:
                    javaCode.append("public Date ");
                    break;
                case ConstantCfg.COLUMN_TYPE_BIGDECIMAL:
                    javaCode.append("public BigDecimal ");
                    break;
            }
            javaCode.append(dataModel.getColumnNameEn()+";");
        }

        for(DataModel dataModel:dataModels){
            String columnName=dataModel.getColumnNameEn();
            switch (dataModel.getColumnType()){
                case ConstantCfg.COLUMN_TYPE_INT:
                    javaCode.append("public int get");
                    break;
                case ConstantCfg.COLUMN_TYPE_LONG:
                    javaCode.append("public long get");
                    break;
                case ConstantCfg.COLUMN_TYPE_STRING:
                    javaCode.append("public String get");
                    break;
                case ConstantCfg.COLUMN_TYPE_DATE:
                    javaCode.append("public Date get");
                    break;
                case ConstantCfg.COLUMN_TYPE_BIGDECIMAL:
                    javaCode.append("public BigDecimal get");
                    break;
            }
            javaCode.append(Character.toUpperCase(columnName.charAt(0))).append(columnName.substring(1)+"(){");
            javaCode.append("return "+dataModel.getColumnNameEn()+";}");

        }
        for(DataModel dataModel:dataModels){
            String columnName=dataModel.getColumnNameEn();
            String columnNameFormated = Character.toUpperCase(columnName.charAt(0))+columnName.substring(1);
            switch (dataModel.getColumnType()){
                case ConstantCfg.COLUMN_TYPE_INT:
                    javaCode.append("public void set").append(columnNameFormated+"(int "+columnName+"){");
                    break;
                case ConstantCfg.COLUMN_TYPE_LONG:
                    javaCode.append("public void set").append(columnNameFormated+"(long "+columnName+"){");
                    break;
                case ConstantCfg.COLUMN_TYPE_STRING:
                    javaCode.append("public void set").append(columnNameFormated+"(String "+columnName+"){");
                    break;
                case ConstantCfg.COLUMN_TYPE_DATE:
                    javaCode.append("public void set").append(columnNameFormated+"(Date "+columnName+"){");
                    break;
                case ConstantCfg.COLUMN_TYPE_BIGDECIMAL:
                    javaCode.append("public void set").append(columnNameFormated+"(BigDecimal "+columnName+"){");
                    break;
            }
            javaCode.append("this."+columnName+"="+columnName+";}");
        }
        return javaCode.toString();
    }
    //业务表生成基本元素
    private String createBasisColumn(){
        StringBuffer javaCode = new StringBuffer();
        javaCode.append("@Column \n");
        javaCode.append("private int state;");
        javaCode.append("@Column \n");
        javaCode.append("private long creator;");
        javaCode.append("@Column \n");
        javaCode.append("private Date createTime;");
        javaCode.append("@Column \n");
        javaCode.append("private long updator;");
        javaCode.append("@Column \n");
        javaCode.append("private Date updateTime;");

        javaCode.append("public int getState() {\n");
        javaCode.append(" return state;\n");
        javaCode.append("}\n");
        javaCode.append("public void setState(int state) {\n");
        javaCode.append("this.state = state;\n");
        javaCode.append("}\n");
        javaCode.append("public long getCreator() {\n");
        javaCode.append("return creator;\n");
        javaCode.append("}\n");
        javaCode.append("public void setCreator(long creator) {\n");
        javaCode.append("this.creator = creator;\n");
        javaCode.append("}\n");
        javaCode.append("public Date getCreateTime() {\n");
        javaCode.append("return createTime;\n");
        javaCode.append("}\n");
        javaCode.append("public void setCreateTime(Date createTime) {\n");
        javaCode.append("this.createTime = createTime;\n");
        javaCode.append("}\n");
        javaCode.append("public long getUpdator() {\n");
        javaCode.append("return updator;\n");
        javaCode.append("}\n");
        javaCode.append("public void setUpdator(long updator) {\n");
        javaCode.append("this.updator = updator;\n");
        javaCode.append("}\n");
        javaCode.append("public Date getUpdateTime() {\n");
        javaCode.append("return updateTime;\n");
        javaCode.append("}\n");
        javaCode.append("public void setUpdateTime(Date updateTime) {\n");
        javaCode.append("this.updateTime = updateTime;\n");
        javaCode.append("}");
        return javaCode.toString();
    }

    public static void main(String[] arg){
        List<DataModel> dataModels = new ArrayList<DataModel>();
        DataModel dataModel = new DataModel();
        dataModel.setTableNames("TestEntity");
        dataModel.setColumnNameCh("姓名");
        dataModel.setColumnNameEn("name");
        dataModel.setColumnType(3);
        dataModels.add(dataModel);

        DataModel dataModel1 = new DataModel();
        dataModel1.setColumnNameCh("申请日期");
        dataModel1.setColumnNameEn("applyDate");
        dataModel1.setColumnType(4);
        dataModels.add(dataModel1);


        EntityCreator entityCreator = new EntityCreator();
        entityCreator.create(dataModels,"dashu","test");
    }
}
