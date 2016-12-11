<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en" ng-app="app">

<body>
<div ng-controller="productsCtrl">
    <div class="container">
        <div class="row">
            Product Type:
            <select ng-cloak ng-model="type">
                <option ng-repeat="type in types">{{type.name}}</option>
                <option></option>
            </select>
            Product Company:</h4>
            <select ng-cloak ng-model="company">
                <option ng-repeat="company in companies">{{company.name}}</option>
                <option></option>
            </select>
            Min Cost: <input type="number" ng-model="min">
            Max Cost: <input type="number" ng-model="max">
        </div>
    </div>
    <br>
    <div class="container">
        <div class="col-md-4" ng-repeat="product in products | myFilter:min:max | filter:type | filter:company ">
            <table>
                <tr ng-cloak>
                    <a href="/product?id={{product.id}}"><h4>Name: {{product.name}}</h4></a>
                    <h4>Cost: {{product.cost}}</h4>
                    <h4>Company: {{product.company.name}}</h4>
                    <h4>Type: {{product.type.name}}</h4>
                    <h4>Description: {{product.description}}</h4>
                </tr>
            </table>
        </div>
    </div>
</div>

<script src="resources/js/home.js"></script>
</body>

</html>