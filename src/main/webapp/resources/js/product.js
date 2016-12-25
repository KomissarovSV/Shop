var app = angular.module("app", []);


app.controller("productCtrl", function ($scope,$http) {

    var id = window.location.search.substring(4);

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

    $http.get('product/' + id).then(success = function (response) {
        $scope.product = response.data;
    }, error = function (data) {});
    
    $scope.addBasket = function () {
        $http.post('addBasket?id=' + id).then(function (response) {
            toastr.success('You have successfully added product to basket', 'Booking')
        },function (data) {});
    }
});