var app = angular.module("app", []);


app.controller("productCtrl", function ($scope,$http) {

    var id = window.location.search.substring(4);

    $http.get('product/' + id).then(success = function (response) {
        $scope.product = response.data;
    }, error = function (data) {});    
    
    $scope.addBasket = function () {
        $http.post('addBasket?id=' + id).then(function (response) {
        },function (data) {});
    }
});