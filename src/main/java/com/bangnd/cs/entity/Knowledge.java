package com.bangnd.cs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_cs_knowledge")
public class Knowledge {
    @Id
    @GeneratedValue
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String questionName;
    @Column
    public String question;
    @Column
    public int questionType;
    @Column
    public String answer;

    public String getQuestionName() {
        return questionName;
    }

    public String getQuestion() {
        return question;
    }

    public int getQuestionType() {
        return questionType;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Column
    private int state;
    @Column
    private long creator;
    @Column
    private Date createTime;
    @Column
    private long updator;
    @Column
    private Date updateTime;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getUpdator() {
        return updator;
    }

    public void setUpdator(long updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}