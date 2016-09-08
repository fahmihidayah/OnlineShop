/**
 * Created by Damian Bartos
 * 08.09.2016.
 */


angular.module('onlineShop.addItem', ['ngRoute', 'angularValidator'])
    .controller('AddItemController', ['$scope', function ($scope) {
        $scope.item = {};
        $scope.submitMyForm = function () {

        };
    }]);
