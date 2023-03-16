package com.gopi.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gopi.bean.Employee;

public class DbOperation {
	Connection connection;
	PreparedStatement statement;
	ResultSet rs;
	
	public DbOperation() {
		connection = MySqlConnection.getInstance();
	}
	
	public int insertDataWithStatement(Employee emp) {
		int result = 0;
		
		String query = "INSERT INTO EMPLOYEE VALUES(?,?,?,?)";
		
		try {
			statement = connection.prepareStatement(query);
			
			statement.setInt(1, emp.getId());
			statement.setString(2, emp.getName());
			statement.setDouble(3, emp.getSalary());
			statement.setString(4, emp.getMobileno());
			
			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		System.out.println(result+" rows effected");
		return result;
		
	}
	public int DeleteDataWIthStatement(Employee emp) {
		int result=0;

		String query = "DELETE FROM EMPLOYEE WHERE EMPID =?";	
		try {
			statement=connection.prepareStatement(query);
			statement.setInt(1, emp.getId());			
			result=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result+" rows effected");
		return result;
	}
	
	public int UpdateDataWithStatement(Employee emp) {
		
		int result =0;
		String query="UPDATE EMPLOYEE SET empname =? where Empid =?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, emp.getName());
			statement.setInt(2, emp.getId());			
			result=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}System.out.println(result+" rows effected");
		return result;
	}
	public Employee Searchdata(int id) {
		Employee result=null;
		String query="SELECT * FROM EMPLOYEE WHERE EMPID=?";
		try {
		statement =connection.prepareStatement(query);		
		statement.setInt(1,id);
		rs=statement.executeQuery();
		while(rs.next()) {
			result=new Employee();
			result.setId(rs.getInt(1));
			result.setName(rs.getString(2));
			result.setSalary(rs.getDouble(3));
			result.setMobileno(rs.getString(4));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public List<Employee> FetchData() {
		List<Employee>li=new ArrayList<Employee>();
		String qurey="SELECT * FROM EMPLOYEE";
		try {
			statement =connection.prepareStatement(qurey);
		
		rs=statement.executeQuery();
		Employee emp=null;
		while(rs.next()) {
			emp=new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getDouble(3));
			emp.setMobileno(rs.getString(4));
			li.add(emp);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		
		return li;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		DbOperation db = new DbOperation();
		for (;;) {
			System.out.println("Please select your choice \n"+
		"1.Insert Employee data\n"+"2.Delete employee data\n"+"3.Update employee\n4.Fetch");
			int s=sc.nextInt();
			Employee emp = new Employee();
			switch(s) {
			case 1:
				System.out.println("enter employee id");
				emp.setId(sc.nextInt());
				System.out.println("enter employee name");
				emp.setName(sc.next());
				System.out.println("enter employee salary");
				emp.setSalary(sc.nextDouble());
				System.out.println("enter mobile number ");
				emp.setMobileno(sc.next());
				
				
				int result = db.insertDataWithStatement(emp);
				if(result>0) {
					System.out.println("data inserted");
				} else {
					System.out.println("please try again");
				} break;
			case 2:
				System.out.println("enter employee data to be deleted");
				System.out.println("enter id no");
				emp.setId(sc.nextInt());
				int result1 = db.DeleteDataWIthStatement(emp);
				if(result1>0) {
					System.out.println("deleted successfully");
				} else {	
					System.out.println("unsuccessfull");
				}break;
			case 3:
				System.out.println("enter the data  to be updated ");
				System.out.println("set name ");
				emp.setName(sc.next());
				System.out.println("enter id to updated");
				emp.setId(sc.nextInt());
				int result2=db.UpdateDataWithStatement(emp);
				if(result2>0) {System.out.println("data is updated");}
				else {System.out.println("try again");}
				break;
			case 4:
				System.out.println("here the details");
				List<Employee>li=db.FetchData();
				for (Employee employee : li) {
					System.out.println(employee.getId()+"\t "+employee.getName()+"\t "+employee.getSalary()+" \t"+employee.getMobileno());
					
				}
				
				
			}
			
		}
		
	}


}