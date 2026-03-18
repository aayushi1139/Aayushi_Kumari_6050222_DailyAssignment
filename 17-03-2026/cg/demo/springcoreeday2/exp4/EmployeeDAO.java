package cg.demo.springcoreeday2.exp4;
import java.util.List;

public interface EmployeeDAO {

    Employee addEmployee(Employee emp);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee emp);
    boolean deleteEmployee(int id);
}