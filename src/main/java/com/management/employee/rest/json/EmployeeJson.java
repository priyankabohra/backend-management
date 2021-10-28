package com.management.employee.rest.json;

public class EmployeeJson {
    private  Integer empId;
    private String empName;
    private String empEmail;
    private String empDesignation;

    public EmployeeJson(){}

    public EmployeeJson(Integer empId,String empName, String empEmail, String empDesignation){
        this.empId=empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empDesignation = empDesignation;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }
}
