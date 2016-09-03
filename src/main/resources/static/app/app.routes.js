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
    });