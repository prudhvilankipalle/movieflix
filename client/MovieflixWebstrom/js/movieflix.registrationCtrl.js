/**
 * Created by lanki on 10/1/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('registerController',registerController);

    registerController.$inject = ['UserService','$location','$rootScope','$scope'];
    function registerController(UserService,$location,$rootScope,$scope) {
        var regCtrl = this;

        regCtrl.register = register;

        function register() {
            /*var user = {
                "firstname" : regCtrl.firstname,
                "lastname" : regCtrl.lastname,
                "email" : regCtrl.email,
                "password" : regCtrl.password,
                "userrole" :"user"
            };*/


            var user = '{' + '"firstname":' +'"'+ regCtrl.firstname + '"' + ',' + '\n' + '"lastname":' + '"' + regCtrl.lastname + '"' + ',' + '\n' + '"email":' + '"' + regCtrl.email + '"' + ',' + '\n' + '"password":' + '"' + regCtrl.password + '"' + ',' + '\n' + '"userrole":' + '"' + 'user' + '"' + '}';


            console.log(user);
            UserService.createUser(user,function (data) {
                    regCtrl.registeredUser = data.data;
                    $location.path('/tologin');
            });

            regCtrl.firstname = '';
            regCtrl.lastname = '';
            regCtrl.email = '';
            regCtrl.password = '';
        }
    }

})();
