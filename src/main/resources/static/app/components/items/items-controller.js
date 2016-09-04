/**
 * Created by Damian Bartos on 04.09.2016.
 */

angular.module('onlineShop.items', ['ui.bootstrap', 'ngRoute'])
    .controller('PaginationController', function($scope){
        $scope.totalItems = 10;
        $scope.itemsPerPage = 10;
        $scope.currentPage = 1;
        $scope.setPage = function (pageNo) {
            $scope.currentPage = pageNo;
        };
        $scope.pageChanged = function() {
            console.log('Page changed to: ' + $scope.currentPage);
        };
        $scope.maxSize = 6;
    })
    .controller('ItemsController', function($scope){

    });