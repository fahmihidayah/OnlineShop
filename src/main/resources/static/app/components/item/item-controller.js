/**
 * Created by Damian Bartos
 * 06.09.2016.
 */

angular.module('onlineShop.item', ['ngRoute', 'ui.bootstrap'])
    .controller('ItemController', ['$scope', '$routeParams', '$rootScope', function($scope, $routeParams, $rootScope){
        //carousel
        $scope.myInterval = 5000;
        $scope.noWrapSlides = false;
        $scope.active = 0;
        var slides = $scope.slides = [];
        var currIndex = 0;
        $scope.init = function(){
            var itemIndex = $routeParams.id;
            //download item info
            slides.push({
                image: '/assets/img/maxresdefault.jpg',
                id: currIndex++
            });
            slides.push({
                image: '/assets/img/test.png',
                id: currIndex++
            });
            slides.push({
                image: '/assets/img/maxresdefault.jpg',
                id: currIndex++
            });
            slides.push({
                image: '/assets/img/test.png',
                id: currIndex++
            });
        };

        //current item
        $scope.currentItem = {};
        $scope.orderedQuantity = 1;
        $scope.addToCartButton = function(){

        }
    }]);