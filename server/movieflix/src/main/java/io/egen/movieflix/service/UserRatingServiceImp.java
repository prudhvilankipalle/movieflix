package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.MovieList;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.entity.UserRatings;
import io.egen.movieflix.exception.EntityAlreadyExistException;
import io.egen.movieflix.exception.EntityNotFoundException;
import io.egen.movieflix.repository.MovieListRepository;
import io.egen.movieflix.repository.UserRatingRepositary;
import io.egen.movieflix.repository.UserRepositary;

@Service
public class UserRatingServiceImp implements UserRatingService{
	@Autowired
	private UserRatingRepositary userRrepo;
	
	@Autowired
	private MovieListRepository mLRepo;
	
	@Autowired 
	private UserRepositary uRepo;
	
	@Override
	public List<UserRatings> findAll() {
		return userRrepo.findAll();
	}

	@Override
	public UserRatings findOne(String title) {
		UserRatings existingTitle = userRrepo.findOne(title);
		if(existingTitle== null)
		{
			throw new EntityNotFoundException("Title not Found");
		}
		return existingTitle;
	}

	@Transactional
	@Override
	public UserRatings create(String id, String title,UserRatings objUR) {
		User objUsr = uRepo.findOne(id);
		MovieList objURCreation = mLRepo.findByTitle(title);
		objUR.setTitle(objURCreation);
		objUR.setUser(objUsr);
		/*UserRatings existingTitle = userRrepo.findByTitle(objUR.getTitle());
		if(existingTitle != null)
		{
			throw new EntityAlreadyExistException("Tile already exists");
		}*/
		return userRrepo.create(objUR); 
	}

	@Transactional
	@Override
	public UserRatings update(String title, UserRatings objUR) {
		UserRatings existingTitle = userRrepo.findOne(title);
		if(existingTitle== null)
		{
			throw new EntityNotFoundException("Title not Found");
		}
		return userRrepo.update(objUR);
	}

	@Transactional
	@Override
	public void remove(String title) {
		UserRatings existingTitle = userRrepo.findOne(title);
		if(existingTitle == null)
		{
			throw new EntityNotFoundException("Title not Found");
		}
		userRrepo.delete(existingTitle);
	}

}
