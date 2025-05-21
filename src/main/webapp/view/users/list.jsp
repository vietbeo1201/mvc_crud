<%@ page import="java.util.List" %>
<%@ page import="javax.print.MultiDocPrintService" %>
<%@ page import="com.example.mvc_crud.entities.user" %><%--
  Created by IntelliJ IDEA.
  User: vietnguyen
  Date: 21/05/2025
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<user> listUser = (List<user>) request.getAttribute("listUser");
    int total = listUser.size();
    int stt = 1;
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>users list:</h1>
<p>Total <%= total%> users</p>
<a href="/users/create"> create </a>
<table>
    <tr>
        <td>stt</td>
        <td>name</td>
        <td>email</td>
    </tr>
    <% for (user item: listUser)  {%>
        <tr>
            <td><%= stt %></td>
            <td><%= item.getName()%></td>
            <td><%= item.getEmail()%></td>
            <td>
                <a href="/users/delete?id=<%= item.getId()%>"> Delete </a>
            </td>
            <td>
                <a href="/users/update?id=<%= item.getId()%>"> update</a>
            </td>
        </tr>
    <% stt++; %>
    <% }%>
</table>
</body>
</html>
