var app = angular.module("app", []);


app.controller("ctrl", function ($scope,$http) {
    
    $scope.goToOrder = function (id) {
        window.location.href = "/order?id=" + id;
    }
});
