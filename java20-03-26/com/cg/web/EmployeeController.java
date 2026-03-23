package com.cg.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.cg.entity.*;
import com.cg.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/departments")
    public ResponseEntity<String> addDepartment(@RequestBody Department dept) {
        service.addDepartment(dept);
        return new ResponseEntity<>("Department added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
        service.addEmployee(emp);
        return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/byDept")
    public ResponseEntity<List<Employee>> getByDepartment(@RequestParam String name) {
        return new ResponseEntity<>(service.getByDepartment(name), HttpStatus.OK);
    }
    @GetMapping("/departments/count")
    public ResponseEntity<List<String>> countEmployees() {
        return new ResponseEntity<>(service.countEmployees(), HttpStatus.OK);
    }
}