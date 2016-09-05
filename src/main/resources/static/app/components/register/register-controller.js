/**
 * Created by Damian Bartos
 * 04.09.2016.
 */

angular.module('onlineShop.register', ['ui.bootstrap', 'ngRoute', 'angularValidator'])
    .controller('RegisterController', function ($scope) {
        $scope.firstName = '';
        $scope.lastName = '';
        $scope.login = '';
        $scope.email = '';
        $scope.password = '';
        $scope.submitForm = function() {
            if ($scope.registerForm.$valid) {
                //login here

            }

        };

    });
