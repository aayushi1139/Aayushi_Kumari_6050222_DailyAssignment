package cg.demo.springcoreeday2.exp4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private Map<Integer, Employee> empMap = new HashMap<>();

    @Override
    public Employee addEmployee(Employee emp) {
        empMap.put(emp.getId(), emp);
        return emp;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return empMap.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(empMap.values());
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        if (empMap.containsKey(emp.getId())) {
            empMap.put(emp.getId(), emp);
            return emp;
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return empMap.remove(id) != null;
    }
}