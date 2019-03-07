package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.util.Date;

//产品规则表
@Entity
@Table(name = "t_cbs_product_rule")
public class ProdRule {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long productId;

    //1、能不能进件的规则；2、额度的规则；3、贷款类型限制，单笔、循环；都可以；
    //4、借款期限限制；5、是否需要共同借款人
    @Column
    private long ruleType;
    //1、完全不能违反；2、违反后需要提示
    @Column
    private long ruleElastic;
    @Column
    private String ruleExpression;
    //同一个id的多个规则是and关系
    @Column
    private long andGroupId;
    //同一个id的多个规则是or关系
    @Column
    private long orGroupId;
    //表达式语言描述
    @Column
    private String expressionDesc;
    @Column
    private long ruleState;
    @Column
    private Date createTime;
    @Column
    private long creator;
    @Column
    private Date updateTime;
    @Column
    private long updator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getRuleType() {
        return ruleType;
    }

    public void setRuleType(long ruleType) {
        this.ruleType = ruleType;
    }

    public long getRuleElastic() {
        return ruleElastic;
    }

    public void setRuleElastic(long ruleElastic) {
        this.ruleElastic = ruleElastic;
    }

    public String getRuleExpression() {
        return ruleExpression;
    }

    public void setRuleExpression(String ruleExpression) {
        this.ruleExpression = ruleExpression;
    }

    public long getRuleState() {
        return ruleState;
    }

    public void setRuleState(long ruleState) {
        this.ruleState = ruleState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getUpdator() {
        return updator;
    }

    public void setUpdator(long updator) {
        this.updator = updator;
    }

    public String getExpressionDesc() {
        return expressionDesc;
    }

    public void setExpressionDesc(String expressionDesc) {
        this.expressionDesc = expressionDesc;
    }

    public long getAndGroupId() {
        return andGroupId;
    }

    public void setAndGroupId(long andGroupId) {
        this.andGroupId = andGroupId;
    }

    public long getOrGroupId() {
        return orGroupId;
    }

    public void setOrGroupId(long orGroupId) {
        this.orGroupId = orGroupId;
    }
}
