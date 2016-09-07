/**
 * Created by Damian Bartos
 * 01.09.2016.
 */

angular.module('onlineShop.routes', ['ngRoute'])
    .config(function ($routeProvider, $httpProvider) {
        var URL = '/app/components/';
        $routeProvider
            .otherwise('/')
            .when('/', {
                templateUrl: URL + '/home/home-view.html'
                //controller: 'Home'
            })
            .when('/items', {
                templateUrl: URL + '/items/items-view.html'
                //controller: 'ItemsController'
            })
            .when('/item/:id',{
                templateUrl: URL + '/item/item-view.html'
            })
            .when('/cart', {
                templateUrl: URL + '/cart/cart-view.html'
                //controller: 'CartController'
            })
            .when('/login', {
                templateUrl: URL + '/login/login-view.html',
                controller: 'LoginController'
            })
            .when('/register', {
                templateUrl: URL + '/register/register-view.html'
                //controller: 'RegisterController'
            });
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    });