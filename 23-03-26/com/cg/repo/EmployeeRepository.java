package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Employee;
import com.cg.dto.EmployeeDeptDTO;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT DISTINCT e FROM Employee e JOIN FETCH e.department")
    List<Employee> getAllEmployees();

    @Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE d.name = :name")
    List<Employee> getByDepartment(@Param("name") String name);

    @Query("SELECT new com.cg.dto.EmployeeDeptDTO(e.id, e.name, d.name, d.managerName) " +
           "FROM Employee e JOIN e.department d JOIN e.mobileNumbers m WHERE m = :mobile")
    EmployeeDeptDTO getByMobile(@Param("mobile") String mobile);
}