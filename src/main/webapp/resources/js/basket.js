var app = angular.module("app", []);

app.controller("basketCtrl", function ($scope,$http) {
    var obj = window.sessionStorage.getItem("products")
    $scope.products = $.parseJSON(obj)
});
