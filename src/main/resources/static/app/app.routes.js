/**
 * Created by Damian Bartos
 * 01.09.2016.
 */

angular.module('onlineShop.routes', ['ngRoute'])
    .config(function ($routeProvider) {
        var URL = '/app/components/';
        $routeProvider
            .otherwise('/')
            .when('/', {
                templateUrl: URL + '/home/home-view.html',
                controller: 'HomeCtrl'
            })
            .when('/items', {
                templateUrl: URL + '/items/items-view.html',
                controller: 'PaginationController'
            })
            .when('/cart', {
                templateUrl: URL + '/cart/cart-view.html',
                controller: 'CartController'
            })
            .when('/login', {
                templateUrl: URL + '/login/login-view.html',
                controller: 'LoginController'
            })
            .when('/register', {
                templateUrl: URL + '/register/register-view.html',
                controller: 'RegisterController'
            });
    });