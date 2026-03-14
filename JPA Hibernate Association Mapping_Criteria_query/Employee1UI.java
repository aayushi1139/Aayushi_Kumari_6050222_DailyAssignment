package cg.demo.associationmapping;

import java.util.*;

public class Employee1UI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee1DAO_CQ dao = new Employee1DAO_CQ();

        while(true)
        {

            System.out.println("\n---- MENU ----");
            System.out.println("1 Insert Employee");
            System.out.println("2 Fetch Employees with Department");
            System.out.println("3 Count Employees per Department");
            System.out.println("4 Employees by Department Name");
            System.out.println("5 Department details by Mobile");

            int ch = sc.nextInt();

            switch(ch)
            {

                case 1:

                    Employee1 e = new Employee1();

                    System.out.println("Enter name");
                    e.setName(sc.next());

                    System.out.println("Enter salary");
                    e.setSalary(sc.nextDouble());

                    System.out.println("How many mobiles?");
                    int n = sc.nextInt();

                    Set<String> mobiles = new HashSet<>();

                    for(int i=0;i<n;i++)
                    {
                        System.out.println("Enter mobile:");
                        mobiles.add(sc.next());
                    }

                    e.setMobiles(mobiles);

                    System.out.println("Enter Department Id");
                    int deptId = sc.nextInt();

                    dao.insertEmployee(e, deptId);
                    break;


                case 2:
                    dao.fetchEmployees();
                    break;

                case 3:
                    dao.countEmployeesPerDept();
                    break;

                case 4:
                    System.out.println("Enter Department Name");
                    dao.employeesByDept(sc.next());
                    break;

                case 5:
                    System.out.println("Enter Mobile");
                    dao.deptDetailsByMobile(sc.next());
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}