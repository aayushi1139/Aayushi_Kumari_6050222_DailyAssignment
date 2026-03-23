package com.cg.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String managerName;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonManagedReference 
    private List<Employee> employees;
    public int getId() { return id; }
    public String getName() { return name; }
    public String getManagerName() { return managerName; }
    public List<Employee> getEmployees() { return employees; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}