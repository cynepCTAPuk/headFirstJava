var app = angular.module('app', []);

app.run(function ($templateCache) {
    $templateCache.put('bookmarks.html',
     "<div ng-repeat='bookmark in bookmarks'>{{bookmark.id}}) {{bookmark.name}}</div>");
});

app.directive('fooBar', function ($templateCache) {
    var bookmarks = [
        { id: 1, name: 'EmberJS' },
        { id: 2, name: 'AngularJS' }
    ];
    return {
        restrict: 'E',
        templateUrl: "bookmarks.html",
        link: function (scope, element, attrs) {
            console.log('directive');
            scope.bookmarks = bookmarks;
            console.log($templateCache.info());
        }
    };
});