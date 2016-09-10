package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.MovieList;
import io.egen.movieflix.entity.UserRatings;

@Repository
//@Transactional
public class UserRatingsRepoImp implements UserRatingRepositary{
	
	@PersistenceContext
	private EntityManager objEm;
	
	@Override
	public List<UserRatings> findAll() {
		TypedQuery<UserRatings> query = objEm.createNamedQuery("UserRatings.FindAll",UserRatings.class);
		return query.getResultList();
	}

	@Override
	public UserRatings findOne(String title) {
		return objEm.find(UserRatings.class,title);
	}

	@Override
	public UserRatings findByTitle(String title) {
		TypedQuery<UserRatings> query = objEm.createNamedQuery("UserRatings.FindByTitle",UserRatings.class);
		query.setParameter("pTitle", title);
		List<UserRatings> userByTitle = query.getResultList();
		if(userByTitle.size() == 1){
			return userByTitle.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	public UserRatings create(UserRatings objUR) {
		objEm.persist(objUR);
		return objUR;
	}

	@Override
	public UserRatings update(UserRatings objUR) {
		return objEm.merge(objUR);
	}

	@Override
	public void delete(UserRatings existingTitle) {
		objEm.remove(existingTitle);
	}

}
