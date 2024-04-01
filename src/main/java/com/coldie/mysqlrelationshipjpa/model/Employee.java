package com.coldie.mysqlrelationshipjpa.model;

import com.coldie.mysqlrelationshipjpa.request.EmployeeRequest;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Long id;

    @NotNull(message = "Name should not be null")
    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    @JsonManagedReference
    private Department department;

    public Employee() {
    }

    public Employee(EmployeeRequest employeeRequest) {
        this.name = employeeRequest.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
