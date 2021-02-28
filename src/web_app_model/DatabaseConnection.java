package web_app_model;

import java.sql.*;

public class DatabaseConnection {
	private Connection con;

	public Connection establishConnection() {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app_bean","root","test");
			 return con;
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	
}
