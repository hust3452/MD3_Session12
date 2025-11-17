<%--
  Created by IntelliJ IDEA.
  User: Nguyen Quang Phu
  Date: 2025/11/15
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        thead {
            background-color: #007BFF;
            color: #fff;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        img {
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        a {
            text-decoration: none;
            padding: 6px 12px;
            margin: 0 5px;
            border-radius: 4px;
            font-size: 14px;
        }

        a[href*="update"] {
            background-color: #28a745;
            color: #fff;
        }

        a[href*="delete"] {
            background-color: #dc3545;
            color: #fff;
        }

        a[href*="initCreate"] {
            display: inline-block;
            background-color: #007BFF;
            color: #fff;
            padding: 8px 16px;
            border-radius: 4px;
        }

        a:hover {
            opacity: 0.8;
        }
    </style>
    <h1>Product List</h1>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
        <th>Public Year</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.title}</td>
            <td>${product.author}</td>
            <td>${product.price}</td>
            <td>${product.publicYear}</td>
            <td><img src="${product.image}" alt="${product.title}" height="50px" width="50px" /></td>
            <td>
                <a href="/productController/update/${product.id}">Update</a>
                <a href="/productController/delete/${product.id}" onclick="return confirm('Do you want to delete ?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/productController/initCreate">Create new Product</a>
</body>
</html>
