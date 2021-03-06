/**
 * Created by Damian Bartos
 * 01.09.2016.
 */

'use strict';

angular.module('onlineShop', [
        'ngRoute',
        'ui.bootstrap',
        'angularValidator',
        'base64',
        'angularUtils.directives.dirPagination',
        'onlineShop.focus',
        'onlineShop.routes',
        'onlineShop.home',
        'onlineShop.items',
        'onlineShop.item',
        'onlineShop.cart',
        'onlineShop.login',
        'onlineShop.register',
        'onlineShop.user',
        'onlineShop.orders',
        //admin part
        'onlineShop.admin.addItem',
        'onlineShop.admin.editItem',
        'onlineShop.admin.users'])

    .controller('NavHeaderController', ['$scope', '$location', '$rootScope', '$window', '$http', function ($scope, $location, $rootScope, $window, $http) {
        //init if needed
        $http.get('user').success(function(data){
            $rootScope.authenticated = true;
            $window.localStorage.setItem("authenticated", true);
            $rootScope.isAdmin = (data.authorities[0].authority == 'ROLE_ADMIN');
            $window.localStorage.setItem("isAdmin", $rootScope.isAdmin);
        }).error(function(){
            $rootScope.authenticated = false;
            $window.localStorage.setItem("authenticated", false);
            $window.localStorage.setItem("isAdmin", false);
            $rootScope.isAdmin = false;
        });

        //if ($window.localStorage.getItem("authenticated") === null) {
        //    $window.localStorage.setItem("authenticated", false);
        //    $rootScope.authenticated = false;
        //} else if ($rootScope.authenticated === null) {
        //    var temp = $window.localStorage.getItem("authenticated");
        //    $rootScope.authenticated = (temp == 'true');
        //}

        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();
        };

        $scope.isLogged = function () {
            var temp = $window.localStorage.getItem("authenticated");
            return temp == 'true';
        };

        $scope.asAdmin = function(){
            var temp = $window.localStorage.getItem("isAdmin");
            return temp == 'true';
        };

        $scope.logout = function(){
            $http.post('/logout', {}).finally(function() {
                $rootScope.authenticated = false;
                $rootScope.isAdmin = false;
                $window.localStorage.removeItem("authenticated");
                $window.localStorage.removeItem("isAdmin");
                $location.path("/");
            });
            //    .error(function(data) {
            //    $rootScope.authenticated = false;
            //    $window.localStorage.removeItem("authenticated");
            //    $window.localStorage.removeItem("header");
            //});
        };
    }]);