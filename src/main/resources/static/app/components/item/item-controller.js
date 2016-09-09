/**
 * Created by Damian Bartos
 * 06.09.2016.
 */

angular.module('onlineShop.item', ['ngRoute', 'ui.bootstrap'])
    .controller('ItemController', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http){
        //current item
        $scope.currentItem = {};
        $scope.addToCartButton = function(){
            //TODO add to cart
        };
        $scope.init = function(){
            var itemId = $routeParams.id;
            $http.get("/public/item/?id="+itemId).success(function(data){
                $scope.currentItem = data;
            })
        }
    }]);