package com.gopi.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.gopi.bean.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EmployeeData extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EmployeeData() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {   		
		
	   response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("empObject");
		PrintWriter out=response.getWriter();

		if(obj!=null) {
			List<Employee> li=(ArrayList<Employee>)obj;
			out.print("<html><body><table>");
			out.print("<tr><th >employeeid</th><th>employeename</th><th>employeesalry</th><th>employeemobilno</th></tr>");
			for (Employee emp : li) {
				out.print("<tr><td>"+emp.getId()+"</td>");
				out.print("<td>"+emp.getName()+"</td>");
				out.print("<td>"+emp.getSalary()+"</td>");
				out.print("<td>"+emp.getMobileno()+"</td></tr>");				
			}		
			
		}}

	

}
