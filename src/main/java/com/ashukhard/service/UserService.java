package com.ashukhard.service;

import com.ashukhard.dto.UserDTO;
import com.ashukhard.model.User;

import java.util.List;

/**
 * Service class for {@link User}
 * 
 * @author ashutosh
 */
public interface UserService {

	/**
	 * Get a UserDTO by User.username
	 * 
	 * @param username: String username of a user
	 * @return UserDTO: UserDTO
	 */
	UserDTO get(String username);

	/**
	 * Get a UserDTO by User.id
	 * 
	 * @param id: Long User.id
	 * @return UserDTO: UserDTO
	 */
	UserDTO getById(Long id);

	/**
	 * Get a list of all UserDTO
	 * 
	 * @return ArrayList of UserDTO
	 */
	List<UserDTO> findAll();

	/**
	 * Save a user
	 * 
	 * @param userDTO: DTO of user to be saved
	 * @return UserDTO: UserDTO
	 */
	void save(UserDTO userDTO);
	
	/**
	 * Update a user data
	 * 
	 * @param userDTO: DTO of user to be updated
	 * @return UserDTO: UserDTO
	 */
	UserDTO update(UserDTO userDTO);

	/**
	 * Delete a user by id
	 * 
	 * @param id: Long id of a user to be deleted
	 */
	void delete(long id);
	
}
