package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET , value="{id}")
	public User findOne(@PathVariable("id") String id){
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User objUser){
		return service.create(objUser);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="{id}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String id, @RequestBody User objUser){
		return service.update(id,objUser);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value="{id}")
	public void delete(@PathVariable("id") String id){
		service.remove(id);
		
	}

}
