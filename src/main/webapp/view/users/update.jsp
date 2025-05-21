<%@ page import="com.example.mvc_crud.entities.user" %><%--
  Created by IntelliJ IDEA.
  User: vietnguyen
  Date: 21/05/2025
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    user user = (user) request.getAttribute("userUpdate");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users/update?id=<%= user.getId()%>" method="post">
    name:
    <input type="text" name="name" value="<%= user.getName()%>">
    Email:
    <input type="email" name="email" disabled value="<%= user.getEmail()%>">
    <button>update</button>
</form>
</body>
</html>
