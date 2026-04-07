package com.cg.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.demo.entities.Emp;
import com.cg.demo.repo.EmpRepository;
@Service
public class EmpService {

    @Autowired
    private EmpRepository repo;

    public List<Emp> getAll() {
        return repo.findAll(Sort.by("empId"));
    }

    public Emp getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Emp emp) {
        repo.save(emp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}