package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByName(String name);
}