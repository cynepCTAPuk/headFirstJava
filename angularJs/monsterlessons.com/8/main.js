var app = angular.module('app', []);

/* app.controller('mainCtrl', function ($scope) {
    $scope.money = "244";
}); */
/* app.filter('moneyFilter', function () {
    return function (str) {
        console.log('str', str);
        return str;
    };
}); */
/* app.filter('moneyFilter', function () {
    return function (str) {
        console.log('str', str);
        return 500;
    };
}); */
app.controller('mainCtrl', function ($scope) {
    $scope.money1 = '1.222$';
    $scope.money2 = '$2.333';
    $scope.money3 = '3.444';
});
app.filter('moneyFilter', function () {
    return function (str) {
        console.log('str', str);
        var firstChar = str.slice(0, 1);
        if (firstChar === '$') return str;
        var lastChar = str.slice(-1);
        if (lastChar === '$') return '$' + str.slice(0, str.length - 1);
        return '$' + str;
    };
});