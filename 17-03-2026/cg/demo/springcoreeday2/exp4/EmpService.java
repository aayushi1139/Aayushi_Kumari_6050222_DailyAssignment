package cg.demo.springcoreeday2.exp4;
import java.util.List;

public interface EmpService {

    Employee createEmployee(Employee emp);
    Employee fetchEmployee(int id);
    List<Employee> fetchAll();
    Employee modifyEmployee(Employee emp);
    boolean removeEmployee(int id);
}