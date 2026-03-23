package com.cg.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Employee name must not be empty")
    private String name;

    @Positive(message = "Salary must be greater than 0")
    private double salary;

    @ElementCollection
    @NotEmpty(message = "Mobile numbers must not be empty")
    private Set<
        @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
        String> mobileNumbers;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    @NotNull(message = "Department must not be null")
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