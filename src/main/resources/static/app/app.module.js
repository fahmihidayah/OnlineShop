/**
 * Created by Damian Bartos
 * 01.09.2016.
 */

'use strict';

angular.module('onlineShop', [
    'ngRoute',
    'ui.bootstrap',
    'onlineShop.routes',
    'onlineShop.home',
    'onlineShop.items'])

.controller('NavHeaderController', function($scope, $location){
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };
});