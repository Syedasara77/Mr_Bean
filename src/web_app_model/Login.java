package web_app_model;
import java.sql.*;
public class Login {
	private Connection con;
	private Statement stmnt;
	private ResultSet result;
	
	public boolean verifyLogin(String email,String password,Connection con) {
		try {
			 
			 stmnt=con.createStatement();
			 result=stmnt.executeQuery("select *from login where email='"+email+"' and password='"+password+"'");
			 return result.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
