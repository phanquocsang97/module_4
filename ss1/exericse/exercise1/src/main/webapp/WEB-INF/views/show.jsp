<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/14/2023
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hiển thị tiền tệ</h1>
<form action="/result">
    <label>
        <input type="number" name="usd" id="usd" placeholder="enter USD">
    </label>
    <button type="submit">
        Submit
    </button>
</form>
${vnd} VND
</body>
</html>
