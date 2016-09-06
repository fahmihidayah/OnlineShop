/**
    * Created by Damian Bartos
    * 06.09.2016.
    */
angular.module('onlineShop.focus',['ngRoute'])
    .directive('focus', function($timeout) {
        return {
            scope : {
                trigger : '@focus'
            },
            link : function(scope, element) {
                scope.$watch('trigger', function(value) {
                    if (value === "true") {
                        $timeout(function() {
                            element[0].focus();
                        });
                    }
                });
            }
        };
    });