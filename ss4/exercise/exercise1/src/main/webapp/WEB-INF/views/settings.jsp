<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/18/2023
  Time: 1:59 PM
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
<form:form modelAttribute="settings" action="/create" method="post">
  <form:select path="languages">
    <form:option value="" label="Chọn"/>
    <form:options items="${languages}"/>
  </form:select><br>
  <form:select path="pageSize">
    <form:options items="${pageSize}"/>
  </form:select><br>
  <form:checkbox path="spamFilter" value="true" label="Enable spam filter"/><br>
  <form:input path="signature"/><br>
  <form:button>Update</form:button>
  <a href="/showList"><button type="button">Cancel</button></a>
</form:form>
<c:if test="${mess != null}">
  ${mess}
</c:if>
</body>
</html>
