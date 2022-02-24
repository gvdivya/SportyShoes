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

<%List<Student> ss= (List<Student>)request.getAttribute("list"); %>
<table border="1">
<tr><th>Sid</th><th>Sname</th><th>Semail</th></tr>

<%for(Student s:ss) {%>

<tr><td><%=s.getSid() %></td><td><%=s.getName() %></td><td><%=s.getEmail() %></td></tr>
<%} %>

</table>
</body>
</html>