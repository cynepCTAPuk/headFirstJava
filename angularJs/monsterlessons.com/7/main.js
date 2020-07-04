var app = angular.module('app', []);

/* app.directive('foo', function () {
    return function (scope, element, attrs) {
        console.log('this is my directive');
    };
}); */
/* app.directive('foo', function () {
    return {
        link: function (scope, element, attrs) {
            console.log('this is my directive');
        }
    };
}); */
/* app.directive('foo', function () {
    return {
        link: function (scope, element, attrs) {
            console.log('scope', scope);
            console.log('element', element);
            console.log('attrs', attrs);
        }
    };
}); */
/* app.directive('foo', function () {
    return {
        link: function (scope, element, attrs) {
            console.log('scope', scope);
            console.log('element', element);
            console.log('attrs', attrs);
            element.text('This is my magic directive');
        }
    };
}); */
/* app.directive('foo', function () {
    return {
        link: function (scope, element, attrs) {
            element.on('click', function () {
                console.log('click');
            });
        }
    };
}); */
app.directive('foo', function () {
    return {
        link: function (scope, element, attrs) {
            element.on('click', function () {
                if (element.text() === 'foo') {
                    element.text('bar');
                } else {
                    element.text('foo');
                }
            });
        }
    };
});