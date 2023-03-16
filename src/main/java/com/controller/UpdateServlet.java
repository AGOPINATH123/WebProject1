package com.controller;
import java.io.IOException;

import com.gopi.bean.Employee;
import com.gopi.jdbc.DbOperation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public UpdateServlet() {
		super();
	}
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
	System.out.println("data hits Get for the update");
	String empid=request.getParameter("employeeId");	
	int empid1=Integer.parseInt(empid);
	String empname=request.getParameter("employeeName");	
	Employee emp=new Employee();
	emp.setId(empid1);
	emp.setName(empname);
	DbOperation db=new DbOperation();
	int result = db.UpdateDataWithStatement(emp);
	RequestDispatcher re=request.getRequestDispatcher("Success.html");
	RequestDispatcher failure = request.getRequestDispatcher("Fail.html");		

	if(result>0) {		
		re.forward(request, response);	
		}
	else {
		failure.forward(request, response);
	}
	}
}
