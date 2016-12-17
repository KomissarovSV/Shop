var app = angular.module("app", []);
app.controller("ctrl", function ($scope, $http) {

    $scope.change = function (id,status) {
        $http.get('/change?id=' + id + "&status=" + status).then(function (response) {

        })
    }

    $scope.goToOrder = function (id) {
        window.location.href = "/order?id=" + id;
    }

});