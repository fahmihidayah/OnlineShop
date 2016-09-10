/**
 * Created by Damian Bartos
 * 04.09.2016.
 */

angular.module('onlineShop.items', ['ui.bootstrap', 'ngRoute'])
    .controller('ItemsController', ['$scope', '$http', '$window', '$routeParams', function ($scope, $http, $window, $routeParams) {
        //pagination
        $scope.pagination = {
            totalItems: 1,
            itemsPerPage: 10,
            currentPage: 1,
            maxSize: 6
        };
        $scope.pageChanged = function () {
            var begin = ($scope.pagination.currentPage - 1) * $scope.pagination.itemsPerPage;
            var end = begin + $scope.pagination.itemsPerPage;
            $scope.currentItems = $scope.allItems.slice(begin, end);
            $window.scrollTo(0, 0);
        };

        //items
        $scope.allItems = [];
        $scope.currentItems = [];
        //init
        $scope.init = function () {
            $http.get('public/item/all').success(function (data) {
                $scope.allItems = data;
                $scope.pagination.totalItems = data.length;
                $scope.pageChanged();
            });
        };

        $scope.addToCartButton = function (pressedIndex) {
            var itemId = $scope.currentItems[pressedIndex].itemId;
            console.log(itemId);
        };

        $scope.asAdmin = function(){
            var temp = $window.localStorage.getItem("isAdmin");
            return temp == 'true';
        };

        $scope.deleteButton = function(pressedIndex){
            var itemId = $scope.currentItems[pressedIndex].itemId;
            if(confirm('Are you sure you want to delete this item')){
                $http.get('api/item/delete/?id='+itemId).success(function(){
                    console.log('item deleted');
                    $scope.init();
                })
            }
        }
    }])
    .filter('searchFor', function () {
        return function (arr, searchString) {
            if (!searchString) {
                return arr;
            }
            var result = [];
            searchString = searchString.toLowerCase();
            angular.forEach(arr, function (item) {
                if (item.name.toLowerCase().indexOf(searchString) !== -1) {
                    result.push(item);
                }
            });
            return result;
        };
    });

