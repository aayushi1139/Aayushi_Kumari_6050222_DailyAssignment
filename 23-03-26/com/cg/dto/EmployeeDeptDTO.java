package com.cg.dto;

public class EmployeeDeptDTO {

    private int empId;
    private String empName;
    private String deptName;
    private String managerName;

    public EmployeeDeptDTO(int empId, String empName, String deptName, String managerName) {
        this.empId = empId;
        this.empName = empName;
        this.deptName = deptName;
        this.managerName=managerName;
    }
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public String getManagerName() {
		return managerName;
	}

}