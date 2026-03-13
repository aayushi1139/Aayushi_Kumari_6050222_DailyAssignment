package com.demo.jdbc;
import java.sql.*;
import java.util.Scanner;
public class jdbc_crud {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/employee";
            String username = "postgres";
            String password = "aayushi";
            Connection con = DriverManager.getConnection(url, username, password);
            Employee emp = new Employee();
            int choice = 0;
            while (choice != 5) {
				System.out.println("\n====== EMPLOYEE MANAGEMENT SYSTEM ======");
				System.out.println("1. Insert Employee");
				System.out.println("2. View Employees");
				System.out.println("3. Update Salary");
				System.out.println("4. Delete Employee");
				System.out.println("5. Exit");
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				// INSERT
				case 1:
					System.out.println("Enter Name:");
					emp.setName(sc.nextLine());
					System.out.println("Enter Salary:");
					emp.setSalary(sc.nextDouble());
					sc.nextLine();
					System.out.println("Enter Department:");
					emp.setDepartment(sc.nextLine());
					System.out.println("Enter Phone Number:");
					emp.setPhoneno(sc.nextLine());
					PreparedStatement insert = con.prepareStatement(
							"INSERT INTO Employee(name,salary,department,phoneno) VALUES(?,?,?,?)");
					insert.setString(1, emp.getName());
					insert.setDouble(2, emp.getSalary());
					insert.setString(3, emp.getDepartment());
					insert.setString(4, emp.getPhoneno());
					insert.executeUpdate();
					System.out.println("Employee Inserted Successfully");
					insert.close();

					break;

				// READ
				case 2:

					PreparedStatement read = con.prepareStatement("SELECT * FROM Employee");
					ResultSet rs = read.executeQuery();

					System.out.println("\nID\t\\tName\t\\tSalary\t\\tDepartment\t\\tPhone");

					while (rs.next()) {

						System.out.println(
								rs.getInt("id") + "\t\\t" +
								rs.getString("name") + "\t\\t" +
								rs.getDouble("salary") + "\t\\t" +
								rs.getString("department") + "\t\\t" +
								rs.getString("phoneno"));
					}

					rs.close();
					read.close();

					break;

				// UPDATE
				case 3:

					System.out.println("Enter Employee ID:");
					emp.setId(sc.nextInt());

					System.out.println("Enter New Salary:");
					emp.setSalary(sc.nextDouble());

					PreparedStatement update = con.prepareStatement(
							"UPDATE Employee SET salary=? WHERE id=?");

					update.setDouble(1, emp.getSalary());
					update.setInt(2, emp.getId());

					int updated = update.executeUpdate();

					if (updated > 0)
						System.out.println("Salary Updated Successfully");
					else
						System.out.println("Employee Not Found");

					update.close();

					break;

				// DELETE
				case 4:

					System.out.println("Enter Employee ID to Delete:");
					emp.setId(sc.nextInt());

					PreparedStatement delete = con.prepareStatement(
							"DELETE FROM Employee WHERE id=?");

					delete.setInt(1, emp.getId());

					int deleted = delete.executeUpdate();

					if (deleted > 0)
						System.out.println("Employee Deleted Successfully");
					else
						System.out.println("Employee Not Found");

					delete.close();

					break;

				case 5:
					System.out.println("Exiting Program...");
					break;

				default:
					System.out.println("Invalid Choice");
				}

			}

			con.close();
			sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}