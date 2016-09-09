package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.MovieList;
import io.egen.movieflix.entity.UserRatings;

public interface UserRatingRepositary {

	public List<UserRatings> findAll();

	public UserRatings findOne(String title);

	public UserRatings findByTitle(MovieList title);

	public UserRatings update(UserRatings objUR);

	public UserRatings create(UserRatings objUR);

	public void delete(UserRatings existingTitle);

}
