<%--
  Created by IntelliJ IDEA.
  User: Nguyen Quang Phu
  Date: 2025/11/15
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 20px;
        }

        form {
            max-width: 500px;
            margin: 0 auto;
            background: #fff;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        form label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333;
        }

        form input[type="text"],
        form input[type="number"],
        form input[type="date"],
        form input[type="file"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            transition: border-color 0.3s;
        }

        form input:focus {
            border-color: #007BFF;
            outline: none;
        }

        .cssError {
            color: #dc3545;
            font-size: 13px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #28a745;
            color: #fff;
            font-weight: bold;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
    <h1>Update Product</h1>
</head>
<body>

<form:form modelAttribute="updateProductDTO" action="${pageContext.request.contextPath}/productController/update/${id}" method="post" enctype="multipart/form-data">
    <form:label path="title">Title</form:label>
    <form:input path="title"/>
    <form:errors path="title" cssClass="cssError"/><br>

    <form:label path="author">Author</form:label>
    <form:input path="author"/>
    <form:errors path="author" cssClass="cssError"/><br>

    <form:label path="price">Price</form:label>
    <form:input path="price"/>
    <form:errors path="price" cssClass="cssError"/><br>

    <form:label path="publicYear">Public Year</form:label>
    <form:input path="publicYear" type="date" />
    <form:errors path="publicYear" cssClass="cssError"/><br>

    <form:label path="image">Choise Image</form:label>
    <input type="file" id="image" name="image"><br>
    <form:errors path="image" cssClass="cssError"/><br>

    <input type="submit" value="Update"/>

</form:form>

</body>
</html>
