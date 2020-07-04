var app = angular.module('app', []);

app.controller('mainCtrl', function () {
    this.myLesson = 'MainLesson';

    this.addLesson = function () {
        console.log('addLesson');
    }
});

app.controller('firstCtrl', function () {
    this.myLesson = 'FirstLesson';
});

app.controller('secondCtrl', function () {
    this.myLesson = 'SecondLesson';
});