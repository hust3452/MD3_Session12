<%--
  Created by IntelliJ IDEA.
  User: Nguyen Quang Phu
  Date: 2025/11/16
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <h1>Register</h1>
</head>
<body>
<form:form modelAttribute="CustomerRegister" action="${pageContext.request.contextPath}/customer/register" method="post"
           enctype="multipart/form-data">
    <form:label path="customerName">Customer Name</form:label>
    <form:input path="customerName"/>
    <form:errors path="customerName" cssClass="cssError"/><br>

    <form:label path="email">Email</form:label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="cssError"/><br>

    <form:label path="password">Password</form:label>
    <form:input path="password"/>
    <form:errors path="password" cssClass="cssError"/><br>

    <form:label path="phone">Phone</form:label>
    <form:input path="phone"/>
    <form:errors path="phone" cssClass="cssError"/><br>

    <input type="submit" value="Submit">
</form:form>

<!-- Hiển thị thông báo lỗi -->
<c:if test="${not empty message}">
    <script>
        alert("${emailExist}")
    </script>
</c:if>

</body>
</html>
