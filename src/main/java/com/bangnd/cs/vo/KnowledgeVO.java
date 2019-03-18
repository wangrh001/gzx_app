package com.bangnd.cs.vo;

import javax.persistence.Column;

public class KnowledgeVO {
    @Column
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

    public String getQuestionName() {
        return questionName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}