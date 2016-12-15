/**
 * Created by Damian Bartos
 * 04.09.2016.
 */

angular.module('onlineShop.register', ['ui.bootstrap', 'ngRoute', 'angularValidator'])
    .controller('RegisterController', function ($scope, $http, $location) {
        $scope.myForm = {};
        $scope.user = {};
        $scope.error = false;
        $scope.errorMSG = "";
        $scope.submitMyForm = function(){
            console.log($scope.myForm);
            console.log($scope.user);
            $http({
                method: 'POST',
                url: 'public/auth/register',
                data: angular.toJson($scope.user)
            }).success(function(){
                console.log('wyslano');
                $scope.error = false;
                $location.path("/login");
            }).error(function(){
                console.log('register error');
                $scope.error = true;
                $scope.errorMSG = "login i email jest już zajęty";
            })
        };
        $scope.loginValidator = function(login){
            if(!login){return}
            if(login.length<4){
                return "login musi mieć minimum " + 4 + " znaki";
            }
            return true;
        };
        $scope.passwordValidator = function(password) {

            if(!password){return;}

            if (password.length < 6) {
                return "hasło musi mieć minimum " + 6 + " znaków";
            }

            if (!password.match(/[A-Z]/)) {
                return "Hasło musi miec jedną wielką literę";
            }

            if (!password.match(/[0-9]/)) {
                return "Hasło musi mieć jedna cyfrę";
            }

            return true;
        };
    });
