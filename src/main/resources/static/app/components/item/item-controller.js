/**
 * Created by Damian Bartos
 * 06.09.2016.
 */

angular.module('onlineShop.item', ['ngRoute', 'ui.bootstrap'])
    .controller('ItemController', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http){
        //current item
        $scope.currentItem = {};
        $scope.addToCartButton = function(itemId){
            //TODO add to cart
            $http.get('api/cart/add/?id='+itemId).success(function(){
                console.log("dodano do koszyka");
            })
        };
        $scope.init = function(){
            var itemId = $routeParams.id;
            $http.get("/public/item/?id="+itemId).success(function(data){
                $scope.currentItem = data;
            })
        }
    }]);