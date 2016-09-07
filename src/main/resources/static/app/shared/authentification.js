/**
    * Created by Damian Bartos
    * 05.09.2016.
    */

angular.module('onlineShop.auth', ['ngRoute', 'ui.bootstrap'])

.controller('AuthController', ['$rootScope', function($rootScope){
    $rootScope.test = "rootScope";
    $rootScope.isLogged = false;
    $rootScope.currentUserId = -1;
}]);