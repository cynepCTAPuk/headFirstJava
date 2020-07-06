var app = angular.module('app', []);

/* app.directive('fooBar', function () {
    return {
        restrict: 'E',
        template: '<div>element</div><div>element</div><div>element</div>',
        link: function (scope, element, attrs) {
            console.log('directive')
        }
    };
}); */
/* app.directive('fooBar', function () {
    return {
        restrict: 'E',
        templateUrl: 'bookmarks.html',
        link: function (scope, element, attrs) {
            console.log('directive')
        }
    };
}); */
app.directive('fooBar', function () {
    var bookmarks = [
        {
            id: 1,
            name: 'EmberJS'
        },
        {
            id: 2,
            name: 'AngularJS'
        }
    ];
    return {
        restrict: 'E',
        templateUrl: "bookmarks.html",
        link: function (scope, element, attrs) {
            console.log('directive');
            scope.bookmarks = bookmarks;
        }
    };
});