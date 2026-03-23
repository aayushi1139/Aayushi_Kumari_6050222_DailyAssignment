package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.*;
import com.cg.entity.*;
import com.cg.exception.*;
import com.cg.repo.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private DepartmentRepository deptRepo;

    public Employee addEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return empRepo.getAllEmployees();
    }

    public List<Employee> getByDepartment(String name) {
        List<Employee> list = empRepo.getByDepartment(name);

        if (list.isEmpty()) {
            throw new DepartmentNameNotFoundException("Department not found: " + name);
        }

        return list;
    }

    public List<DepartmentEmployeeCountDTO> countEmployees() {
        return deptRepo.countEmployees();
    }

    public EmployeeDeptDTO getByMobile(String mobile) {

        EmployeeDeptDTO dto = empRepo.getByMobile(mobile);

        if (dto == null) {
            throw new MobileNumberDoesNotExistsForEmployeeException("Mobile not found: " + mobile);
        }

        return dto;
    }
}