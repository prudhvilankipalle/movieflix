package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.MovieList;
import io.egen.movieflix.entity.UserRatings;

public interface UserRatingService {

	public List<UserRatings> findAll();

	public List<UserRatings> findOne(String title);

	public UserRatings create(String title,String id, UserRatings objUR);

	public UserRatings update(String title, UserRatings objUR);

	public void remove(String title);

}
