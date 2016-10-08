/**
 * Created by lanki on 10/5/2016.
 */
/**
 * Created by lanki on 9/21/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('showmoreController',showmoreController);

    showmoreController.$inject = ['movieflixService','$rootScope','$routeParams','ReviewService','$window','$location'];
    function showmoreController(movieflixService,$rootScope,$routeParams,ReviewService,$window,$location) {
        var smCtrl = this;
        smCtrl.reviewSubmit = reviewSubmit;
        smCtrl.backbutton = backbutton;
        smCtrl.signOut = signOut;

        init();

        function init(){
            smCtrl.selectedMovie = movieflixService.findMoviesByIndex()[parseInt($routeParams.movienumber)];
            $rootScope.selectedMovie ={
                ur: smCtrl.selectedMovie.ur,
                title : smCtrl.selectedMovie.title,
                imdbid:smCtrl.selectedMovie.imdbID
            }

            smCtrl.link = "http://www.imdb.com/title/" + $rootScope.selectedMovie.imdbid + "/?ref_=nv_sr_1"
            movieflixService.getReviews($rootScope.selectedMovie.title,function (data) {
                smCtrl.selectedMovieRatings = data;
                $rootScope.selectedMovieRatings = {
                    ur : smCtrl.selectedMovieRatings
                }
                console.log($rootScope.selectedMovieRatings.ur.length);
            })
        }

        function signOut() {
            $rootScope.userLoggedIn = false;
            $location.path('/');
        }
        function backbutton() {
            $window.history.back();
        }
        function reviewSubmit() {
            var review = '{' + '"userreview":' +'"'+ smCtrl.review + '"' + '}';
            console.log($rootScope.selectedMovie.ur);
            ReviewService.submitReview(review,function (data) {
                smCtrl.currentReview = data.data;
                console.log($rootScope.selectedMovie.ur);
            });
            smCtrl.review = '';
        }
    }
})();