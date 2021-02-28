<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
<h2>Update Car Details</h2>
<%if(request.getAttribute("UpdateMsg")!=null){
	out.println(request.getAttribute("UpdateMsg"));
}
%>
<div class="container">
<%if(session.getAttribute("emailid")!=null) {%>
  <form action="updateController" method="post">
  <label for="company">Company</label>
    <input type="text" id="company" name="company"  value="<%=request.getAttribute("company")%>">
    <label for="model">Model</label>
    <input type="text" id="model" name="model"  value="<%=request.getAttribute("model")%>">
    <label for="color">Color</label>
    <input type="text" id="color" name="color"  value="<%=request.getAttribute("color")%>" >
    <label for="Date-of-purchase">Date-of-purchase</label>
    <input type="text" id="Dateofpurchase" name="Dateofpurchase"  value="<%=request.getAttribute("Dateofpurchase")%>">
    <label for="price">Price</label>
    <input type="text" id="price" name="price"  value="<%=request.getAttribute("price")%>">
    <label for="engine capacity">Engine Capacity</label>
    <input type="text" id="enginecapacity" name="enginecapacity"  value="<%=request.getAttribute("enginecapacity")%>">
    <label for="license plate number">License plate Number</label>
    <input type="text" id="licenseplatenumber" name="licenseplatenumber"  value="<%=request.getAttribute("licenseplatenumber")%>">
    <label for="seating capacity">Seating Capacity</label>
    <input type="text" id="seatingcapacity" name="seatingcapacity"  value="<%=request.getAttribute("seatingcapacity")%>">
    <input type="submit" value="Update">
    </form>
  <% }%>
</div>
</body>
</html>