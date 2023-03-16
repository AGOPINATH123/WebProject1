<%@page import="com.gopi.bean.Employee "%> 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;"
	%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Data</title>
</head>
<body>
	<h2 align="center">Employee Data</h2>
	<table align="center">
		<%
			Object sessionObj = session.getAttribute("EmployeeObject");
			if (sessionObj == null) {
				out.print("No data Found in Database");
			} else {
				List<Employee> employeelist =(ArrayList<Employee>)sessionObj;
		%>

		<tr>
			<th>employeeId</th>
			<th>employeeName</th>
			<th>employeeSalary</th>
			<th>employeeMobileno</th>
		</tr>
		<%
			for (Employee employee: employeelist) {
		%>
		<tr>
			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getSalary()%></td>
			<td><%=employee.getMobileno()%></td>
		</tr>
		<%
			}
			}
		%>
		<tr>
			<td><button>
					<a href="index.html">Index Data</a>
				</button></td>
		</tr>
	</table>
</body>
</html>