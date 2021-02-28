<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
     <%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<title>Registration</title>
</head>
<body>
<h2>Register Car Details</h2>
<p style="color:red;">
<%if(request.getAttribute("MSG")!=null){
	out.println(request.getAttribute("MSG"));
}
%>
</p>
<div class="container">
  <form action="UserRegistrationController" method="post">
    <label for="company">Company</label>
    <input type="text" id="company" name="company" >

    <label for="model">Model</label>
    <input type="text" id="model" name="model" >
    <label for="color">Color</label>
    <input type="text" id="color" name="color" >
    <label for="Date-of-purchase">Date-of-purchase</label>
    <input type="text" id="Dateofpurchase" name="Dateofpurchase">
    <label for="price">Price</label>
    <input type="text" id="price" name="price">
    <label for="engine capacity">Engine Capacity</label>
    <input type="text" id="enginecapacity" name="enginecapacity">
    <label for="license plate number">License plate Number</label>
    <input type="text" id="licenseplatenumber" name="licenseplatenumber">
    <label for="seating capacity">Seating Capacity</label>
    <input type="text" id="seatingcapacity" name="seatingcapacity">
    <input type="submit" value="Submit">
  </form>
</div>
</body>
</html>