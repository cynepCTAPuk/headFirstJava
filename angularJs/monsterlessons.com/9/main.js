var app = angular.module('app', []);

/* app.directive('fooBar', function () {
    return {
        link: function () {
            console.log('fooBar')
        }
    };
}); */
/* app.directive('fooBar', function () {
    return {
        restrict: 'A', // attribut
        link: function () {
            console.log('fooBar Attribut')
        }
    };
}); */
/* app.directive('fooBar', function () {
    return {
        restrict: 'E', // element
        link: function () {
            console.log('fooBar Element')
        }
    };
}); */
/* app.directive('fooBar', function () {
    return {
        restrict: 'C', // class - doesn't work
        link: function () {
            console.log('fooBar Class')
        }
    };
}); */
/* app.directive('fooBar', function () {
    return {
        restrict: 'M', // comment
        link: function () {
            console.log('fooBar Comment')
        }
    };
}); */
app.directive('fooBar', function () {
    return {
        restrict: 'AECM', // all, for class doesn't work
        link: function () {
            console.log('fooBar')
        }
    };
});