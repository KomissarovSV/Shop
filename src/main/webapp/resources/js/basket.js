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
        $http.post("/book",param).then(function () {
            $scope.positions = $scope.positions.filter(function (position) {
                return !position.buy;
            })
        },function (data) {});

    }

    $scope.delete = function (index) {
        $http.get("/delete?index=" + index).then(function () {
            $scope.positions.splice(index,1);
        },function (data) {});
    }
    
    $scope.changeCount = function (position) {
        position.cost = position.count * position.product.cost;
    }
});
