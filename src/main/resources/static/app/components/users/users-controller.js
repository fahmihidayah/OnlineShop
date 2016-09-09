/**
    * Created by Damian Bartos
    * 09.09.2016.
    */


angular.module('onlineShop.admin.users', ['ngRoute', 'angularValidator'])
    .controller('AdminUsersController', ['$scope', '$http', '$location', '$routeParams', '$window', function ($scope, $http, $location, $routeParams, $window) {
        $scope.allUsers = {};
        $scope.currentUsers = {};
        $scope.actualLoggedUserName = "";

        $scope.submitMyForm = function () {
        };

        $scope.skipCurrent = function(userName){
            return userName!=$scope.actualLoggedUserName;
        };

        $scope.changeRole = function(userId){
        };

        $scope.pagination = {
            totalItems: 1,
            itemsPerPage: 10,
            currentPage: 1,
            maxSize: 6
        };
        $scope.pageChanged = function(){
            var begin = ($scope.pagination.currentPage - 1) * $scope.pagination.itemsPerPage;
            var end = begin + $scope.pagination.itemsPerPage;
            $scope.currentUsers = $scope.allUsers.slice(begin, end);
            $window.scrollTo(0, 0);
        };

        $scope.init = function(){
            $http.get("/api/user/all").success(function(data){
                $scope.allUsers = data;
                console.log($scope.allUsers);
                $scope.pagination.totalItems = data.length;
                $scope.pageChanged();
            });
            $http.get("/user").success(function(data){
                $scope.actualLoggedUserName = data.name;
            })
        }
    }]);