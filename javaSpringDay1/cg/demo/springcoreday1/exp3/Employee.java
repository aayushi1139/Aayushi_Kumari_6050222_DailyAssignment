package cg.demo.springcoreday1.exp3;
public class Employee {

    private int employeeId;
    private String employeeName;
    private double salary;
    private int empAge;

    public Employee() {}

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

    @Override
    public String toString() {
        return "Employee [empAge=" + empAge +
               ", empId=" + employeeId +
               ", empName=" + employeeName +
               ", empSalary=" + salary + "]";
    }
}
