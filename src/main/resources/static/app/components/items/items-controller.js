/**
 * Created by Damian Bartos
 * 04.09.2016.
 */

angular.module('onlineShop.items', ['ui.bootstrap', 'ngRoute'])
    .controller('ItemsController', ['$scope', '$http', '$window', function ($scope, $http, $window) {
        //pagination
        $scope.pagination = {
            totalItems: 1,
            itemsPerPage: 10,
            currentPage: 1,
            maxSize: 6
        };
        $scope.pageChanged = function () {
            $scope.updateItems();
            $window.scrollTo(0, 0);
        };

        //items
        $scope.currentItems = [];
        $scope.updateItems = function () {
            $http.get('rest/item/all' + '?page=' + ($scope.pagination.currentPage - 1) + '&size=' + $scope.pagination.itemsPerPage)
                .success(function (items) {
                    $scope.currentItems = items;
                    console.log($scope.currentItems);
                });
        };
        $scope.addToCartButton = function (pressedIndex) {
            var itemIndex = $scope.currentItems[pressedIndex].itemId;
            console.log(itemIndex);
        };
        //init
        $scope.init = function () {
            $http.get('rest/item/num').success(function (number) {
                $scope.pagination.totalItems = number;
            });
            $scope.updateItems();
        }
    }]);
