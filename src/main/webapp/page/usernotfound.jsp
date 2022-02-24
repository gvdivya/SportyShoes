<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.controller.*" %>
   <%@ page import="java.util.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users not found</title>
</head>
<body>

<h1> User not found</h1>


<form action="dashboardjsp">
<input type="submit"  value="Dashboard">
</form><form action="logoutjsp">
<input type="submit"  value="logout"></form>

<form action="getallusers">
<input type="submit"  value="Users list">
</form>


</table>
</body>
</html>