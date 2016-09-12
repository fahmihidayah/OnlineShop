/**
 * Created by Damian Bartos
 * 08.09.2016.
 */


angular.module('onlineShop.admin.addItem', ['ngRoute', 'angularValidator', 'base64'])
    .controller('AdminAddItemController', ['$scope', '$http', '$location', '$base64', function ($scope, $http, $location, $base64) {
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
            //document.getElementById("image").files;
            $scope.readFile(function(){
                console.log(angular.toJson($scope.item));
                $http.post("/api/item/create",angular.toJson($scope.item)).success(function(data){
                    console.log(data);
                    console.log("Item has been added");
                    $location.path("/item/"+data.itemId);
                }).error(function () {
                    console.log("error");
                })
            });
        };
    }]);
