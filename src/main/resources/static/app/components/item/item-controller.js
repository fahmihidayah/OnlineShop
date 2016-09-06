/**
 * Created by Damian Bartos
 * 06.09.2016.
 */

angular.module('onlineShop.item', ['ngRoute'])
    .controller('ItemController', ['$scope', '$routeParams', '$rootScope', function($scope, $routeParams, $rootScope){
        console.log($rootScope.test);
        console.log($routeParams.id);
    }]);