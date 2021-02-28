<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
     <%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/table.css"/>
<meta charset="ISO-8859-1">
<title>Search Record</title>
</head>
<body>
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


</tr>
<br>
</br>
<%
int count=0;
String color="#F9EBB3";
if(request.getAttribute("Search")!=null){
	ArrayList a1=(ArrayList)request.getAttribute("Search");
	Iterator itr=a1.iterator();
	while(itr.hasNext()){
		if (count%2==0){
			color="#eeffee";
		}else{
			color="#F9EBB3";
		}
		count++;
	ArrayList Search=(ArrayList)itr.next();
%>
  
  <tr>
	<td> <%out.println(Search.get(0)); %> </td>
	<td> <%out.println(Search.get(1)); %> </td>
	<td> <%out.println(Search.get(2)); %> </td>
	<td> <%out.println(Search.get(3)); %> </td>
	<td> <%out.println(Search.get(4)); %> </td>
	<td> <%out.println(Search.get(5)); %> </td>
	<td> <%out.println(Search.get(6)); %> </td>
	<td> <%out.println(Search.get(7)); %> </td>
	
	</tr>
<% 
}
}
%>
</table>
</body>
</html>