package cg.demo.associationmapping;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import cg.demo.associationmapping.Department1;
import cg.demo.associationmapping.Employee1;

public class Employee1DAO_JPQL {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
    EntityManager em = emf.createEntityManager();

    // 1Insert Employee
    public void insertEmployee(Employee1 e, int deptId) {

        em.getTransaction().begin();

        Department1 d = em.find(Department1.class, deptId);

        if(d == null)
        {
            System.out.println("Department not found");
        }
        else
        {
            e.setDepartment(d);
            em.persist(e);
            System.out.println("Employee inserted successfully");
        }

        em.getTransaction().commit();
    }


    // 2️Fetch all employees with department and manager
    public void fetchEmployees() {

        String jpql =
        "SELECT e.name, e.salary, d.name, d.managerName FROM Employee1 e JOIN e.department d";

        List<Object[]> list = em.createQuery(jpql).getResultList();

        for(Object[] obj : list)
        {
            System.out.println(
            "Employee Name: " + obj[0] +
            " Salary: " + obj[1] +
            " Department: " + obj[2] +
            " Manager: " + obj[3]);
        }
    }


    // 3️Count employees in each department
    public void countEmployeesPerDept() {

        String jpql =
        "SELECT d.name, COUNT(e) FROM Department1 d LEFT JOIN d.employees e GROUP BY d.name";

        List<Object[]> list = em.createQuery(jpql).getResultList();

        for(Object[] obj : list)
        {
            System.out.println(
            "Department: " + obj[0] +
            " Total Employees: " + obj[1]);
        }
    }


    // 4Fetch employees working under given department name
    public void employeesByDept(String deptName) {

        String jpql =
        "SELECT e FROM Employee1 e WHERE e.department.name = :dname";

        List<Employee1> list =
        em.createQuery(jpql, Employee1.class)
          .setParameter("dname", deptName)
          .getResultList();

        for(Employee1 e : list)
        {
            System.out.println(
            "Employee Id: " + e.getId() +
            " Name: " + e.getName() +
            " Salary: " + e.getSalary());
        }
    }


    // 5️Fetch department details using employee mobile
    public void deptDetailsByMobile(String mobile) {

        String jpql =
        "SELECT e.id, e.name, d.name, d.managerName FROM Employee1 e JOIN e.department d WHERE e.mobile = :mob";

        List<Object[]> list =
        em.createQuery(jpql)
          .setParameter("mob", mobile)
          .getResultList();

        for(Object[] obj : list)
        {
            System.out.println(
            "Employee Id: " + obj[0] +
            " Name: " + obj[1] +
            " Department: " + obj[2] +
            " Manager: " + obj[3]);
        }
    }

}
