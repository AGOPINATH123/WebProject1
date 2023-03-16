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

public class FetchServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public FetchServlet() {
		super();
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{		
		
	System.out.println("form submitted to get from fetch Button");
	List<Employee> li=new ArrayList<Employee>();
	DbOperation db=new DbOperation();
	li.addAll(db.FetchData());
	System.out.println(li);
	HttpSession session=request.getSession();
	session.setAttribute("empObject",li);
	RequestDispatcher rd=request.getRequestDispatcher("/EmployeeData");
	RequestDispatcher rd1=request.getRequestDispatcher("Fail.html");

	if(li!=null) {
		rd.forward(request, response);
	}
	else {
		rd1.forward(request, response);
	}	
	}
		
	}	

	





