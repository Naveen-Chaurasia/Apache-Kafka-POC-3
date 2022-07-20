package com.info.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	static Connection connection;
	
	public static Connection getMySQLDBConnection() {
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bootdb";
		
		String username = "root";
		String password = "root";
		
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			
		}catch (Exception e) {
			System.out.print("*******************");
			e.printStackTrace();
		}
		
		
		return connection;
	}
	
}