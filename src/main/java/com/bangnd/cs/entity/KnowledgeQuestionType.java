package com.bangnd.cs.entity;

import javax.persistence.*;

@Entity
@Table(name = "cfg_knowledge_questionType")
public class KnowledgeQuestionType {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}