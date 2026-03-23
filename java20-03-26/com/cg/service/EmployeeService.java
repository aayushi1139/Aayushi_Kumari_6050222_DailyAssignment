package com.cg.service;

import java.util.*;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.*;
import com.cg.exception.ResourceNotFoundException;

@Service
@Transactional
public class EmployeeService {

    @PersistenceContext
    private EntityManager em;

    public void addDepartment(Department dept) {
        em.persist(dept);
    }
    public void addEmployee(Employee emp) {

        if (emp.getDepartment() != null) {
            int deptId = emp.getDepartment().getId();

            Department dept = em.find(Department.class, deptId);

            if (dept == null) {
                throw new ResourceNotFoundException("Department not found with id: " + deptId);
            }

            emp.setDepartment(dept);
        }

        em.persist(emp);
    }
    public List<Employee> getAllEmployees() {

        List<Employee> list = em.createQuery("SELECT e FROM Employee e", Employee.class)
                                .getResultList();

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No employees found");
        }

        return list;
    }

    public List<Employee> getByDepartment(String name) {

        List<Employee> list = em.createQuery(
                "SELECT e FROM Employee e WHERE e.department.name = :name",
                Employee.class)
                .setParameter("name", name)
                .getResultList();

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No employees found in department: " + name);
        }

        return list;
    }

    public List<String> countEmployees() {

        List<Object[]> data = em.createQuery(
                "SELECT d.name, COUNT(e) FROM Department d LEFT JOIN d.employees e GROUP BY d.name")
                .getResultList();

        if (data.isEmpty()) {
            throw new ResourceNotFoundException("No departments found");
        }

        List<String> result = new ArrayList<>();

        for (Object[] row : data) {
            result.add(row[0] + " : " + row[1]);
        }

        return result;
    }
}