var app = angular.module("app", []);

app.controller("basketCtrl", function ($scope, $http) {

    $http.get('/basket/products').then(function (response) {
        $scope.positions = [];
        response.data.forEach(function (product) {
            var position = {};
            position.buy = true;
            position.product = product;
            position.count = 1;
            position.cost = product.cost;
            $scope.positions.push(position);
        });
    }, function (data) {
    });

    $scope.book = function () {
        var param = $scope.positions.filter(function (position) {
            return position.buy;
        });
        $http.post("/book",param)
    }
});
