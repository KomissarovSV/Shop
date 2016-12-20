var app = angular.module("app", []);


app.controller("ctrl", function ($scope,$http) {
    
    $http.get('/companies').then(success = function (response) {
        $scope.companies = response.data;
    }, error = function (data) {});

    $http.get('/atts').then(success = function (response) {
        $scope.atts = response.data;
    }, error = function (data) {});

    $http.get('/types').then(success = function (response) {
        $scope.types = response.data;
    }, error = function (data) {});
    
    $scope.sent = function () {
        
        $http.post('/save',$scope.product).then(success = function (response) {
            window.location.reload();
        }, error = function (data) {});
    };

    $scope.product = {
        attributeValues:[]
    };
    
    $scope.addAtt = function () {
        var att = {};
        $scope.product.attributeValues.push(att);
    };

    $scope.delAtt = function () {
        $scope.product.attributeValues.pop();
    }
});
