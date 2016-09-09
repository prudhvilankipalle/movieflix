package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.MovieList;

@Repository
//@Transactional
public class MovieListRepoImp implements MovieListRepository {

	@PersistenceContext
	private EntityManager objEm;
	
	@Override
	public List<MovieList> findAll() {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.FindAll",MovieList.class);
		return query.getResultList();
	}

	@Override
	public MovieList findOne(String title) {
		return objEm.find(MovieList.class,title);
	}

	@Override
	public MovieList findByTitle(String title) {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.FindByTitle",MovieList.class);
		query.setParameter("mlTitle", title);
		List<MovieList> awardsByTitle = query.getResultList();
		if(awardsByTitle.size() == 1){
			return awardsByTitle.get(0);
		}
		else{
			return null;
		}
	}

	@Override
	public MovieList create(MovieList objMovieList) {
		objEm.persist(objMovieList);
		return objMovieList;
	}

	@Override
	public MovieList update(MovieList objMovieList) {
		return objEm.merge(objMovieList);
	}

	@Override
	public void delete(MovieList existingTitle) {
		objEm.remove(existingTitle);
	}
}
