<%--
  Created by IntelliJ IDEA.
  User: Nguyen Quang Phu
  Date: 2025/11/18
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <h1>Home</h1>
</head>
<body>

<form action="/flight" method="get">
    <input type="text" name="searchName" value="${searchName}" placeholder="input Flight">
    <button type="submit">Search</button>
</form>
<form action="/flight/searchInfo" method="get">
    <input type="text" name="startingPoint" value="${startingPoint}" placeholder="Input Starting Point">
    <input type="text" name="destination" value="${destination}" placeholder="Input Destination">
    <button type="submit">Search</button>
</form>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Flight Name</th>
        <th>Starting Point</th>
        <th>Destination</th>
        <th>Departure Date</th>
        <th>Arrival Time</th>
        <th>Time Unit</th>
        <th>Travel Image</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${flights}" var="flight">
        <tr>
            <td>${flight.id}</td>
            <td>${flight.flightName}</td>
            <td>${flight.startingPoint}</td>
            <td>${flight.destination}</td>
            <td>${flight.departureDate}</td>
            <td>${flight.arrivalTime}</td>
            <td>${flight.timeUnit}</td>
            <td><img src="${flight.travelImage}" alt="${flight.flightName}" width="50" height="50"/></td>
            <td>
                <c:choose>
                    <c:when test="${flight.status == null}">
                        Flight
                    </c:when>
                    <c:when test="${flight.status == 'CANCEL'}">
                        Cancel
                    </c:when>
                    <c:when test="${flight.status == 'FLIGHT'}">
                        Flight
                    </c:when>
                    <c:when test="${flight.status == 'DONE'}">
                        Done
                    </c:when>
                </c:choose>
            </td>
            <td>
                <a href="/flight/edit/${flight.id}">Edit</a>
                <a href="/flight/delete/${flight.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/flight/initCreate">Creat New Flight</a>

<!-- Phân trang -->

<div>
    <c:forEach items="${pages}" var="page">
        <a href="flight?page=${page}">${page}</a>
    </c:forEach>
</div>

<c:if test="${not empty message}">
    <script>
        alert("${message}");
    </script>
</c:if>


</body>
</html>
