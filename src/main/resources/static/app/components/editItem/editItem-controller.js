/**
    * Created by Damian Bartos
    * 09.09.2016.
    */


angular.module('onlineShop.admin.editItem', ['ngRoute', 'angularValidator'])
    .controller('AdminEditItemController', ['$scope', '$http', '$location', '$routeParams', function ($scope, $http, $location, $routeParams) {
        $scope.item = {};

        $scope.submitMyForm = function () {
            if(confirm('Are you sure that you want edit that item')){
                $http.post("/api/item/update/?id="+$scope.item.itemId,angular.toJson($scope.item)).success(function(data){
                    console.log("Item has been edited");
                    $location.path("/item/"+data.itemId);
                }).error(function () {
                    console.log("error");
                })
            }
        };

        $scope.init = function(){
            var itemId = $routeParams.id;
            $http.get("/public/item/?id="+itemId).success(function(data){
                $scope.item = data;
            })
        }
    }]);