<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<%--jsp--%>
<%--<%--%>
<%--    List<user> listUser = (List<user>) request.getAttribute("listUser");--%>
<%--    int total = listUser.size();--%>
<%--    int stt = 1;--%>
<%--%>--%>

<c:set var="listUser" value="${requestScope['listUser']}" />
<c:set var="total" value="${listUser.size()}"/>
<c:set var="stt" value="1"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>users list:</h1>
<p>Total <c:out value="${total}" /> users</p>
<a href="/users/create"> create </a>
<table>
    <tr>
        <td>stt</td>
        <td>name</td>
        <td>email</td>
        <td></td>
    </tr>
    <c:forEach items="${listUser}" var="item">
        <tr>
            <td><c:out value="${stt}"/></td>
            <td><c:out value="${item.getName()}"/></td>
            <td><c:out value="${item.getEmail()}"/></td>
            <td>
                <a href="/users/delete?id=<c:out value="${item.getId}"/>">delete</a>
                <a href="/users/update?id=<c:out value="${item.getId}"/>">update</a>
            </td>
        </tr>
        <c:set var="stt" value="${stt + 1}"/>
    </c:forEach>
<%--    <% for (user item: listUser)  {%>--%>
<%--        <tr>--%>
<%--            <td><%= stt %></td>--%>
<%--            <td><%= item.getName()%></td>--%>
<%--            <td><%= item.getEmail()%></td>--%>
<%--            <td>--%>
<%--                <a href="/users/delete?id=<%= item.getId()%>"> Delete </a>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a href="/users/update?id=<%= item.getId()%>"> update</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    <% stt++; %>--%>
<%--    <% }%>--%>

</table>
</body>
</html>
