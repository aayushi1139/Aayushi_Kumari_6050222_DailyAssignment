package com.cg.dto;

public class DepartmentEmployeeCountDTO {

    private String deptName;
    private Long empCount;

    public DepartmentEmployeeCountDTO(String deptName, Long empCount) {
        this.deptName = deptName;
        this.empCount = empCount;
    }

    public String getDeptName() { return deptName; }
    public Long getEmpCount() { return empCount; }
}