/**
 * Created by Damian Bartos
 * 01.09.2016.
 */

'use strict';

angular.module('onlineShop', [
        'ngRoute',
        'ui.bootstrap',
        'angularValidator',
        'onlineShop.focus',
        'onlineShop.routes',
        'onlineShop.home',
        'onlineShop.items',
        'onlineShop.item',
        'onlineShop.cart',
        'onlineShop.login',
        'onlineShop.register'])

    .controller('NavHeaderController', ['$scope', '$location', '$rootScope', '$window', function ($scope, $location, $rootScope, $window) {
        //init if needed
        if ($window.localStorage.getItem("authenticated") === null) {
            $window.localStorage.setItem("authenticated", false);
            $rootScope.authenticated = false;
        } else if ($rootScope.authenticated === null) {
            var temp = $window.localStorage.getItem("authenticated");
            $rootScope.authenticated = (temp == 'true');
        }

        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();
        };

        $scope.isLogged = function () {
            var temp = $window.localStorage.getItem("authenticated");
            return temp == 'true';
        }
    }]);