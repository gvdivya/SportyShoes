<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String ca= (String)request.getAttribute("category"); %>
<h1>Add Category</h1>

<form action="dashboardjsp">
<input type="submit"  value="Dashboard">
</form><form action="logoutjsp">
<input type="submit"  value="logout"></form>

<form action="insertcategory">

Category Name<input type="text" name="cname" ><br>


<input type="submit" value="Submit"><input type="submit" value="cancel">
</form>
</body>
</html>