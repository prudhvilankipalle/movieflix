package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.exception.EntityAlreadyExistException;
import io.egen.movieflix.exception.EntityNotFoundException;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.repository.UserRepositary;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepositary userrepo;
	
	@Override
	public List<User> findAll() {
		return userrepo.findAll();
	}

	@Override
	public User findOne(String email) {
		User objUser = userrepo.findOne(email);
		if(objUser == null)
		{
			throw new EntityNotFoundException("User not Found");
		}
		return objUser;
	}

	@Transactional
	@Override
	public User create(User objUser) {
		User existingUser = userrepo.findByEmail(objUser.getEmail());
		if(existingUser != null)
		{
			throw new EntityAlreadyExistException("User already registered");
		}
		return userrepo.create(objUser);
	}

	@Transactional
	@Override
	public User update(String id, User objUser) {
		User existingUser = userrepo.findOne(id);
		if(existingUser == null)
		{
			throw new EntityNotFoundException("User not Found");
		}
		return userrepo.update(objUser);
	}

	@Transactional
	@Override
	public void remove(String id) {
		User existingUser = userrepo.findOne(id);
		if(existingUser == null)
		{
			throw new EntityNotFoundException("User not Found");
		}
		userrepo.delete(existingUser);
	}

	@Override
	public User findByEmail(String email) {
		User objUser = userrepo.findByEmail(email);
		if(objUser == null)
		{
			throw new EntityNotFoundException("User not Found");
		}
		return objUser;
	}

}
