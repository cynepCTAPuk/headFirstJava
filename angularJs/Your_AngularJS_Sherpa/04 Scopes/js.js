angular.module('myApp', [])
    .run(function ($rootScope) {
        $rootScope.user = {
            email: 'ari@fullstack.io'
        };
        $rootScope.message = "Welcome back";
    });
