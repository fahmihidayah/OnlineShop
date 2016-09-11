/**
 * Created by Damian Bartos on 11.09.2016.
 */

angular.module('onlineShop.orders', ['ui.bootstrap', 'ngRoute'])
    .controller('AdminAllOrdersController', ['$scope', '$http', function($scope, $http){
        $scope.allOrders = [];
        $scope.collapsedArray = [];

        $scope.collapse = function(index){
            $scope.collapsedArray[index] = !$scope.collapsedArray[index];
        };
        $scope.isCollapsed = function(index){
            return $scope.collapsedArray[index]==true;
        };
        $scope.getDate = function (milis) {
            var date = new Date(milis);
            return date.getDate()+'/'+(date.getMonth()+1)+'/'+date.getFullYear();
        };
        $scope.init = function(){
            $http.get('/api/order/all').success(function(data){
                $scope.allOrders = data;
                console.log(data);
            });
        }
    }])
    .controller('UserOrdersController', ['$scope', '$http', function($scope, $http){
        $scope.allOrders = [];
        $scope.collapsedArray = [];

        $scope.collapse = function(index){
            $scope.collapsedArray[index] = !$scope.collapsedArray[index];
        };
        $scope.isCollapsed = function(index){
            return $scope.collapsedArray[index]==true;
        };
        $scope.getDate = function (milis) {
            var date = new Date(milis);
            return date.getDate()+'/'+(date.getMonth()+1)+'/'+date.getFullYear();
        };
        $scope.init = function(){
            $http.get('/api/order/my').success(function(data){
                $scope.allOrders = data;
                console.log(data);
            });
        }

    }]);