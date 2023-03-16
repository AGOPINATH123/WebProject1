package com.controller; 
import java.io.IOException;
import com.gopi.bean.Employee;
import com.gopi.jdbc.DbOperation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegistrationServlet extends HttpServlet{	
	private static final long serialVersionUID = 1L;
	public RegistrationServlet() {
		super();
	}	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{	
		
		System.out.println("Form submitted on Getregistration servlet");
		String empid = request.getParameter("employeeId");		
		int empid1=Integer.parseInt(empid);		
		String empname = request.getParameter("employeeName");
		String empsalary = request.getParameter("employeeSalary");		
		String empmobileno=request.getParameter("employeeMobileno");
		double empsalary1=Double.parseDouble(empsalary);		
		Employee emp = new Employee();
		emp.setId(empid1);
		emp.setName(empname);
		emp.setSalary(empsalary1);
		emp.setMobileno(empmobileno);		
		DbOperation db = new DbOperation();
		int result=db.insertDataWithStatement(emp);		
		HttpSession session=request.getSession();
		session.setAttribute("empObject12", emp);
		
		RequestDispatcher RD=request.getRequestDispatcher("/EmplyeeData1");
		RequestDispatcher failure = request.getRequestDispatcher("Fail.html");		
		
		if(result>0) {
			RD.forward(request, response);			
		}
		else {
			failure.forward(request, response);
		}		
	}	
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{		
		
		System.out.println("Form submitted on Postregistration servlet");
		String empid = request.getParameter("employeeId");		
		int empid1=Integer.parseInt(empid);				
		Employee emp = new Employee();
		emp.setId(empid1);			
		DbOperation db = new DbOperation();
		int result=db.DeleteDataWIthStatement(emp);		
		RequestDispatcher RD1=request.getRequestDispatcher("Success.html");
		RequestDispatcher failure = request.getRequestDispatcher("Fail.html");		

		if(result>0) {
			RD1.forward(request, response);
		}
		else {
			failure.forward(request, response);
		}
		
	}

}
