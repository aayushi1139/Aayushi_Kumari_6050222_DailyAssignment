package com.cg.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double salary;
    @ElementCollection
    private Set<String> mobileNumbers;
    @ManyToOne
    @JoinColumn(name = "dept_id")
    @JsonBackReference 
    private Department department;

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public Set<String> getMobileNumbers() { return mobileNumbers; }
    public Department getDepartment() { return department; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setMobileNumbers(Set<String> mobileNumbers) { this.mobileNumbers = mobileNumbers; }
    public void setDepartment(Department department) { this.department = department; }
}