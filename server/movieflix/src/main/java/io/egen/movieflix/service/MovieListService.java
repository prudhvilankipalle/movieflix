package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.MovieList;

public interface MovieListService {

	public List<MovieList> findAll();

	public MovieList findOne(String title);

	public MovieList create(MovieList objMovieList);

	public MovieList update(String title, MovieList objMovieList);

	public void remove(String title);

}
