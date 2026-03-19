package com.example.springbootassignment1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootassignment1.entities.Trainee;
@Repository
public interface TraineJpaRepository extends JpaRepository<Trainee, Integer>{

}
