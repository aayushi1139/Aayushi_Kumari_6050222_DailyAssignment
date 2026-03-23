package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import com.cg.dto.DepartmentEmployeeCountDTO;
import com.cg.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT new com.cg.dto.DepartmentEmployeeCountDTO(d.name, COUNT(e)) " +
           "FROM Department d LEFT JOIN d.employees e GROUP BY d.name")
    List<DepartmentEmployeeCountDTO> countEmployees();
}