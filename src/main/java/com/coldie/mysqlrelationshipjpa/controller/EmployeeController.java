package com.coldie.mysqlrelationshipjpa.controller;

import com.coldie.mysqlrelationshipjpa.model.Department;
import com.coldie.mysqlrelationshipjpa.model.Employee;
import com.coldie.mysqlrelationshipjpa.request.EmployeeRequest;
import com.coldie.mysqlrelationshipjpa.service.DepartmentService;
import com.coldie.mysqlrelationshipjpa.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Operation(
            description = "Get all employees.",
            summary = "This endpoint returns all the Employees available. Each employee also contains it's corresponding department."

    )
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @Operation(
            description = "Get a single employee by \"id\".",
            summary = "This endpoint returns an Employee available having the \"id\" provided. It comes with its corresponding department."

    )
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @Operation(
            description = "Get a list of employees by their department name.",
            summary = "This endpoint returns a list of Employees available by the their department name."

    )
    @GetMapping("/employee/department/{departmentName}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentName(@PathVariable String departmentName) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByDepartmentName(departmentName), HttpStatus.OK);
    }

    @Operation(
            description = "Create a new Employee",
            summary = "This endpoint is used to create a new Employee."

    )
    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        Department department = new Department();
        department.setName(employeeRequest.getDepartment());

        department = departmentService.saveDepartment(department);

        Employee employee = new Employee(employeeRequest);
        employee.setDepartment(department);

        employee = employeeService.saveEmployee(employee);

        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @Operation(
            description = "Update an Employee",
            summary = "This endpoint is used to update the details of an Employee. The \"id\" of the Employee must be provided"

    )
    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @Operation(
            description = "Delete an Employee",
            summary = "This endpoint is used to delete an Employee from the database. The \"id\" of the Employee must be provided"

    )
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return new ResponseEntity<String>(employeeService.deleteEmployeeById(id), HttpStatus.ACCEPTED);
    }
}
