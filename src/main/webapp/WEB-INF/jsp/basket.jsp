<%@ taglib prefix="c" uri="http://java.sun.com/jstl/xml" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app">
<head>
    <title>Basket</title>
</head>
<body>
    <table class="table table-hover" ng-controller="basketCtrl" ng-cloak>
        <tr ng-repeat="product in products">
            <td>{{product.name}}<td>
        </tr>
    </table>


    <script src="/resources/js/basket.js"></script>
</body>
</html>
