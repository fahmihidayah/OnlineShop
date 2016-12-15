/**
    * Created by Damian Bartos
    * 09.09.2016.
    */


angular.module('onlineShop.admin.editItem', ['ngRoute', 'angularValidator', 'base64'])
    .controller('AdminEditItemController', ['$scope', '$http', '$location', '$routeParams', '$base64', function ($scope, $http, $location, $routeParams, $base64) {
        $scope.item = {};
        $scope.readFile = function(callback){
            var file = document.getElementById("image").files;
            var fr = new FileReader();
            console.log(file[0]);
            if (FileReader && file && file.length) {
                fr.readAsBinaryString(file[0]);
                //fr.readAsArrayBuffer(file[0]);
                fr.onload = function () {
                    var imageData = fr.result;
                    $scope.item.image = $base64.encode(imageData);
                    callback();
                };
            }else{
                console.log('dada');
                callback();
            }
        };

        $scope.submitMyForm = function () {
            if(confirm('Jesteś pewien, że chcesz edytować ten przedmiot')){
                $scope.readFile(function(){
                    $http.post("/api/item/update/?id="+$scope.item.itemId,angular.toJson($scope.item)).success(function(data){
                        console.log("Item has been edited");
                        $location.path("/item/"+data.itemId);
                    }).error(function () {
                        console.log("error");
                    })
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