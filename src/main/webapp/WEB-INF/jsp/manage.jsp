<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="app">
<head>
    <title>Title</title>
</head>
<body>
<a href="/statistics">Statistics</a>
<br>
<a href="/deleteProduct">Delete product</a>
<br>
<a href="/add">Add product</a>
<table class="table table-hover" ng-controller="ctrl">
    <tr>
        <th>Identity number</th>
        <th>User name</th>
        <th>Phone</th>
        <th>Date</th>
        <th>Cost</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td ng-click="goToOrder(${order.id})">${order.id}</td>
            <td>${order.user.name}</td>
            <td>${order.user.phone}</td>
            <td>${order.date}</td>
            <td>${order.cost}</td>
            <td>
                <form action="/change?id">
                    <select name ="status">
                        <c:forEach items="${statuses}" var="status">
                            <c:if test="${status eq order.status}">
                                <option value="${status.id}" selected>${status.name}</option>
                            </c:if>
                            <c:if test="${status != order.status}">
                                <option value="${status.id}">${status.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="id" value="${order.id}">
                    <td>
                        <input type="submit" value="update">
                    </td>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="/resources/js/manage.js"></script>
</body>
</html>
