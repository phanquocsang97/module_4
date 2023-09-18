<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/18/2023
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<table border="1px" style="border-collapse: collapse">
    <tr>
        <th>Languages</th>
        <th>Page Size</th>
        <th>Spam Filter</th>
        <th>Signature</th>
    </tr>
    <tr>
        <td>${settings.languages}</td>
        <td>${settings.pageSize}</td>
<%--        <td>${settings.spamFilter}</td>--%>
        <c:choose>
            <c:when test="${settings.spamFilter == true}">
                <td>Turn on</td>
            </c:when>
            <c:when test="${settings.spamFilter == false}">
                <td>Turn off</td>
            </c:when>
        </c:choose>
        <td>${settings.signature}</td>
    </tr>
</table>
<a href="/create" style="text-decoration: none">Update</a>
</body>
</html>
