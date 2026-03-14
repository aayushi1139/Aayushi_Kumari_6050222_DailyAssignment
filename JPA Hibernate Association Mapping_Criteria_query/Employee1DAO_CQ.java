
package cg.demo.associationmapping;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public class Employee1DAO_CQ {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
    EntityManager em = emf.createEntityManager();

    // 1️⃣ Insert Employee
    public void insertEmployee(Employee1 e, int deptId) {

        em.getTransaction().begin();

        Department1 d = em.find(Department1.class, deptId);

        if (d == null) {
            System.out.println("Department not found");
        } else {
            e.setDepartment(d);
            em.persist(e);
            System.out.println("Employee inserted successfully");
        }

        em.getTransaction().commit();
    }

    // 2️⃣ Fetch all employees with department and manager
    public void fetchEmployees() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Employee1> root = cq.from(Employee1.class);
        Join<Employee1, Department1> dept = root.join("department");

        cq.multiselect(
                root.get("name"),
                root.get("salary"),
                dept.get("name"),
                dept.get("managerName")
        );

        List<Object[]> list = em.createQuery(cq).getResultList();

        for (Object[] obj : list) {
            System.out.println(
                    "Employee Name: " + obj[0] +
                    " Salary: " + obj[1] +
                    " Department: " + obj[2] +
                    " Manager: " + obj[3]);
        }
    }

    // 3️⃣ Count employees in each department
    public void countEmployeesPerDept() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Department1> root = cq.from(Department1.class);
        Join<Department1, Employee1> emp = root.join("employees", JoinType.LEFT);

        cq.multiselect(
                root.get("name"),
                cb.count(emp)
        );

        cq.groupBy(root.get("name"));

        List<Object[]> list = em.createQuery(cq).getResultList();

        for (Object[] obj : list) {
            System.out.println(
                    "Department: " + obj[0] +
                    " Total Employees: " + obj[1]);
        }
    }

    // 4️⃣ Fetch employees by department name
    public void employeesByDept(String deptName) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee1> cq = cb.createQuery(Employee1.class);

        Root<Employee1> root = cq.from(Employee1.class);

        cq.select(root)
          .where(cb.equal(root.get("department").get("name"), deptName));

        List<Employee1> list = em.createQuery(cq).getResultList();

        for (Employee1 e : list) {
            System.out.println(
                    "Employee Id: " + e.getId() +
                    " Name: " + e.getName() +
                    " Salary: " + e.getSalary());
        }
    }

    // 5️⃣ Fetch department details using employee mobile
    public void deptDetailsByMobile(String mobile) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Employee1> root = cq.from(Employee1.class);
        Join<Employee1, Department1> dept = root.join("department");

        cq.multiselect(
                root.get("id"),
                root.get("name"),
                dept.get("name"),
                dept.get("managerName")
        );

        cq.where(cb.equal(root.get("mobile"), mobile));

        List<Object[]> list = em.createQuery(cq).getResultList();

        for (Object[] obj : list) {
            System.out.println(
                    "Employee Id: " + obj[0] +
                    " Name: " + obj[1] +
                    " Department: " + obj[2] +
                    " Manager: " + obj[3]);
        }
    }
}