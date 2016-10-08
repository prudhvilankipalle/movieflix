package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.MovieList;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.entity.UserRatings;
import io.egen.movieflix.service.MovieListService;
import io.egen.movieflix.service.UserRatingService;
import io.egen.movieflix.service.UserService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(value = "/movielist", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieListController {
	@Autowired
	private MovieListService service;
	
	@Autowired
	private UserRatingService uRService;
	
	//1
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public List<MovieList> findAll(){
		return service.findAll();
	}
	//2
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="{type}")
	public List<MovieList> findMoviesAndSerials(@PathVariable ("type") String type){
		return service.findMoviesAndSerials(type);
	}
	//3
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieList create(@RequestBody MovieList objMovieList){
		return service.create(objMovieList);
	}
	//4
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="{type}/toprated")
	public List<MovieList> sortImdbRatings(@PathVariable ("type") String type){
		return service.sortImdbRatings(type);
	}
	//5
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="{type}/latest")
	public List<MovieList> sortYear(@PathVariable ("type") String type){
		return service.sortYear(type);
	}
	//6
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="{type}/topvoted")
	public List<MovieList> sortImdbVotes(@PathVariable ("type") String type){
		return service.sortImdbVotes(type);
	}
	//7
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="/toprated")
	public List<MovieList> topRated(){
		return service.topRated();
	}
	//8
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="/topvoted")
	public List<MovieList> topVoted(){
		return service.topVoted();
	}
	//9
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="/latest")
	public List<MovieList> latest(){
		return service.latest();
	}
	//10
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="/searchType/{type}/{title}")
	public List<MovieList> searchType(@PathVariable ("type") String type,@PathVariable ("title") String title){
		return service.searchType(type,title);
	}
	//11
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="/searchYear/{year}/{title}")
	public List<MovieList> searchYear(@PathVariable ("year") String year,@PathVariable ("title") String title){
		return service.searchYear(year,title);
	}
	//12
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="/searchGenre/{genre}/{title}")
	public List<MovieList> searchGenre(@PathVariable ("genre") String genre,@PathVariable ("title") String title){
		return service.searchGenre(genre,title);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/{id}/{title}/userratings",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRatings create(@PathVariable("id") String id, @PathVariable("title") String title,@RequestBody UserRatings objUR){
		return uRService.create(id,title,objUR);
	}
	//13
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT , value="{title}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieList update(@PathVariable("title") String title, @RequestBody MovieList objMovieList){
		return service.update(title,objMovieList);
	}
	/*-------------------------------------------------------------------------------------------*/
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="/findone/{title}")
	public MovieList findOne(@PathVariable("title") String title){
		return service.findOne(title);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value="{title}")
	public void delete(@PathVariable("title") String title) throws InterruptedException{
		service.remove(title);
	}

}
