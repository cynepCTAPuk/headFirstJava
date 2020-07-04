var app = angular.module('app', []);

/* app.directive('fooBar', function () {
    return {
        template: "Hello World!",
        link: function (scope, element, attrs) {
            console.log('fooBar')
        }
    };
}); */
/* app.directive('fooBar', function () {
    return {
        template: "<div>Hello World!</div>",
        link: function (scope, element, attrs) {
            console.log('fooBar')
        }
    };
}); */
/* app.directive('fooBar', function () {
    return {
        template: "<div>Hello {{name}}!</div>",
        link: function (scope, element, attrs) {
            console.log('fooBar');
            scope.name = "Sasha";
        }
    };
}); */
app.directive('fooBar', function () {
    var bookmarks = [
        {
            id:  1,
            name: 'AngularJS'
        },
        {
            id: 2,
            name: 'EmberJS'
        },
        {
            id: 3,
            name: 'ReactJS'
        }
    ];
    return {
        template: "<div ng-repeat='bookmark in myBookmarks'>{{bookmark.id}}. {{bookmark.name}}</div>",
        link: function (scope, element, attrs) {
            console.log('fooBar');
            scope.myBookmarks = bookmarks;
        }
    };
});