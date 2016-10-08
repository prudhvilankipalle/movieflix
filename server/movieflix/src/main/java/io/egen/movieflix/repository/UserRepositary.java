package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.User;

public interface UserRepositary {

	public List<User> findAll();

	public User findOne(String email);

	public User findByEmail(String email);

	public User create(User objUser);

	public User update(User objUser);

	public void delete(User existingUser);

}
