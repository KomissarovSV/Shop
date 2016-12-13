<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="app">
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-hover" ng-controller="ctrl">
    <tr>
        <th>Identity number</th>
        <th>Date</th>
        <th>Cost</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr ng-click="goToOrder(${order.id})">
            <td>${order.id}</td>
            <td>${order.date}</td>
            <td>${order.cost}</td>
        </tr>
    </c:forEach>
</table>
<script src="/resources/js/history.js"></script>
</body>
</html>
