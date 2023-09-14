<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/14/2023
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Translate</h1>
<form action="/result" method="post">
  <label>
    <input type="text" name="english" placeholder="enter word">
  </label>
    <button type="submit">
        Result
    </button>
</form>
${message} ${vietnamese}
</body>
</html>
