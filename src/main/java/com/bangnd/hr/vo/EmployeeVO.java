package com.bangnd.hr.vo;

import javax.persistence.*;
import java.util.*;

public class EmployeeVO {
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
    public String deptName;
    @Column
    public String techGradeName;

    public String getName() {
        return name;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getTechGradeName() {
        return techGradeName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setTechGradeName(String techGradeName) {
        this.techGradeName = techGradeName;
    }
}