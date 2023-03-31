package com.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LaDbConnection {
	
	public static Connection getLaDbConn(){
			
		Connection conn = null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver loaded");
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ladb",
						"root", "Simplilearn");
				System.out.println("DB conected");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return conn;
		}
	
	public static void main(String[] args) {
		getLaDbConn();
	}

}
