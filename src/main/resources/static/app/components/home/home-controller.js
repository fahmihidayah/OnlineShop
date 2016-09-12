/**
 * Created by Damian Bartos
 * 02.09.2016.
 */

angular.module('onlineShop.home', ['ngRoute'])
    .controller('HomeController',['$scope', '$http', function ($scope, $http) {
        $scope.currentItems = [];
        $scope.init = function () {
            $http.get('public/item/all')
                .success(function (items) {
                    $scope.currentItems = items;
                    $scope.currentItems = $scope.currentItems.sort(function(){return 0.5-Math.random()})
                    $scope.currentItems = $scope.currentItems.slice(0, 3);
                    console.log(items);
                });
        };
        //$scope.addToCartButton = function(itemId) {
        //    $http.get('api/cart/add/?id='+itemId).success(function(){
        //        console.log("dodano do koszyka");
        //    })
        //};
    }]);