/**
 * Created by Damian Bartos
 * 08.09.2016.
 */


angular.module('onlineShop.admin.addItem', ['ngRoute', 'angularValidator'])
    .controller('AdminAddItemController', ['$scope', function ($scope) {
        $scope.item = {};
        $scope.submitMyForm = function () {

        };
    }]);
