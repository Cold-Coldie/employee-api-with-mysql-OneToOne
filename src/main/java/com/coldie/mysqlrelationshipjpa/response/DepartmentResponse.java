package com.coldie.mysqlrelationshipjpa.response;

public class DepartmentResponse {
    private Long id;

    private String departmentName;

    private String employeeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "DepartmentResponse{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
