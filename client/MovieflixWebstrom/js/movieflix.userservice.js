/**
 * Created by lanki on 10/1/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('UserService',UserService);

    UserService.$inject = ['$http'];
    function UserService($http){
        var usrservice = this;
        usrservice.createUser = createUser;

        function createUser(user,callback,errorCallback){

            console.log(user);

            $http.post('http://localhost:8080/movieflix/users',user)
                .then(function successCallback(response){
                    callback(response);
                }, function error(response){
                    console.log(response.status);
                });

        }
    }
})();