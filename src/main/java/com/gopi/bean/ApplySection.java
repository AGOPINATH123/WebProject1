package com.gopi.bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gopi.jdbc.MySqlConnection;

public class ApplySection {
	

public static void main(String[] args) throws SQLException  {
		
		Connection con=MySqlConnection.getInstance();
		Statement st=con.createStatement();
		
		 //st.execute("INSERT INTO EMPLOYEE VALUES(7,'HI',25478)");
		//st.execute("DELETE FROM EMPLOYEE WHERE EMPNAME='HGC'");
		//st.execute("UPDATE EMPLOYEE SET EMPSALARY=50000 WHERE EMPSALARY=25478");
		
		ResultSet rs=st.executeQuery("SELECT * FROM EMPLOYEE");
		
		while(rs.next()) {
			System.out.println(rs.getString("empname")+" \t\t"+rs.getInt("empid")+" \t\t"+rs.getDouble("empsalary"));
						
		}
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	}
	
		
		
		
		
		
		
		
		
		
		
		/*Connection con=MySqlConnection.getInstance();		
		Statement st=con.createStatement();
		st.execute("INSERT INTO EMPLOYEE VALUES(5,'ABCD',25000.32)");
	//	st.execute("DELETE FROM EMPLOYEE WHERE EMPID=5");
		st.execute("UPDATE EMPLOYEE SET EMPNAME='CBA' WHERE EMPID=3");		
		
		ResultSet re=st.executeQuery("SELECT * FROM EMPLOYEE");
		while(re.next()) {
			System.out.println(re.getString("empname")+"\t "+re.getInt("empid"));
		}
		
		con.close();
		System.out.println("data has been inserted");
		
		/*Connection con;
		con =    MySqlConnection.getInstance();
		Statement st = con.createStatement();		
		st.execute("INSERT INTO STUDENT VALUES(101,'school','male')");
		//st.execute("DELETE FROM STUDENT WHERE ID=101");
		st.execute("UPDATE STUDENT SET NAME='GOPI' WHERE ID=3");
		ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");
		
		while(rs.next()) {
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("gender"));
		}
		con.close();
		System.out.println("query is executed");*/
		
	