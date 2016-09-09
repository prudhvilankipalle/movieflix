package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.User;

@Repository
public class UserRepositaryImp implements UserRepositary{

	@PersistenceContext
	private EntityManager objEm;
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = objEm.createNamedQuery("User.FindAll",User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		return objEm.find(User.class,id);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = objEm.createNamedQuery("User.FindByEmail",User.class);
		query.setParameter("pEmail", email);
		List<User> userByEmail = query.getResultList();
		if(userByEmail.size() == 1){
			return userByEmail.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	public User create(User objUser) {
		objEm.persist(objUser);
		return objUser;
	}

	@Override
	public User update(User objUser) {
		return objEm.merge(objUser);
	}

	@Override
	public void delete(User existingUser) {
		objEm.remove(existingUser);
	}

}
