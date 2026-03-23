package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.cg.dto.*;
import com.cg.entity.Employee;
import com.cg.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp) {
        return new ResponseEntity<>(service.addEmployee(emp), HttpStatus.CREATED);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }
    @GetMapping("/employees/byDept")
    public ResponseEntity<List<Employee>> getByDept(@RequestParam String name) {
        return ResponseEntity.ok(service.getByDepartment(name));
    }

    @GetMapping("/departments/count")
    public ResponseEntity<List<DepartmentEmployeeCountDTO>> count() {
        return ResponseEntity.ok(service.countEmployees());
    }
    @GetMapping("/employees/byMobile")
    public ResponseEntity<EmployeeDeptDTO> getByMobile(@RequestParam String mobile) {
        return ResponseEntity.ok(service.getByMobile(mobile));
    }
}