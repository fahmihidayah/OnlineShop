/**
 * Created by Damian Bartos on 04.09.2016.
 */

angular.module('onlineShop.cart', ['ui.bootstrap', 'ngRoute'])
    .controller('CartController', function ($scope) {
        $scope.cartItems=[];
        $scope.cartValue = function(){
            var temp = 0;
            $scope.cartItems.forEach(function(item){
                temp += item.price;
            });
            return temp;
        }
    });