<%--
  Created by IntelliJ IDEA.
  User: vietnguyen
  Date: 21/05/2025
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users/create" method="post">
  Name:
  <input type="text" name="name">
  email
  <input type="email" name="email">
  pass
  <input type="password" name="password">
  <button type="submit">save</button>
</form>
</body>
</html>
