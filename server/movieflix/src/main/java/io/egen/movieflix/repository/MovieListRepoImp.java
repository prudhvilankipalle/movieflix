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
	public MovieList create(MovieList objMovieList) {
		objEm.persist(objMovieList);
		return objMovieList;
	}
	
	@Override
	public List<MovieList> findMoviesAndSerials(String type) {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.FindMoviesAndSerials",MovieList.class);
		query.setParameter("mlType",type);
		return query.getResultList();
	}
	
	@Override
	public List<MovieList> sortImdbRatings(String type) {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.sortImdbRatings",MovieList.class);
		query.setParameter("mlType",type);
		return query.getResultList();
	} 
	
	@Override
	public List<MovieList> sortYear(String type) {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.sortYear",MovieList.class);
		query.setParameter("mlType",type);
		return query.getResultList();
	}
	
	@Override
	public List<MovieList> sortImdbVotes(String type) {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.sortImdbVotes",MovieList.class);
		query.setParameter("mlType",type);
		return query.getResultList();
	}
	
	@Override
	public List<MovieList> topRated() {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.TopRated",MovieList.class);
		return query.getResultList();
	}
	
	@Override
	public List<MovieList> topVoted() {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.TopVoted",MovieList.class);
		return query.getResultList();
	}
	
	@Override
	public List<MovieList> latest() {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.Latest",MovieList.class);
		return query.getResultList();
	}
	
	@Override
	public List<MovieList> searchType(String type, String title) {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.SearchType",MovieList.class);
		query.setParameter("mlTitle", title);
		query.setParameter("mlType",type);
		return query.getResultList();
	}

	@Override
	public List<MovieList> searchYear(String year, String title) {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.SearchYear",MovieList.class);
		query.setParameter("mlTitle", title);
		query.setParameter("mlYear",year);
		return query.getResultList();
	}

	@Override
	public List<MovieList> searchGenre(String genre, String title) {
		TypedQuery<MovieList> query = objEm.createNamedQuery("MovieList.SearchGenre",MovieList.class);
		query.setParameter("mlGenre",genre);
		query.setParameter("mlTitle", title);
		return query.getResultList();
	}
	/*-------------------------------------------------------------------------------------------*/
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
	public MovieList update(MovieList objMovieList) {
		return objEm.merge(objMovieList);
	}

	@Override
	public void delete(MovieList existingTitle) {
		objEm.remove(existingTitle);
	}
	
}
