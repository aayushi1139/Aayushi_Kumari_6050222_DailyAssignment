package com.demo.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
public class Employee_UI{
	static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "aayushi");
            int choice;
            do {
                System.out.println("1. Insert Employee");
                System.out.println("2. View Employees Table");
                System.out.println("3. View Employees Table with id");
                System.out.println("4. Update Salary");
                System.out.println("5. Delete Employee");
                System.out.println("6. Create Table");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                ArrayList<Employee> rs=new ArrayList<>();
                switch (choice) {
                    case 1:
                    	Employee emp = new Employee();

                        System.out.print("Enter ID: ");
                        emp.setId(sc.nextInt());

                        System.out.print("Enter Name: ");
                        emp.setName(sc.next());

                        System.out.print("Enter Salary: ");
                        emp.setSalary(sc.nextInt());

                        System.out.print("Enter Department: ");
                        emp.setDepartment(sc.next());

                        System.out.print("Enter Phone: ");
                        emp.setPhoneNo(sc.next());
                        Commands.insertEmployee(conn,emp);
                        break;

                    case 2:
                        rs=Commands.viewEmployees(conn);
                        break;
                    case 3:
                    	System.out.println("Enter the id");
                    	int id=sc.nextInt();
                        rs=Commands.viewEmployeesWithId(conn,id);
                        break;

                    case 4:
                    	System.out.println("Enter the id");
                    	int id1=sc.nextInt();
                    	System.out.println("Enter the Salary");
                    	int sal=sc.nextInt();
                        rs=Commands.updateEmployee(conn,id1,sal);
                        break;

                    case 5:
                    	System.out.println("Enter the id");
                    	int id2=sc.nextInt();
                        rs=Commands.deleteEmployee(conn,id2);
                        break;

                    case 6:
                        System.out.println("Enter new Table name");
                        String s=sc.next();
                        boolean flag=Commands.CreateTable(conn, s);
                        if(flag==true)
                        {
                        	System.err.println("Not Created");
                        }
                        else
                        {
                        	System.out.println("Created successfully");
                        }
                        break;
                    case 7:
                        System.out.println("Terminate");
                        break;

                    default:
                        System.out.println("Invalid Choice");

                }
                System.out.println("\nID Name Salary Department Phone");

                for(int i=0;i<rs.size();i++)
                {
                	Employee rs1=rs.get(i);
                	System.out.println(rs1.getId() + " " + rs1.getName() + " " + rs1.getSalary() + " " + rs1.getDepartment() + " " + rs1.getPhoneNo());
                }

            } while (choice != 7);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}