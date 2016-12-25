<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app">
<head>
    <title>Product</title>
</head>
<body ng-controller="productCtrl" ng-cloak>
    <h4>Name: {{product.name}}</h4></a>
    <h4>Cost: {{product.cost}}</h4>
    <h4>Company: {{product.company.name}}</h4>
    <h4>Type: {{product.type.name}}</h4>
    <h4>Description: {{product.description}}</h4>
    <h4 ng-repeat="att in product.attributeValues">{{att.attribute.name}}: {{att.value}}</h4>
    <input type="submit" class="btn btn-info" value="Add to basket" ng-click="addBasket()">


    <script src="/resources/js/product.js"></script>
</body>
</html>
