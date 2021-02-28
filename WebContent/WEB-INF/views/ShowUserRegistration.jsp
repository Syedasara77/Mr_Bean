<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
     <%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/table.css"/>
<meta charset="ISO-8859-1">
<title>user details</title>
</head>
<body>
<h2>Car Registration Details</h2>

<table id="customers">

<tr>

<th>Company </th>
<th>Model  </th>
<th>Color   </th>
<th>Date-Of-Purchase</th>
<th>Price </th>
<th>Engine Capacity </th>
<th>License Plate Number </th>
<th>Seating Capacity </th>
<th>Delete     </th>
<th>Update     </th>

</tr>

<%
  ResultSet results=(ResultSet)request.getAttribute("results");
  while(results.next()){%>
  <tr>
	<td> <%out.println(results.getString(1)); %> </td>
	<td> <%out.println(results.getString(2)); %> </td>
	<td> <%out.println(results.getString(3)); %> </td>
	<td> <%out.println(results.getString(4)); %> </td>
	<td> <%out.println(results.getString(5)); %> </td>
	<td> <%out.println(results.getString(6)); %> </td>
	<td> <%out.println(results.getString(7)); %> </td>
	<td> <%out.println(results.getString(8)); %> </td>
	<td> <a href="deleteController?company=<%=results.getString(1)%>">Delete</a> </td>
	<td> <a href="updateController?company=<%=results.getString(1)%>&model=<%=results.getString(2)%>&color=<%=results.getString(3)%>&Dateofpurchase=<%=results.getString(4)%>&price=<%=results.getString(5)%>&enginecapacity=<%=results.getString(6)%>&licenseplatenumber=<%=results.getString(7)%>&seatingcapacity=<%=results.getString(8)%>">Update</a></td>
	</tr>
<% }%>

</table>
</body>
</html>






