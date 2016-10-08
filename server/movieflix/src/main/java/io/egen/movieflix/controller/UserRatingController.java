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
import io.egen.movieflix.service.UserRatingService;

@RestController
@RequestMapping(value = "/usersrating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserRatingController {
	
	@Autowired
	private UserRatingService service;
	//private URService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserRatings> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET , value="{title}")
	public List<UserRatings> findOne(@PathVariable("title") String title){
		return service.findOne(title);
	}
	
	/*@RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRatings create(@RequestBody UserRatings objUR){
		return service.create(,objUR);
	}*/
	
	@RequestMapping(method = RequestMethod.PUT , value="{title}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRatings update(@PathVariable("title") String title, @RequestBody UserRatings objUR){
		return service.update(title,objUR);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value="{title}")
	public void delete(@PathVariable("title") String title){
		service.remove(title);
		
	}

}
