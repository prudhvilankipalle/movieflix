/**
 * Created by lanki on 9/23/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('movieflixService',movieflixService);

    movieflixService.$inject = ['$http','$rootScope'];
    function movieflixService($http,$rootScope){
            var movieflix = this;
        movieflix.findMovies = getMovies;
        movieflix.addMovies = addMovies;
        movieflix.deleteMovies = deleteMovies;
        movieflix.findMoviesByIndex = findMoviesByIndex;
        movieflix.getReviews = getReviews;
        var moviedata;

        function getMovies(callback,errorCallback){

            $http.get('http://localhost:8080/movieflix/movielist')
                .then(function (response){
                    moviedata = response.data;
                    callback(moviedata);
                console.log(moviedata);
            }, function (error){
                errorCallback(error.status);
                console.log(error.status);
                });

        }
        function addMovies(movie,callback){
            $http.post('http://localhost:8080/movieflix/movielist',movie)
                .then(function successCallback(response){
                    callback(response);
                }, function error(response){
                    console.log(response.status);
                });
        }

        function deleteMovies(title,callback,errorCallback) {
            if($rootScope.movietobeDeletedUR.ur.length > 0){
                for(var i =0; i < $rootScope.movietobeDeletedUR.ur.length ; i++){
                    $http.delete('http://localhost:8080/movieflix/usersrating/' + title)
                        .then(function (response){
                            moviedata = response.data;
                        }, function (error){
                            errorCallback(error.status);
                            console.log(error.status);
                        });
                }
                $http.delete('http://localhost:8080/movieflix/movielist/' + title)
                    .then(function (response){
                        moviedata = response.data;
                    }, function (error){
                        errorCallback(error.status);
                        console.log(error.status);
                    });
            }
            else{
                $http.delete('http://localhost:8080/movieflix/movielist/' + title)
                    .then(function (response){
                        moviedata = response.data;
                    }, function (error){
                        errorCallback(error.status);
                        console.log(error.status);
                    });
            }

        }

        function findMoviesByIndex() {
            return $rootScope.remainingMovies.movielist;
        }

        function getReviews(title,callback,errorCallback) {
            $http.get('http://localhost:8080/movieflix/usersrating/' + title)
                .then(function (response){
                    moviedata = response.data;
                    callback(moviedata);
                }, function (error){
                    errorCallback(error.status);
                    console.log(error.status);
                });
        }
    }
})();
