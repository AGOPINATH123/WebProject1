package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.gopi.bean.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class EmplyeeData1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EmplyeeData1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		   response.setContentType("text/html");
		HttpSession session = request.getSession();
	    Object obj1=session.getAttribute("empObject12");
		PrintWriter out=response.getWriter();

		Employee emp1 = null;
		if (obj1 != null) {
			emp1 = (Employee) obj1;
		}
		out.print("<html><body><table>");
		out.print("<tr><th>employeeid</th><th>employeename</th><th>employeesalry</th><th>employeemobilno</th></tr>");
		out.print("<tr><td>"+emp1.getId() + "</td>");
		out.print("<td>" + emp1.getName() + "</td>");
		out.print("<td>" + emp1.getSalary() + "</td>");
		out.print("<td>" + emp1.getMobileno() + "</td></tr>");
		out.print("<tr><td><button><a href='index.html'>Return</a></td></tr>");
		out.print("</table></body></html>");

			
	
	
	
	}

	

}
