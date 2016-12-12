var app = angular.module("app", []);


app.controller("productCtrl", function ($scope,$http) {

    var id = window.location.search.substring(4);

    $http.get('product/' + id).then(success = function (response) {
        $scope.product = response.data;
    }, error = function (data) {});    
    
    $scope.addBasket = function () {
        var obj = window.sessionStorage.getItem("products");
        var items =  $.parseJSON(obj)
        if (items == null){
            items = [];
        }
        items.push($scope.product)
        window.sessionStorage.setItem("products",JSON.stringify(items));
    }
});