package com.gopi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	private static MySqlConnection sqlconnection=new MySqlConnection() ;
	Connection connection;
	
	private MySqlConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("java.sql.DriverManager");
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useSSL=false", "root","111003");
			
		} catch ( SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
	}
	public static  Connection getInstance() {
		return sqlconnection.connection;
		
	}

	public static void main(String[] args) {
		System.out.println(MySqlConnection.getInstance());
		

	}

}
