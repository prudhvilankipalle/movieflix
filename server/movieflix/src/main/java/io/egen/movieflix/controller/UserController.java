package io.egen.movieflix.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.service.UserService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	@Autowired
	private UserService service;
	
	
	/*@RequestMapping(method = RequestMethod.GET , value="{id}")
	public User findOne(@PathVariable("email") String id){
		return service.findOne(id);
	}*/
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAllUsers(){
		return service.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET , value="/{email}/", headers="Accept=application/json, text/xml")
	public User findByEmail(@PathVariable("email") String email){
		return service.findByEmail(email);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user){
		service.create(user);
		return user;
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT , value="{id}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String id, @RequestBody User objUser){
		return service.update(id,objUser);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE , value="{id}")
	public void delete(@PathVariable("id") String id){
		service.remove(id);
		
	}

}
