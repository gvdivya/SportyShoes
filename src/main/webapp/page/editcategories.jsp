<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit categories</title>
</head>
<body>
<%String cname= (String)request.getAttribute("cname"); %>
<%Integer cid= (Integer)request.getAttribute("cid"); %>
<h1>Edit Category</h1>

<form action="dashboardjsp">
<input type="submit"  value="Dashboard">
</form><form action="logoutjsp">
<input type="submit"  value="logout"></form>

<form action="updatecategory">


Category Name<input type="text" name="cname" value=<%= cname %>><br>
<input type="hidden"id="cid" name="cid" value=<%=cid %>>

<input type="submit" value="Submit"><input type="submit" value="cancel">
</form>
</body>
</html>