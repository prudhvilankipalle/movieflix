package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.movieflix.entity.MovieList;
import io.egen.movieflix.exception.EntityAlreadyExistException;
import io.egen.movieflix.exception.EntityNotFoundException;
import io.egen.movieflix.repository.MovieListRepository;

@Service
public class MovieListServiceImp implements MovieListService{

	@Autowired
	private MovieListRepository movielistrepo;
	
	@Override
	public List<MovieList> findAll() {
		return movielistrepo.findAll();
	}

	@Override
	public MovieList findOne(String title) {
		MovieList objML = movielistrepo.findOne(title);
		if(objML == null)
		{
			throw new EntityNotFoundException("Title not Found");
		}
		return objML;
	}

	@Transactional
	@Override
	public MovieList create(MovieList objMovieList) {
		MovieList existingTitle = movielistrepo.findByTitle(objMovieList.getTitle());
		if(existingTitle != null)
		{
			throw new EntityAlreadyExistException("Title already exists");
		}
		return movielistrepo.create(objMovieList);
	}

	@Transactional
	@Override
	public MovieList update(String title, MovieList objMovieList) {
		MovieList existingTitle = movielistrepo.findOne(title);
		if(existingTitle == null)
		{
			throw new EntityNotFoundException("Title not Found");
		}
		return movielistrepo.update(objMovieList);
	}

	@Transactional
	@Override
	public void remove(String title) {
		MovieList existingTitle = movielistrepo.findOne(title);
		if(existingTitle == null)
		{
			throw new EntityNotFoundException("Title not Found");
		}
		movielistrepo.delete(existingTitle);
	}

	@Override
	public List<MovieList> findMoviesAndSerials(String type) {
		return movielistrepo.findMoviesAndSerials(type);
	}

	@Override
	public List<MovieList> sortImdbRatings(String type) {
		return movielistrepo.sortImdbRatings(type);
	}

	@Override
	public List<MovieList> sortYear(String type) {
		return movielistrepo.sortYear(type);
	}

	@Override
	public List<MovieList> sortImdbVotes(String type) {
		return movielistrepo.sortImdbVotes(type);
	}

	@Override
	public List<MovieList> topRated() {
		return movielistrepo.topRated();
	}
	
	@Override
	public List<MovieList> topVoted() {
		return movielistrepo.topVoted();
	}
	
	@Override
	public List<MovieList> latest() {
		return movielistrepo.latest();
	}

	@Override
	public List<MovieList> searchType(String type, String title) {
		return movielistrepo.searchType(type,title);
	}

	@Override
	public List<MovieList> searchYear(String year, String title) {
		return movielistrepo.searchYear(year,title);
	}

	@Override
	public List<MovieList> searchGenre(String genre, String title) {
		return movielistrepo.searchGenre(genre,title);
	}
}
