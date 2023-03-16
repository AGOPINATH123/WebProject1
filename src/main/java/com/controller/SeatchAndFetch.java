package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gopi.bean.Employee;
import com.gopi.jdbc.DbOperation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SeatchAndFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;      
   
    public SeatchAndFetch() {
        super();
    }  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("form submitted to get from search");
		String id=request.getParameter("employeeId");
		int id1=Integer.parseInt(id);
		Employee emp=new Employee();		
		emp.setId(id1);
		System.out.println("the value is "+id1);
		DbOperation db=new DbOperation();
		Employee result =db.Searchdata(id1);		
		HttpSession session = request.getSession();
		session.setAttribute("empObject12", result);	
		RequestDispatcher rd=request.getRequestDispatcher("/EmplyeeData1");
		RequestDispatcher rd1=request.getRequestDispatcher("Fail.html");

		if(result!=null) {
			rd.forward(request, response);
		}
		else {
			rd1.forward(request, response);
		}	
	}
		
	
	
}
