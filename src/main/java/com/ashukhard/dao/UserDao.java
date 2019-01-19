package com.ashukhard.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashukhard.model.User;

/**
 * DAO class for {@link User}. Refer to {@link CrudRepository} for CRUD methods implementation
 * 
 * @author ashutosh
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	/**
	 * Get User by username
	 * 
	 * @param username: String username of a user
	 * @return User: User
	 */
	User findByUsername(String username);
}
