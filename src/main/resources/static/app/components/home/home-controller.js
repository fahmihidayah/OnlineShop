/**
 * Created by Damian Bartos
 * 02.09.2016.
 */

angular.module('onlineShop.home', ['ngRoute'])
    .controller('HomeController',['$scope', '$http', function ($scope, $http) {
        $scope.currentItems = [];
        $scope.init = function () {
            console.log('test');
            $http.get('public/item/all')
                .success(function (items) {
                    $scope.currentItems = items;
                    console.log(items);
                });
        };
        $scope.addToCartButton = function(pressedIndex) {
            var itemIndex = $scope.currentItems[pressedIndex].itemId;
            console.log(itemIndex);
        };
    }]);