var app = angular.module('app', []);

app.directive('fooBar', function () {
    return {
        restrict: 'E',
        transclude: true,
        template: 'This is my super directive! <div ng-transclude></dive>',
        link: function (scope, element, attrs) {
            console.log('This is my super directive!')
        }
    };
});