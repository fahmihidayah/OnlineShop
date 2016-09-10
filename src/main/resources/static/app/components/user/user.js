/**
 * Created by Damian Bartos
 * 06.09.2016.
 */


angular.module('onlineShop.user', ['ngRoute', 'angularValidator'])
    .controller('EditUserController', ['$scope', '$http', '$location', '$routeParams', function ($scope, $http, $location, $routeParams) {
        $scope.user = {};

        $scope.submitMyForm = function () {
            if(confirm('Are you sure that you want edit yout user settings')){
                $http.post("/api/user/update", angular.toJson($scope.user)).success(function(data){
                    console.log("Item has been edited");
                    $scope.ok = true;
                }).error(function () {
                    $scope.ok = false;
                    console.log("error");
                })
            }
        };

        $scope.init = function(){
            var itemId = $routeParams.id;
            $http.get("/api/user/my").success(function(data){
                $scope.user = data;
                console.log(data);
            })
        }
    }]);
