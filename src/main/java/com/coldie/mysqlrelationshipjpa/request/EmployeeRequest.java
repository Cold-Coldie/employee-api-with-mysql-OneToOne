package com.coldie.mysqlrelationshipjpa.request;

public class EmployeeRequest {
    private String name;

    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
