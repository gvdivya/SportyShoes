<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.controller.*" %>
   <%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add product</h1>


<form action="dashboardjsp">
<input type="submit"  value="Dashboard">
</form><form action="logoutjsp">
<input type="submit"  value="logout"></form>

<form action="insertproduct">
Product Name<input type="text" name="pname"><br>
Product price($)<input type="text" name="price"><br>

<label>Gender </label>

<select name="gender" >       
<option>Male</option> 
<option>Female</option>
</select>

<label>Categories </label>

<%List<Categories> cs= (List<Categories>)request.getAttribute("list"); %>

<select name="categories" > 

<%for(Categories c:cs) {%>

<option><%=c.getCname() %></option>

<%} %>


</select>

<input type="submit" value="Insert">

</form>

<form action="getallproducts"><input type="submit" value="cancel"></form>


</body>
</html>