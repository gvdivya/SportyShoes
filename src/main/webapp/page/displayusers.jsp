<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.controller.*" %>
   <%@ page import="java.util.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users list</title>
</head>
<body>

<h1>Registered Users list</h1> <form action="dashboardjsp">
<input type="submit"  value="Dashboard">
</form><form action="logoutjsp">
<input type="submit"  value="logout"></form>

<form action="findByName">

<input type="text" name ="name" ><input type="submit" value ="Search">
</form>

<%List<Users> ss= (List<Users>)request.getAttribute("list"); %>
<table border="1">
<tr><th>User ID</th><th>Name</th><th>Email</th></tr>

<%for(Users s:ss) {%>

<tr><td><%=s.getUid() %></td><td><%=s.getName() %></td><td><%=s.getEmail() %></td></tr>
<%} %>

</table>



</body>
</html>