var app = angular.module("app", []);

app.controller("basketCtrl", function ($scope, $http) {

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

    $http.get('/basket/positions').then(function (response) {
        $scope.positions = response.data;
        // response.data.forEach(function (product) {
        //     var position = {};
        //     position.buy = true;
        //     position.product = product;
        //     position.count = 1;
        //     position.cost = product.cost;
        //     $scope.positions.push(position);
        // });
    }, function (data) {
    });

    $scope.book = function () {

        for (var i = 0; i < $scope.positions.length; i++){
            if ($scope.positions[i].count == undefined && $scope.positions[i].buy){
                toastr.error('Product at ' + (i+1) + ' position has count less then 0', 'Error')
                return
            }
        }
        var pos = $scope.positions.filter(function (position) {
            return position.buy && position.count > 0;
        });
        if (pos.length == 0){
            toastr.error('There is nothing to order', 'Error');
            return
        }
        if ($scope.phone == undefined){
            toastr.error('Phone is empty', 'Error');
            return
        }
        var param = {
            positions : pos,
            phone : $scope.phone
        }
        $http.post("/book",param).then(function () {
            $scope.positions = $scope.positions.filter(function (position) {
                return !position.buy || position.count == undefined;
            });
            toastr.success('You have successfully done order. Wait for our phone', 'Order')
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
