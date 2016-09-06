/**
 * Created by Damian Bartos
 * 04.09.2016.
 */

angular.module('onlineShop.login', ['ui.bootstrap', 'ngRoute', 'angularValidator'])
    .controller('LoginController',['$scope', '$rootScope', function ($scope, $rootScope) {
        $scope.login = '';
        $scope.password = '';
        $scope.submitForm = function() {
            if ($scope.loginForm.$valid) {
                //login here
                $rootScope.isLogged = true;
            }

        };

    }]);
