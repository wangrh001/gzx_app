package com.bangnd.hr.form;

import javax.persistence.*;
import java.util.*;

public class CurriculumSearchForm {
    @Column
    public String name;
    @Column
    public String type;
    @Column
    public String teacherName;
    @Column
    public String posId;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getPosId() {
        return posId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }
}