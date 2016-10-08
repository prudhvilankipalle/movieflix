/**
 * Created by lanki on 10/4/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('AuthenticationService',AuthenticationService);

    AuthenticationService.$inject = ['$http', '$cookieStore', '$rootScope', '$timeout','UserService','$location'];
    function AuthenticationService($http,$cookieStore,$rootScope,$timeout,UserService,$location){

        var authservice = this;

        authservice.Login = Login;
        authservice.setCredentials = setCredentials;
        authservice.clearCredentials = clearCredentials;

        function Login(username,callback,errorCallback) {
            console.log(username);

            $http.get('http://localhost:8080/movieflix/users/' + username +'/')
                .then(function successcallback(response) {
                        callback(response);
                }, function error(error) {
                    console.log(error.status);
                    $location.path('/');
            });

        }

        function setCredentials(username, password,id) {
            $rootScope.globals = {
                currentUser: {
                    username: username,
                    id : id
                }
            };
            $cookieStore.put('globals', $rootScope.globals);
        }

        function clearCredentials() {
            $rootScope.globals = {};
            $cookieStore.remove('globals');
        }
    }
})();