var app = angular.module("app", []);
app.controller("productsCtrl", function ($scope,$http) {

    $http.get('/products').then(success = function (response) {
        $scope.products = response.data;

        $scope.min = ($scope.products.reduce(function (x,y) {
            return x>y?x:y;
        })).cost

        $scope.max = ($scope.products.reduce(function (x,y) {
            return x>y?y:x;
        })).cost

    }, error = function (data) {});

    $http.get('/companies').then(success = function (response) {
        $scope.companies = response.data;
    }, error = function (data) {});

    $http.get('/types').then(success = function (response) {
        $scope.types = response.data;
    }, error = function (data) {});

});

app.filter("myFilter", function() {
    return function (items, min, max) {
        var result = []
        for (var i=0; i<items.length; i++){
            if (items[i].cost >= min && items[i].cost <= max)  {
                result.push(items[i]);
            }
        }
        return result;
    };
});
