/**
 * Created by Damian Bartos
 * 04.09.2016.
 */

angular.module('onlineShop.register', ['ui.bootstrap', 'ngRoute', 'angularValidator'])
    .controller('RegisterController', function ($scope, $http) {
        $scope.myForm = {};
        $scope.user = {};
        $scope.submitMyForm = function(){
            console.log($scope.myForm);
            console.log($scope.user);
            $http({
                method: 'POST',
                url: 'public/auth/register',
                data: angular.toJson($scope.user)
            }).success(function(){
                console.log('wyslano');
            })
        };
        $scope.loginValidator = function(login){
            if(!login){return}
            if(login.length<4){
                return "login must be at least " + 4 + " characters long";
            }
            return true;
        };
        $scope.passwordValidator = function(password) {

            if(!password){return;}

            if (password.length < 6) {
                return "Password must be at least " + 6 + " characters long";
            }

            if (!password.match(/[A-Z]/)) {
                return "Password must have at least one capital letter";
            }

            if (!password.match(/[0-9]/)) {
                return "Password must have at least one number";
            }

            return true;
        };
    });
