package com.gopi.bean;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.gopi.jdbc.MySqlConnection;
class InputMismatch extends Exception{
	private static final long serialVersionUID = 1L;
	public InputMismatch(String str) {System.out.println(str);}
}
public class MethodStatement {	
	static int in1;   static String sn1;	static double db1;
	static Scanner sc = new Scanner(System.in);
	static Employee emp = new Employee();
	static String query=" ";	
	Connection connection;
	Statement statement;
	
	public MethodStatement() {connection = MySqlConnection.getInstance();}	

	public int insertDataWithStatement() throws SQLException {
		System.out.println("enter id");	emp.setId(sc.nextInt());
		System.out.println("enter name ");emp.setName(sc.next());
		System.out.println("enter salary");emp.setSalary(sc.nextDouble());
		int result = 0;
		String query = "INSERT INTO EMPLOYEE VALUES('" + emp.getId() + "','" + emp.getName() + "','" + emp.getSalary()+ "')";		
		statement = connection.createStatement();
		result = statement.executeUpdate(query);
		System.out.println(result+"\n");
		return result;
	}
	
	public int DeleteDataWIthStatement() throws SQLException {
		int result = 0;
		String [] ars ={"DELETE FROM EMPLOYEE WHERE EMPID =","DELETE FROM EMPLOYEE WHERE EMPNAME=","DELETE FROM EMPLOYEE WHERE EMPSALARY ="};
		System.out.println("1.Delete with Id  2.Delete with Name   3.Delete with Salary");	
		int num=sc.nextInt();
		System.out.println(ars[num-1]);
		if(num==1) {emp.setId(sc.nextInt());query=ars[num-1]+emp.getId();}
		else if (num==2) {emp.setName(sc.next());query=ars[num-1]+emp.getName();}
		else if (num==3) {emp.setSalary(sc.nextDouble());query=ars[num-1]+emp.getSalary();}	
	
			statement = connection.createStatement();
			result = statement.executeUpdate(query);
			System.out.println(result+"\n");

		return result;
		}
	
	public int UpdateDataWithStatement() throws SQLException {
		int result=0;
		System.out.println("which one you want to update\n1. id  2.name  3.salary");
		int num=sc.nextInt();
		if(num==1){	System.out.println("set emp id");emp.setId(sc.nextInt());}
		else if(num==2) {System.out.println("set emp name");emp.setName(sc.next());	}
		else if(num==3) {System.out.println("set emp salary");emp.setSalary(sc.nextDouble());}
		
		System.out.println("where the option is\n1. id  2.name  3.salary");
		
		int sum=sc.nextInt();
		if(sum==1) {System.out.println("where id =");in1=sc.nextInt();}
		else if(sum==2) {System.out.println("where name =");sn1=sc.next();}
		else if(sum==3) {System.out.println("where salary =");db1=sc.nextDouble();}	
		
		Object []dd=  {emp.getId(),emp.getName(),emp.getSalary()};
		String []srr1={"UPDATE EMPLOYEE SET EMPID = ","UPDATE EMPLOYEE SET EMPNAME ='","UPDATE EMPLOYEE SET EMPSALARY = "};
		String []sr2= {" WHERE EMPID ="," WHERE EMPNAME ='"," WHERE EMPSALARY="};
	    Object []sd1= {in1,sn1,db1};	

     	if(num<=srr1.length && sum<=sr2.length ) {			
		query=srr1[num-1]+dd[num-1]+sr2[sum-1]+sd1[sum-1];
		if(num==2 && sum==2) {
			query=srr1[num-1]+dd[num-1]+"'"+sr2[sum-1]+sd1[sum-1]+"'";
		}}					
			statement = connection.createStatement();
			result = statement.executeUpdate(query);			
		System.out.println(result +" rows effected");
		return result;		
	}	
	public static void main(String[] args) throws SQLException, InputMismatch {		
		MethodStatement bh = new MethodStatement();
		try {
		for(; ;) {System.out.println("1.InsertData   2. DeleteData   3.UpdateData" );
		int ch=sc.nextInt();
		if(ch==1)bh.insertDataWithStatement();
		else if(ch==2)bh.DeleteDataWIthStatement();
		else if(ch==3)bh.UpdateDataWithStatement();
		else throw new InputMismatch("The Enteredvalue Does't Exists");
		}}catch(Exception str) {System.out.println(str);};
	}}
