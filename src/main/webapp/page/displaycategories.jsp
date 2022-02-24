<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.controller.*" %>
   <%@ page import="java.util.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>categories list</title>
</head>
<body>

<h1>Categories list</h1>

<form action="dashboardjsp">
<input type="submit"  value="Dashboard">
</form><form action="logoutjsp">
<input type="submit"  value="logout"></form>
<form action="insertcategoryjsp">
<input type="Submit" value="Add Category">
</form>


<%List<Categories> cs= (List<Categories>)request.getAttribute("list"); %>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Action</th></tr>

<%for(Categories c:cs) {%>

<tr><td><%=c.getCid() %></td><td><%=c.getCname() %></td>
<td>
<form action="editcategories">
<input type="Submit" name="edit" value="Edit">
<input type="hidden"id="cid" name="cid" value=<%=c.getCid() %>>
<input type="hidden"id="cname" name="cname" value=<%=c.getCname() %>>
</form>
<form action="deletecategories">
<input type="Submit" name="delete" value="Delete" >
<input type="hidden" id="cid" name="cid" value=<%=c.getCid() %>>
</form>
</td></tr>
<%} %>

</table>
</body>
</html>