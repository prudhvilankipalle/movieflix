/**
 * Created by lanki on 10/5/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('ReviewService',ReviewService);

    ReviewService.$inject = ['$http','$rootScope'];
    function ReviewService($http,$rootScope){
        var obj = this;
        obj.submitReview = submitReview;

        function submitReview(review,callback){

            console.log(review);

            $http.post('http://localhost:8080/movieflix/movielist/'+ $rootScope.globals.currentUser.id +'/' + $rootScope.selectedMovie.title + '/userratings',review)
                .then(function successCallback(response){
                    $rootScope.selectedMovieRatings.ur.push(response.data);
                    callback(response);
                }, function error(response){
                    console.log(response.status);
                });

        }
    }
})();

