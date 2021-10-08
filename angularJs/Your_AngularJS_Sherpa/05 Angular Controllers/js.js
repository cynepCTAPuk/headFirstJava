angular
    .module('myApp', [])
    .run(function ($rootScope) {
        $rootScope.user = {
            name: 'Ari'
        };
    })
    .controller('HomeController', function ($scope) {
        $scope.user = {
            name: 'Nate'
        };
    });
