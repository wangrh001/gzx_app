package com.bangnd.hr.vo;

import javax.persistence.*;
import java.util.*;
import java.math.BigDecimal;

public class CurriculumVO {
    @Column
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String name;
    @Column
    public String typeName;
    @Column
    public String teacherName;
    @Column
    public String posIdName;

    public String getName() {
        return name;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getPosIdName() {
        return posIdName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setPosIdName(String posIdName) {
        this.posIdName = posIdName;
    }
}