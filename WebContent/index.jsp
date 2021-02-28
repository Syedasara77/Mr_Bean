<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<title>Mr Bean</title>

</head>
<body>
<h2>Mr. Bean Car Management System</h2>
<p style="color:red;">
<%
if(request.getAttribute("errormsg")!=null){
	out.println(request.getAttribute("errormsg"));
}

%>
</p>
<%
if(request.getAttribute("emailid")!=null){
	out.println(request.getAttribute("emailid"));
}
%>
<br></br>
<div class="container">
  <form action="Loginservlet" method="post">
    <label for="Email Id">Email Id</label>
    <input type="text" id="Email Id" name="Email" >
    <label for="Password">Password</label>
    <input type="Password" id="Password" name="Password" >
    <input type="submit" value="Login">
  </form>
</div>

</body>
</html>