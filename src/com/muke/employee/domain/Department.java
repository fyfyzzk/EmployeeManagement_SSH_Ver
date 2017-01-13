package com.muke.employee.domain;

import java.util.HashSet;
import java.util.Set;

public class Department {
    private Integer dId;
    private String dName;
    private String dDes;

    /*  Collection of employees */
    private Set<Employee> employees = new HashSet<Employee>();
    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdDes() {
        return dDes;
    }

    public void setdDes(String dDes) {
        this.dDes = dDes;
    }
}
