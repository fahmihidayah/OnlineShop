/**
 * Created by Damian Bartos
 * 04.09.2016.
 */

angular.module('onlineShop.login', ['ui.bootstrap', 'ngRoute', 'angularValidator'])
    .controller('LoginController', ['$scope', '$rootScope', '$location', '$http', function ($scope, $rootScope, $location, $http) {
        $scope.myForm = {};
        $scope.user = {};
        $scope.submitForm = function () {
            $scope.login();
        };

        var authenticate = function(credentials, callback) {
            var headers = credentials ? {authorization : "Basic "
            + btoa(credentials.username + ":" + credentials.password)
            } : {};
            console.log(credentials);
            console.log(headers);
            $http.get('/user', {headers : headers}).success(function(data) {
                console.log('from user');
                console.log(data);
                if (data.name) {
                    $rootScope.authenticated = true;
                    console.log('TAK');
                } else {
                    $rootScope.authenticated = false;
                    console.log("NIE");
                }
                callback && callback();
            }).error(function() {
                $rootScope.authenticated = false;
                callback && callback();
            });
        };

        //login part
        authenticate();
        $scope.credentials = {};
        $scope.login = function() {
            authenticate($scope.credentials, function() {
                if ($rootScope.authenticated) {
                    console.log('NO JEST');
                    $location.path("/");
                    $scope.error = false;
                } else {
                    console.log('NO NIE MA');
                    $location.path("/login");
                    $scope.error = true;
                }
            });
        };

    }]);
