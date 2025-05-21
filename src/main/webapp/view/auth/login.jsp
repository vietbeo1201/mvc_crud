<%--
  Created by IntelliJ IDEA.
  User: vietnguyen
  Date: 20/05/2025
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/auth/login" method="post">
  email:
  <input type="email" name="email">
  password:
  <input type="password" name="password">
  <button type="submit">login</button>
</form>
</body>
</html>
