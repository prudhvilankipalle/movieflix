package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.MovieList;

public interface MovieListService {

	public List<MovieList> findAll();

	public MovieList findOne(String title);

	public MovieList create(MovieList objMovieList);

	public MovieList update(String title, MovieList objMovieList);

	public void remove(String title);

	public List<MovieList> findMoviesAndSerials(String type);

	public List<MovieList> sortImdbRatings(String type);

	public List<MovieList> sortYear(String type);

	public List<MovieList> sortImdbVotes(String type);

	public List<MovieList> topRated();

	public List<MovieList> topVoted();

	public List<MovieList> latest();

	public List<MovieList> searchType(String type, String title);

	public List<MovieList> searchYear(String year, String title);

	public List<MovieList> searchGenre(String genre, String title); 

}
