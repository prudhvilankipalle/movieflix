/**
 * Created by lanki on 9/20/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix',['angularUtils.directives.dirPagination','ngAnimate','ngRoute','ngResource','ngCookies'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {

/*
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
*/

        $routeProvider
            //Login
            .when("/", {templateUrl: "templates/login.html", controller: "loginController"})
            .when("/tologin", {templateUrl: "templates/login.html", controller: "loginController"})
            //Register
            .when("/toregister", {templateUrl: "templates/registration.html", controller: "registerController"})

            // Admin
            .when("/adminpopular", {resolve:{
                "check":function ($location,$rootScope) {
                    if(!$rootScope.adminLoggedIn){
                        $location.path('/');
                    }
                }
            },templateUrl: "templates/adminpopular.html", controller: "mainController"})
            .when("/addmovie",{templateUrl: "templates/addmovies.html", controller: "addMovieController"})
            .when("/editmovie/:editmovienumber",{templateUrl: "templates/addmovies.html", controller: "editMovieController"})
            .when("/homepage/admin", {
                resolve:{
                    "check":function ($location,$rootScope) {
                        if(!$rootScope.adminLoggedIn){
                            $location.path('/');
                        }
                    }
                },templateUrl: "templates/adminpopular.html", controller: "mainController"})
            // Home
            .when("/homepage", {
                resolve:{
                    "check":function ($location,$rootScope) {
                        if(!$rootScope.userLoggedIn){
                            $location.path('/');
                        }
                    }
                },templateUrl: "templates/homepage.html", controller: "mainController"})
            // Pages
            .when("/popular", {resolve:{
                "check":function ($location,$rootScope) {
                    if(!$rootScope.userLoggedIn){
                        $location.path('/');
                    }
                }
            },templateUrl: "templates/homepage.html", controller: "mainController"})
            .when("/movies", {resolve:{
                "check":function ($location,$rootScope) {
                    if(!$rootScope.userLoggedIn){
                        $location.path('/');
                    }
                }
            },templateUrl: "templates/movies.html", controller: "mainController"})
            .when("/tvseries", {resolve:{
                "check":function ($location,$rootScope) {
                    if(!$rootScope.userLoggedIn){
                        $location.path('/');
                    }
                }
            },templateUrl: "templates/tvseries.html", controller: "mainController"})
            .when("/contact", {resolve:{
                "check":function ($location,$rootScope) {
                    if(!$rootScope.userLoggedIn){
                        $location.path('/');
                    }
                }
            },templateUrl: "templates/contact.html", controller: "mainController"})
            .when("/showmore/:movienumber", {resolve:{
                "check":function ($location,$rootScope) {
                    if(!$rootScope.userLoggedIn){
                        $location.path('/');
                    }
                }
            },templateUrl: "templates/showmore.html", controller: "showmoreController"})
            // else 404
            .otherwise({
                redirectTo: "/adminpopular"
            });
    }
})();
