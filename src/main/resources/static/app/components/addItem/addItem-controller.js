/**
 * Created by Damian Bartos
 * 08.09.2016.
 */


angular.module('onlineShop.admin.addItem', ['ngRoute', 'angularValidator'])
    .controller('AdminAddItemController', ['$scope', '$http', '$location', function ($scope, $http, $location) {
        $scope.item = {};
        $scope.submitMyForm = function () {
            console.log(angular.toJson($scope.item));
            $http.post("/api/item/create",angular.toJson($scope.item)).success(function(data){
                console.log(data);
                console.log("Item has been added");
                $location.path("/item/"+data.itemId);
            }).error(function () {
                console.log("error");
            })
        };
    }]);
