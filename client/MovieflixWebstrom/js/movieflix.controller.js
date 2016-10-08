/**
 * Created by lanki on 9/21/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('mainController',mainController);

    mainController.$inject = ['movieflixService','$rootScope','$location'];
    function mainController(movieflixService,$rootScope,$location,$routeParams) {
        var ctrlObj = this;
        ctrlObj.log = log;
        ctrlObj.showmore = showmore;
        ctrlObj.deleteMovie = deleteMovie;
        ctrlObj.addMovie = addMovie;
        ctrlObj.editMovie = editMovie;
        ctrlObj.signOut = signOut;

        init();

        function init(){
            movieflixService.findMovies(function (data){
                ctrlObj.movielist = data;
                angular.forEach(ctrlObj.movielist,function (movies) {
                    movies.imdbRating = parseFloat(movies.imdbRating);
                    movies.imdbVotes = parseFloat(movies.imdbVotes);
                })
            });
        }

        function showmore(movienumber) {
            console.log(movienumber);
            $rootScope.remainingMovies = {
                movielist : ctrlObj.filteredlist
            }
            console.log($rootScope.remainingMovies.movielist);
            $location.path('/showmore/' + movienumber);
        }

        function editMovie(editmovienumber) {
            console.log(editmovienumber);
            $rootScope.remainingMovies = {
                movielist : ctrlObj.filteredlist
            }
            console.log($rootScope.remainingMovies.movielist);
            $location.path('/editmovie/' + editmovienumber);
        }
        function deleteMovie(movienumber) {
            $rootScope.remainingMovies = {
                movielist : ctrlObj.filteredlist
            }
            ctrlObj.movietobeDeleted = movieflixService.findMoviesByIndex()[parseInt(movienumber)];
            var title = ctrlObj.movietobeDeleted.title;
            $rootScope.movietobeDeletedUR = {
                ur : ctrlObj.movietobeDeleted.ur
            }
            console.log($rootScope.movietobeDeletedUR.ur.length);
            movieflixService.deleteMovies(title);
        }

        function signOut() {
            $rootScope.adminLoggedIn = false;
            $rootScope.userLoggedIn = false;
            $location.path('/');
        }

        function addMovie() {
            console.log('addmovie');
            $location.path('/addmovie');
        }
        function log() {
            console.log('logging it');
        }
        
    }
})();