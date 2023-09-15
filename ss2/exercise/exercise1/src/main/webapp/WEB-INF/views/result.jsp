<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/15/2023
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<form action="/showResult" >
    <input type="checkbox" value="Lettuce" name="condiment">Lettuce
    <input type="checkbox" value="Tomato" name="condiment">Tomato
    <input type="checkbox" value="Mustard" name="condiment">Mustard
    <input type="checkbox" value="Sprouts" name="condiment">Sprouts
    <button type="submit">
        Save
    </button>
</form>
<c:if test="${spices != null }">
    <h3>Your options is : </h3>
    <c:forEach var="list" items="${spices}">
        ${list}
    </c:forEach>
</c:if>
</body>
</html>
