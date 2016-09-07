/**
 * Created by Damian Bartos
 * 01.09.2016.
 */

'use strict';

angular.module('onlineShop', [
        'ngRoute',
        'ui.bootstrap',
        'angularValidator',
        'LocalStorageModule',
        'onlineShop.focus',
        'onlineShop.routes',
        'onlineShop.home',
        'onlineShop.items',
        'onlineShop.item',
        'onlineShop.cart',
        'onlineShop.login',
        'onlineShop.register'])

    .config(function (localStorageServiceProvider) {
        localStorageServiceProvider.setPrefix('OSls');
    })

    .controller('NavHeaderController', ['$scope', '$location', function ($scope, $location) {
        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();
        };
        $scope.isLogged = function () {
            return $rootScope.authenticated;
        }
    }]);