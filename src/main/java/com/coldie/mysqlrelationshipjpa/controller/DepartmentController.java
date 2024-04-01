package com.coldie.mysqlrelationshipjpa.controller;

import com.coldie.mysqlrelationshipjpa.model.Department;
import com.coldie.mysqlrelationshipjpa.response.DepartmentResponse;
import com.coldie.mysqlrelationshipjpa.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(
            description = "Get all departments.",
            summary = "This endpoint returns all the Departments available. Each department also contains it's corresponding employee."

    )
    @GetMapping("/department")
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        List<DepartmentResponse> departmentResponses = new ArrayList<>();

        departments.forEach(department -> {
            DepartmentResponse departmentResponse = new DepartmentResponse();
            departmentResponse.setId(department.getId());
            departmentResponse.setDepartmentName(department.getName());
            departmentResponse.setEmployeeName(department.getEmployee().getName());

            departmentResponses.add(departmentResponse);
        });

        return new ResponseEntity<List<DepartmentResponse>>(departmentResponses, HttpStatus.OK);
    }
}
