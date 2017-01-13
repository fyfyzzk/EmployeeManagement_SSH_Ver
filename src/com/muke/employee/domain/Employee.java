package com.muke.employee.domain;

import java.util.Date;

public class Employee {
    private Integer eId;
    private String eName;
    private String eSex;
    private Date eBirth;
    private Date eJoinDate;
    private String eNo;
    private String username;
    private String password;

    /*  department which employee belongs to */
    private Department department;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public Date geteBirth() {
        return eBirth;
    }

    public void seteBirth(Date eBirth) {
        this.eBirth = eBirth;
    }

    public Date geteJoinDate() {
        return eJoinDate;
    }

    public void seteJoinDate(Date eJoinDate) {
        this.eJoinDate = eJoinDate;
    }

    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
