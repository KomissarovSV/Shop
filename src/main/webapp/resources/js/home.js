var app = angular.module("app", []);


app.controller("productsCtrl", function ($scope,$http) {

    $http.get('basket/positions').then(function (response) {
        $scope.positions = response.data;
        var count = 0;
        var cost = 0;

        $scope.positions.forEach(function (position) {
            count = count + position.count;
            cost = cost + position.cost;
        });
        $scope.basket = {
            count:count,
            cost:cost
        }
    },function () {});

    toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": "toast-bottom-right",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "1000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };

    $scope.book = function (product) {
        $http.post('addBasket?id=' + product.id).then(function (response) {
            toastr.success('You have successfully added product to basket', 'Booking');
            $scope.basket.cost += product.cost;
            $scope.basket.count += 1;
        },function () {
        });
    };


    $http.get('/products').then(success = function (response) {
        $scope.products = response.data;

        $scope.min = ($scope.products.reduce(function (x,y) {
            return x.cost>y.cost?y:x;
        })).cost;

        $scope.max = ($scope.products.reduce(function (x,y) {
            return x.cost>y.cost?x:y;
        })).cost;

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
        var result = [];
        for (var i=0; i<items.length; i++){
            if (items[i].cost >= min && items[i].cost <= max)  {
                result.push(items[i]);
            }
        }
        return result;
    };
});

