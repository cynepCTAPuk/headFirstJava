var app = angular.module('app', []);

app.controller('mainCtrl', function ($scope) {
    $scope.name = 'Bob';
});
/* app.directive('fooBar', function () {
    return {
        restrict: 'E',
        transclude: true,
        // template: 'This is my super directive! <div ng-transclude></dive>',
        template: 'This is my super directive! <ng-transclude></ng-transclude>',
        link: function (scope, element, attrs) {
            console.log('This is my super directive!')
        }
    };
}); */
app.directive('fooBar', function () {
    return {
        restrict: 'E',
        transclude: true,
        // template: 'This is my super directive! <div ng-transclude></dive>',
        template: 'This is my super directive!',
        link: function (scope, element, attrs, ctrl, transclude) {
            console.log('This is my super directive!');
            transclude(scope, function (clone, scope) {
                console.log(scope);
                element.append(clone);
            });
        }
    };
});