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
            })
            .when('/items', {
                templateUrl: URL + '/items/items-view.html'
            })
            .when('/item/:id', {
                templateUrl: URL + '/item/item-view.html'
            })
            .when('/cart', {
                templateUrl: URL + '/cart/cart-view.html'
            })
            .when('/login', {
                templateUrl: URL + '/login/login-view.html',
            })
            .when('/register', {
                templateUrl: URL + '/register/register-view.html'
            })
            .when('/addItem', {
                templateUrl: URL + '/addItem/addItem-view.html'
            })
            .when('/editItem/:id', {
                templateUrl: URL + '/editItem/editItem-view.html'
            })
            .when('/users', {
                templateUrl: URL + '/users/users-view.html'
            })
            .when('/user', {
                templateUrl: URL + '/user/user-view.html'
            });
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    });