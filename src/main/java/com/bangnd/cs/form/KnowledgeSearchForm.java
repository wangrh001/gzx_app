package com.bangnd.cs.form;

import javax.persistence.Column;

public class KnowledgeSearchForm {
    @Column
    public String questionName;
    @Column
    public String question;
    @Column
    public String questionType;

    public String getQuestionName() {
        return questionName;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
}