package cg.demo.springcoreday1.exp2;

public class Employee {

    private int employeeId;
    private String employeeName;
    private double salary;
    private int empAge;

    private SBU businessUnit;

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public SBU getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(SBU businessUnit) {
        this.businessUnit = businessUnit;
    }

    public SBU getSbuDetails() {
        return businessUnit;
    }

    @Override
    public String toString() {

        return "Employee [empAge=" + empAge +
                ", emp_id=" + employeeId +
                ", empName=" + employeeName +
                ", empSalary=" + salary + "]";
    }
}