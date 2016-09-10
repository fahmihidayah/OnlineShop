/**
 * Created by Damian Bartos
 * 04.09.2016.
 */

angular.module('onlineShop.login', ['ui.bootstrap', 'ngRoute', 'angularValidator'])
    .controller('LoginController', ['$scope', '$rootScope', '$location', '$http','$window', function ($scope, $rootScope, $location, $http, $window) {
        $scope.myForm = {};
        $scope.user = {};
        $scope.submitForm = function () {
            $scope.login();
        };

        var authenticate = function (credentials, callback) {
            var headers = credentials ? {
                authorization: "Basic "
                + btoa(credentials.username + ":" + credentials.password)
            } : {};
            console.log(headers);
            $http.get('/user', {headers: headers}).success(function (data) {
                if (data.name) {
                    $rootScope.authenticated = true;
                    $rootScope.isAdmin = (data.authorities[0].authority == 'ROLE_ADMIN');
                    $window.localStorage.setItem("isAdmin", $rootScope.isAdmin);
                } else {
                    $rootScope.authenticated = false;
                    $window.localStorage.setItem("isAdmin", false);
                    $rootScope.isAdmin = false;
                }
                //save auth
                $window.localStorage.setItem("authenticated", $rootScope.authenticated);
                callback && callback();
            }).error(function () {
                $rootScope.authenticated = false;
                //save auth
                $window.localStorage.setItem("isAdmin", false);
                $rootScope.isAdmin = false;
                $window.localStorage.setItem("authenticated", $rootScope.authenticated);
                callback && callback();
            });
        };

        //login part
        authenticate(); //read auth
        $scope.error = false;
        $scope.credentials = {};
        $scope.login = function () {
            authenticate($scope.credentials, function () {
                if ($rootScope.authenticated) {
                    $location.path("/");
                    $scope.error = false;
                } else {
                    $location.path("/login");
                    $scope.error = true;
                }
                $window.localStorage.setItem("authenticated", $rootScope.authenticated);
            });
        };
    }]);
