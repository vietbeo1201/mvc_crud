<%--
  Created by IntelliJ IDEA.
  User: vietnguyen
  Date: 21/05/2025
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String) request.getAttribute("message");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%= message %></h1>
<a href="/users"> user manager</a>
</body>
</html>
