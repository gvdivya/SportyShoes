<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.controller.*" %>
   <%@ page import="java.util.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users found</title>
</head>
<body>

<h1>Registered Users found</h1>

<form action="dashboardjsp">
<input type="submit"  value="Dashboard">
</form><form action="logoutjsp">
<input type="submit"  value="logout"></form>


<%Users s= (Users)request.getAttribute("users"); %>
<table border="1">
<tr><th>User ID</th><th>Name</th><th>Email</th></tr>

<tr><td><%=s.getUid() %></td><td><%=s.getName() %></td><td><%=s.getEmail() %></td></tr>


</table>
<form action="getallusers">
<input type="submit"  value="Users list">
</form>
</body>
</html>