<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app">
<head>
    <title>Title</title>
</head>
<body ng-controller="ctrl">
<table>
    <tr>
        <td>
            <h4>Name:</h4>
        </td>
        <td>
            <input type="text" ng-model="product.name">
        </td>
    </tr>
    <tr>
        <td>
            <h4>Cost:</h4>
        </td>
        <td>
            <input type="text" ng-model="product.cost">
        </td>
    </tr>
    <tr>
        <td>
            <h4>Description:</h4>
        </td>
        <td>
            <input type="text" ng-model="product.description">
        </td>
    </tr>
    <tr>
        <td>
            <h4>Company:</h4>
        </td>
        <td>
            <select ng-model="product.company.id">
                <option ng-repeat="option in companies" value="{{option.id}}">{{option.name}}</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>
            <h4>Type:</h4>
        </td>
        <td>
            <select ng-model="product.type.id">
                <option ng-repeat="option in types" value="{{option.id}}">{{option.name}}</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>
            <input type="button" value="add attribute" ng-click="addAtt()">
        </td>
        <td>
            <input type="button" value="delete attribute" ng-click="delAtt()">
        </td>
    </tr>
    <tr ng-repeat="att in product.attributeValues">
        <td>Attribute name:</td>
        <td>
            <select ng-model="att.attribute.id">
                <option ng-repeat="option in atts" value="{{option.id}}">{{option.name}}</option>
            </select>
        </td>
        <td>Attribute value:</td>
        <td><input type="text" ng-model="att.value"></td>
    </tr>
    <tr>
        <td>
            <input type="button" value="save" ng-click="sent()">
        </td>
    </tr>
</table>

<script src="/resources/js/addProduct.js"></script>
</body>
</html>
