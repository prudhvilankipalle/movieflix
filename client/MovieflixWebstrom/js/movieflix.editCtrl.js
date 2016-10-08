/**
 * Created by lanki on 10/7/2016.
 */
(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('editMovieController',editMovieController);

    editMovieController.$inject = ['movieflixService','$rootScope','$location','$routeParams','$scope'];
    function editMovieController(movieflixService,$rootScope,$location,$routeParams,$scope) {
       /* var editCtrl = this;*/
        $scope.movieedit = movieedit;

        $scope.movie = movieflixService.findMoviesByIndex()[parseInt($routeParams.editmovienumber)];

        console.log($scope.movie);

        function movieedit() {

        }

    }
})();