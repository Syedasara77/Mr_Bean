package web_app_model;

import java.sql.*;

public class User {
	private Statement stmnt;
    public void addRegistration(String company,String model,String color,String Dateofpurchase,String price,String enginecapacity,String licenseplatenumber,String seatingcapacity,Connection con) {
	 try {
		  stmnt = con.createStatement();
		  stmnt.executeUpdate("insert into register values ('"+company+"', '"+model+"' ,'"+color+"' ,'"+Dateofpurchase+"','"+price+"','"+enginecapacity+"','"+licenseplatenumber+"','"+seatingcapacity+"') ");
	 }catch(Exception e) {
		 e.printStackTrace();
		 
	 }
 }
 public ResultSet ShowRegistration(Connection con) {
	 try {
		 stmnt=con.createStatement();
		 ResultSet result = stmnt.executeQuery("select *from register");
		 return result;
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	return null;
	 
 }
 public void deleteReg(String company,Connection con) {
	 try {
		 Statement stmnt = con.createStatement();
		 stmnt.executeUpdate("Delete from register where company='"+company+"'");
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
 }
 public void updateReg(String model,String color,String Dateofpurchase,String price,String enginecapacity,String licenseplatenumber,String seatingcapacity,String company,Connection con) {
	 try {
		 Statement stmnt = con.createStatement();
		 stmnt.executeUpdate("UPDATE register SET model=('"+model+"'),color='"+color+"',Dateofpurchase ='"+Dateofpurchase+"',price='"+price+"',enginecapacity='"+enginecapacity+"',licenseplatenumber='"+licenseplatenumber+"',seatingcapacity ='"+seatingcapacity+"' WHERE company=('"+company+"')");	 
		 //PreparedStatement ps = con.prepareStatement(city);
		// ps.executeUpdate("Update register set city= '"+city+"' where emailid=('"+emailId+"')");
		  
	 }catch(Exception e) {
		e.printStackTrace();
	 }
 } 
 public ResultSet search(String model,String color,String Dateofpurchase,String price,Connection con) {
	 try {
		 stmnt=con.createStatement();
		 ResultSet result=stmnt.executeQuery("select * from register where model='"+model+"' or  color='"+color+"' or Dateofpurchase='"+Dateofpurchase+"' or price='"+price+"' order by model");
		 return result;
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return null;
 }
 }
