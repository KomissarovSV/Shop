<%@ taglib prefix="c" uri="http://java.sun.com/jstl/xml" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html ng-app="app">
<head>
</head>
<body ng-controller="basketCtrl">
<sec:authorize access="!isAnonymous()">
    <a href="/history">Orders history</a>
</sec:authorize>
<table class="table table-hover" ng-cloak>
    <tr>
        <th>Buy</th>
        <th>Name</th>
        <th>Company</th>
        <th>Type</th>
        <th>Count</th>
        <th>Cost</th>
    </tr>
    <tr ng-repeat="position in positions">
        <td><input type="checkbox" ng-model="position.buy"></td>
        <td>{{position.product.name}}</td>
        <td>{{position.product.company.name}}</td>
        <td>{{position.product.type.name}}</td>
        <td><input type="number" min="0" ng-model="position.count" ng-change="changeCount(position)"></td>
        <td>{{position.cost}}</td>
        <td><input type="button" value="remove" ng-click="delete($index)"></td>
    </tr>
</table>
<input type="button" value="Order" ng-click="book()">
<sec:authorize access="isAnonymous()">
    <input type="text" placeholder="Input Phone" ng-model="phone">
</sec:authorize>
<script src="/resources/js/basket.js"></script>
</body>
</html>
