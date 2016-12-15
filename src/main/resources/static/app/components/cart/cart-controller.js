/**
 * Created by Damian Bartos on 04.09.2016.
 */

angular.module('onlineShop.cart', ['ui.bootstrap', 'ngRoute'])
    .controller('CartController', function ($scope, $http, $location) {
        $scope.cartItems=[];
        $scope.cartValue = function(){
            let temp = 0;
            $scope.cartItems.forEach(function(item){
                temp += item.item.price * item.quantity;
            });
            return temp;
        };

        $scope.init = function(){
            $http.get('/api/cart/all').success(function(data){
                console.log('cart list');
                console.log(data);
                $scope.cartItems = data;
                $scope.cartItems.sort(function (a, b) {
                    if(a.item.name < b.item.name) return -1;
                    if(a.item.name > b.item.name) return 1;
                    return 0;
                })
            })
        };

        $scope.price = function(price, quantity){
            return price * quantity;
        };

        $scope.makeOrder = function(){
            $http.get('/api/order/create').success(function(data){
                //$localization.path("/myOrders")
                $location.path('/myOrders');
            });
        };

        $scope.addSingleItem = function (itemId) {
            $http.get('/api/cart/add/?id='+itemId).success(function () {
                $scope.init();
            })
        };
        $scope.removeSingleItem = function (itemId) {
            $http.get('/api/cart/delete/item/?id='+itemId).success(function () {
                $scope.init();
            })
        };

        $scope.delete = function (itemId) {
            $http.get('api/cart/delete/?id='+itemId).success(function(){
                $scope.init();
            })
        }
    });