<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/15/2023
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/showResult">
    <input type="number" name="numFirst" placeholder="enter first number">
    <input type="number" name="numSecond" placeholder="enter second number">
    <br>
    <input type="submit" name="input" value="Addition(+)">
    <input type="submit" name="input" value="Subtraction(-)">
    <input type="submit" name="input" value="Multiplication(*)">
    <input type="submit" name="input" value="Division(/)">
    <p></p>
</form>
<c:if test="${totalCaculation!=null}">
    <h2>${totalCaculation}</h2>
</c:if>
<c:if test="${mess!=null}">
    <h2>${mess}</h2>
</c:if>
</body>
</html>
