/**
 * Created by lanki on 10/7/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('addMovieController',addMovieController);

    addMovieController.$inject = ['movieflixService','$rootScope','$location','$routeParams','ReviewService'];
    function addMovieController(movieflixService,$rootScope,$location,$routeParams,ReviewService) {
        var addCtrl = this;
        addCtrl.movieaddition = movieaddition;

        function movieaddition() {
            var movie = '{' + '"title":' +'"'+ addCtrl.title + '"' + ',' + '\n' + '"year":' + '"' + addCtrl.yearreleased + '"' + ',' + '\n'
                + '"rated":' + '"' + addCtrl.rated + '"' + ',' + '\n' + '"released":' + '"' + addCtrl.releasedate + '"' + ',' + '\n'
                + '"runtime":' + '"' + addCtrl.runtime + '"' + ',' + '\n' + '"genre":' + '"' + addCtrl.genre + '"' + ',' + '\n'
                + '"writer":' + '"' + addCtrl.writer + '"'+ ',' + '\n' + '"director":' + '"' + addCtrl.director + '"' + ',' + '\n'
                + '"actors":' + '"' + addCtrl.actors + '"' + ',' + '\n' + '"plot":' + '"' + addCtrl.plot + '"' + ',' + '\n'
                + '"language":' + '"' + addCtrl.language + '"' + ',' + '\n' + '"country":' + '"' + addCtrl.country + '"' + ',' + '\n'
                + '"awards":' + '"' + addCtrl.awards + '"'+ ',' + '\n' + '"poster":' + '"' + addCtrl.poster + '"' + ',' + '\n'
                + '"metascore":' + '"' + addCtrl.metascore + '"' + ',' + '\n' + '"imdbRating":' + '"' + addCtrl.imdbRating + '"' + ',' + '\n'
                + '"imdbVotes":' + '"' + addCtrl.imdbVotes + '"' + ',' + '\n' + '"imdbID":' + '"' + addCtrl.imdbID + '"' + ',' + '\n' + '"type":' + '"' + addCtrl.type + '"' + '}';

            console.log('In Movie addition');
            console.log(movie);
            movieflixService.addMovies(movie,function (addedMovie) {
                addCtrl.movieAdded = addedMovie.data;
                console.log(addedMovie);
                $location.path('/adminpopular');

            });
        }
    }
})();