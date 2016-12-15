/**
 * Created by Damian Bartos on 11.09.2016.
 */

angular.module('onlineShop.orders', ['ui.bootstrap', 'ngRoute'])
    .controller('AdminAllOrdersController', ['$scope', '$http', function($scope, $http){
        $scope.allOrders = [];
        $scope.collapsedArray = [];

        $scope.itemsCount = function (order) {
            let temp = 0;
            for(let i=0; i<order.items.length; i++){
                temp += order.items[i].quantity;
            }
            return temp;
        };

        $scope.valueOfOrder = function(order){
            let temp = 0;
            for(let i=0; i<order.items.length; i++){
                temp += order.items[i].quantity * order.items[i].item.price;
            }
            return temp;
        };

        $scope.collapse = function(index){
            $scope.collapsedArray[index] = !$scope.collapsedArray[index];
        };
        $scope.isCollapsed = function(index){
            return $scope.collapsedArray[index]==true;
        };
        $scope.getDate = function (milis) {
            if(milis==null)
                return 'NIE';
            var date = new Date(milis);
            return date.getDate()+'/'+(date.getMonth()+1)+'/'+date.getFullYear();
        };
        $scope.init = function(){
            $http.get('/api/order/all').success(function(data){
                $scope.allOrders = data;
                $scope.allOrders.sort(function (a, b) {
                   if(a.orderId < b.orderId) return -1;
                   if(a.orderId > b.orderId) return 1;
                    return 0;
                });
                console.log(data);

            });
        };
        $scope.isAdmin = function(){
            return true;
        };
        $scope.makePaid = function(index){
            var orderId = $scope.allOrders[index].orderId;
            $http.get("api/order/paid/?id="+orderId).success(function(data){
                console.log(data);
                console.log($scope.allOrders);
                $scope.allOrders[index] = data;
                console.log($scope.allOrders)
            });
        };
        $scope.makeSent = function(index){
            var orderId = $scope.allOrders[index].orderId;
            $http.get("api/order/send/?id="+orderId).success(function(data){
                console.log(data);
                $scope.allOrders[index] = data;
            });
        };
    }])
    .controller('UserOrdersController', ['$scope', '$http', function($scope, $http){
        $scope.allOrders = [];
        $scope.collapsedArray = [];

        $scope.itemsCount = function (order) {
            let temp = 0;
            for(let i=0; i<order.items.length; i++){
                temp += order.items[i].quantity;
            }
            return temp;
        };

        $scope.valueOfOrder = function(order){
            let temp = 0;
            for(let i=0; i<order.items.length; i++){
                temp += order.items[i].quantity * order.items[i].item.price;
            }
            return temp;
        };
        $scope.collapse = function(index){
            $scope.collapsedArray[index] = !$scope.collapsedArray[index];
        };
        $scope.isCollapsed = function(index){
            return $scope.collapsedArray[index]==true;
        };
        $scope.getDate = function (milis) {
            if(milis==null)
                return 'NIE';
            var date = new Date(milis);
            return date.getDate()+'/'+(date.getMonth()+1)+'/'+date.getFullYear();
        };
        $scope.init = function(){
            $http.get('/api/order/my').success(function(data){
                $scope.allOrders = data;
                $scope.allOrders.sort(function (a, b) {
                    if(a.orderId < b.orderId) return -1;
                    if(a.orderId > b.orderId) return 1;
                    return 0;
                });
                console.log(data);
            });
        };
        $scope.isAdmin = function(){
            return false;
        }
    }]);