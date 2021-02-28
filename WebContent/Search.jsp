<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ include file="WEB-INF/views/menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
<br>
</br>
<div class="container">
  <form action="search" method="post">
    <label for="model">Model</label>
    <input type="text" id="model" name="model" >
    <label for="color">Color</label>
    <input type="text" id="color" name="color" >
    <label for="Date-of-purchase">Date-of-purchase</label>
    <input type="text" id="Dateofpurchase" name="Dateofpurchase">
    <label for="price">Price</label>
    <input type="text" id="price" name="price">
    
    <input type="submit" value="Search">
  </form>
</div>
</body>
</html>