package com.demo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Scanner;

public class Commands {
	
	public static void insertEmployee(Connection conn,Employee emp) throws SQLException {
		Scanner sc=new Scanner(System.in);
            String sql = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setInt(3, emp.getSalary());
            ps.setString(4, emp.getDepartment());
            ps.setString(5, emp.getPhoneNo());

            int rows = ps.executeUpdate();

            System.out.println("Employee Inserted: " + rows);

        
    }
	public static boolean CreateTable(Connection conn,String s) {
		

        try {

            

            String sql = "Create TABLE "+s+" (id numeric(10),name varchar(100),salary NUMERIC(10,2),department VARCHAR(50),phoneno VARCHAR(15))";

            PreparedStatement ps = conn.prepareStatement(sql);

            
            boolean flag = ps.execute();
            return flag;
            

           

        } catch (Exception e) {
            System.err.println("Already Exist");
        }
		return true;
    }
	
	public static ArrayList<Employee> viewEmployees(Connection conn) throws SQLException {

        

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            ArrayList<Employee> result=new ArrayList<>();
            while (rs.next()) {
            	Employee obj=new Employee();
               obj.setId(rs.getInt("id")) ;
               obj.setName(rs.getString("name")) ;
               obj.setSalary(rs.getInt("salary")) ;
               obj.setDepartment(rs.getString("department")) ;
               obj.setPhoneNo(rs.getString("phoneno"));
               result.add(obj);
            }
            
            return result;
    }
	
	public static ArrayList<Employee> viewEmployeesWithId(Connection conn,int id) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee where id="+id);
        ArrayList<Employee> result=new ArrayList<>();
        while (rs.next()) {
        	Employee obj=new Employee();
           obj.setId(rs.getInt("id")) ;
           obj.setName(rs.getString("name")) ;
           obj.setSalary(rs.getInt("salary")) ;
           obj.setDepartment(rs.getString("department")) ;
           obj.setPhoneNo(rs.getString("phoneno"));
           result.add(obj);
        }

        return result; 
}
	public static ArrayList<Employee> updateEmployee(Connection conn,int id, int salary) throws SQLException {

        

            String sql = "UPDATE Employee SET salary = ? WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            System.out.println("Rows Updated: " + rows);

        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee where id="+id);
        ArrayList<Employee> result=new ArrayList<>();
        while (rs.next()) {
        	Employee obj=new Employee();
           obj.setId(rs.getInt("id")) ;
           obj.setName(rs.getString("name")) ;
           obj.setSalary(rs.getInt("salary")) ;
           obj.setDepartment(rs.getString("department")) ;
           obj.setPhoneNo(rs.getString("phoneno"));
           result.add(obj);
        }

        return result;
        
    }
	
	public static ArrayList<Employee> deleteEmployee(Connection conn, int id) throws SQLException {
		Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee where id="+id);

        

        
            String sql = "DELETE FROM Employee WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            System.out.println("Rows Deleted: " + rows);

        
        ArrayList<Employee> result=new ArrayList<>();
        while (rs.next()) {
        	Employee obj=new Employee();
           obj.setId(rs.getInt("id")) ;
           obj.setName(rs.getString("name")) ;
           obj.setSalary(rs.getInt("salary")) ;
           obj.setDepartment(rs.getString("department")) ;
           obj.setPhoneNo(rs.getString("phoneno"));
           result.add(obj);
        }
        return result;
    }


}