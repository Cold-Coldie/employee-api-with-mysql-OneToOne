package com.coldie.mysqlrelationshipjpa.service;

import com.coldie.mysqlrelationshipjpa.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();
    Department saveDepartment(Department department);
}
