package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.MovieList;
import io.egen.movieflix.entity.UserRatings;
import io.egen.movieflix.service.MovieListService;
import io.egen.movieflix.service.UserRatingService;

@RestController
@RequestMapping(value = "/movielist", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieListController {
	@Autowired
	private MovieListService service;
	
	@Autowired
	private UserRatingService uRService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MovieList> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET , value="{title}")
	public MovieList findOne(@PathVariable("title") String title){
		return service.findOne(title);
	}
	
	@RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieList create(@RequestBody MovieList objMovieList){
		return service.create(objMovieList);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="{title}/userratings",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRatings create(@PathVariable("title") String title,@RequestBody UserRatings objUR){
		//MovieList objURCreation = new MovieList();
		return uRService.create(title,objUR);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="{title}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieList update(@PathVariable("title") String title, @RequestBody MovieList objMovieList){
		return service.update(title,objMovieList);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value="{title}")
	public void delete(@PathVariable("title") String title){
		service.remove(title);
		
	}

}
