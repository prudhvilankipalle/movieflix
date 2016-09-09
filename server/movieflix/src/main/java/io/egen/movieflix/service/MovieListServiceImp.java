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
}
