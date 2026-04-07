package com.cg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.demo.entities.Emp;


public interface EmpRepository extends JpaRepository<Emp, Integer> {
}