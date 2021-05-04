package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    
	 public static Connection getConnection() throws SQLException {
		 
		 try {
			 Class.forName("org.postgresql.Driver");
		 }catch (ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 
		    String url = "jdbc:postgresql://p1bank.cr3mdvbkdi0b.us-east-2.rds.amazonaws.com/postgres";
			String username = "postgres"; //you can use environment variables to hide the raw values to protect this info
			String password = "password"; //System.getenv("keyName")
			return DriverManager.getConnection(url, username, password);
		 }
	 
	 public static void main(String[] args) {
		/*
		 * Finally block will close the try with resources.
		 */
		 try(Connection conn = ConnectionUtil.getConnection()) {
			 System.out.println("Connection successful.");
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
	}
}
