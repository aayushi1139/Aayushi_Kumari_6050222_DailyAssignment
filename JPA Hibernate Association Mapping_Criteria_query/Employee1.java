package cg.demo.associationmapping;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Employee1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double salary;

    @ElementCollection
    @CollectionTable(
        name = "employee_mobiles",
        joinColumns = @JoinColumn(name = "emp_id")
    )
    @Column(name = "mobile")
    private Set<String> mobiles;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department1 department;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Set<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(Set<String> mobiles) {
        this.mobiles = mobiles;
    }

    public Department1 getDepartment() {
        return department;
    }

    public void setDepartment(Department1 department) {
        this.department = department;
    }
}