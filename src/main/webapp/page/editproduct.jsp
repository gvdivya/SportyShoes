<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.controller.*" %>
   <%@ page import="java.util.*" %>
    
    
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>
<%String pname= (String)request.getAttribute("pname"); %>
<%Integer pid= (Integer)request.getAttribute("pid"); %>
<%Integer price= (Integer)request.getAttribute("price"); %>
<%String gender= (String)request.getAttribute("gender"); %>


<h1>Edit Product</h1>


<form action="dashboardjsp">
<input type="submit"  value="Dashboard">
</form><form action="logoutjsp">
<input type="submit"  value="logout"></form>

<form action="updateproduct">

<input type="hidden"id="pid" name="pid" value=<%=pid %>>

Product Name<input type="text" name="pname" value=<%= pname %>><br>
Product price($)<input type="text" name="price" value=<%= price %>><br>

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

<input type="submit" value="Update">

</form>