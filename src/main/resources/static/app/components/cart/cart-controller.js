/**
 * Created by Damian Bartos on 04.09.2016.
 */

angular.module('onlineShop.cart', ['ui.bootstrap', 'ngRoute'])
    .controller('CartController', function ($scope, $http, $location) {
        $scope.cartItems=[];
        $scope.cartValue = function(){
            var temp = 0;
            $scope.cartItems.forEach(function(item){
                temp += item.price;
            });
            return temp;
        };

        $scope.init = function(){
            $http.get('/api/cart/all').success(function(data){
                console.log('cart list');
                console.log(data);
                $scope.cartItems = data;
            })
        };

        $scope.makeOrder = function(){
            $http.get('/api/order/create').success(function(data){
                //$localization.path("/myOrders")
                $location.path('/myOrders');
            });
        };

        $scope.delete = function (itemId) {
            $http.get('api/cart/delete/?id='+itemId).success(function(){
                $scope.init();
            })
        }
    });