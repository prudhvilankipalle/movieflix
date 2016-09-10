package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.MovieList;

public interface MovieListRepository {


	public List<MovieList> findAll();

	public MovieList findOne(String title);

	public MovieList findByTitle(String title);

	public MovieList create(MovieList objMovieList);

	public MovieList update(MovieList objMovieList);

	public void delete(MovieList existingTitle);

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
