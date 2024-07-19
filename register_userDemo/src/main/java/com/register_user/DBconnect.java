package com.register_user;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {

	private static String url = "jdbc:mysql://localhost:3306/reg_user"; //we made these variabels static bcz the method we are using these variabels is static method 
	private static String userName = "root";
	private static String password= "pulax";
	private static Connection con; //to return connection we need variable. con will return the connection
	
	//below method make the data base connection
	public static Connection getConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");//creating the driver
			
			con = DriverManager.getConnection(url,userName,password);
			
			
		}
		catch(Exception e) {
			System.out.println("Database connection is unsuccessfull.");
		}
		return con;
	}
	
}
