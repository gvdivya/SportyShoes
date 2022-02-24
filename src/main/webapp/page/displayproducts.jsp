<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.controller.*" %>
   <%@ page import="java.util.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products list</title>
</head>
<body>

<h1>Products list</h1>
<form action="insertproductjsp">
<input type="Submit" value="Add Products">
</form>


<%List<Product> ss= (List<Product>)request.getAttribute("list"); %>
<table border="1">
<tr><th>Product ID</th>
<th>Product Name</th>
<th>Category</th>
<th>Price($)</th>
<th>Gender</th>
<th>Action</th></tr>

<% if (ss != null) { %>
<%for(Product p:ss) {%>
<% String cname = ""; %>
<% if (p.getCategories() != null) { %>
<%  cname = p.getCategories().getCname(); %>

<%} %>

<tr><td><%=p.getPid() %></td>
<td><%=p.getPname() %></td>
<td><%=cname %></td>
<td><%=p.getPrice() %></td>
<td><%=p.getGender() %></td>

<td><form action="editproduct"><input type="Submit" name="Edit" value= "Edit">
<input type="hidden"id="pid" name="pid" value=<%=p.getPid() %>>
<input type="hidden"id="pname" name="pname" value=<%=p.getPname() %>>
<input type="hidden"id="categories" name="categories" value=<%=cname%>>
<input type="hidden"id="price" name="price" value=<%=p.getPrice() %>>
<input type="hidden"id="gender" name="gender" value=<%=p.getGender() %>>

</form>

<form action="deleteproduct"><input type="Submit" name="Delete" value ="Delete">

<input type="hidden"id="pid" name="pid" value=<%=p.getPid() %>>
<input type="hidden"id="pname" name="pname" value=<%=p.getPname() %>>
</form>
</td></tr>
<%} %>
<%} %>

</table>

<form action="dashboardjsp">
<input type="submit"  value="Dashboard">
</form><form action="logoutjsp">
<input type="submit"  value="logout"></form>
</body>
</html>