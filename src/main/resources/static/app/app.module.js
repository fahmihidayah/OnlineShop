/**
 * Created by Damian Bartos
 * 01.09.2016.
 */

'use strict';

angular.module('onlineShop', [
        'ngRoute',
        'ui.bootstrap',
        'angularValidator',
        'onlineShop.routes',
        'onlineShop.home',
        'onlineShop.items',
        'onlineShop.cart',
        'onlineShop.login',
        'onlineShop.register'])

    .controller('NavHeaderController', function ($scope, $location) {
        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();
        };
    });