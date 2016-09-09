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

}
