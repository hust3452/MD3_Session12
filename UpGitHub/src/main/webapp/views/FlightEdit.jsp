<%--
  Created by IntelliJ IDEA.
  User: Nguyen Quang Phu
  Date: 2025/11/18
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <h1>Edit</h1>
</head>
<body>
<form:form modelAttribute="editFlightDTO" action="${pageContext.request.contextPath}/flight/edit/${id}" method="post"
           enctype="multipart/form-data">
    <form:label path="flightName">Flight Name</form:label>
    <form:input path="flightName"/>
    <form:errors path="flightName" cssClass="cssError"/><br>

    <form:label path="startingPoint">Starting Point</form:label>
    <form:input path="startingPoint"/>
    <form:errors path="startingPoint" cssClass="cssError"/><br>

    <form:label path="destination">Destination</form:label>
    <form:input path="destination"/>
    <form:errors path="destination" cssClass="cssError"/><br>

    <form:label path="departureDate">Departure Date</form:label>
    <form:input path="departureDate" type="date"/>
    <form:errors path="departureDate" cssClass="cssError"/><br>

    <form:label path="arrivalTime">Arrival Time</form:label>
    <form:input path="arrivalTime"/>
    <form:errors path="arrivalTime" cssClass="cssError"/><br>

    <form:label path="timeUnit">Time Unit</form:label>
    <form:input path="timeUnit"/>
    <form:errors path="timeUnit" cssClass="cssError"/><br>

    <form:label path="travelImage">Choise Image</form:label>
    <input type="file" id="travelImage" name="travelImage"/><br>
    <form:errors path="travelImage" cssClass="cssError"/><br>

    <form:label path="status">Status</form:label>
    <form:select path="status">
        <form:option value="CANCEL" label="Cancel"/>
        <form:option value="FLIGHT" label="Flight"/>
        <form:option value="DONE" label="Done"/>
    </form:select>
    <form:errors path="status" cssClass="cssError"/><br>

    <input type="submit" value="edit">

</form:form>

</body>
</html>
