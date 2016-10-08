/**
 * Created by lanki on 10/4/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('loginController', loginController);

    loginController.$inject = ['AuthenticationService', '$location','$rootScope'];
    function loginController(AuthenticationService, $location,$rootScope) {
        var lgnCtrl = this;

        lgnCtrl.login = login;

        init();
        function init() {
            AuthenticationService.clearCredentials();
        };

        function login() {

            lgnCtrl.dataLoading = true;

            AuthenticationService.Login(lgnCtrl.email, function (loggedin) {
                lgnCtrl.userDetails = loggedin.data;
                console.log(lgnCtrl.userDetails);
                console.log(lgnCtrl.userDetails.password);
                console.log(lgnCtrl.userDetails.userrole);
                console.log(loggedin.data.id);
                if (lgnCtrl.email == lgnCtrl.userDetails.email && lgnCtrl.password == lgnCtrl.userDetails.password && lgnCtrl.userDetails.userrole == 'user') {
                    AuthenticationService.setCredentials(lgnCtrl.email, lgnCtrl.password, loggedin.data.id);
                    $rootScope.userLoggedIn = true;
                    $location.path('/homepage');
                }
                else if (lgnCtrl.email == lgnCtrl.userDetails.email && lgnCtrl.password == lgnCtrl.userDetails.password && lgnCtrl.userDetails.userrole == 'admin') {
                    AuthenticationService.setCredentials(lgnCtrl.email, lgnCtrl.password, loggedin.data.id);
                    $rootScope.adminLoggedIn = true;
                    $location.path('/adminpopular');
                }

                else {
                    console.log(lgnCtrl.email);
                    $location.path('/');
                    console.log('username and password dont match');
                }
            });
        }
    }

})();