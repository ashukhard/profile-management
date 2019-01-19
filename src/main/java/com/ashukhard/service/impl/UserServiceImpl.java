package com.ashukhard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashukhard.dao.UserDao;
import com.ashukhard.dto.UserDTO;
import com.ashukhard.model.User;
import com.ashukhard.service.UserService;

/**
 * See {@link UserService}
 * 
 * @author ashutosh
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	private ModelMapper modelMapper;
	 
	public UserDTO get(String username) {
		//TODO add null check/Error Handling
		return modelMapper.map(userDao.findByUsername(username), UserDTO.class);
	}

	public UserDTO getById(Long id) {
		return modelMapper.map(userDao.findById(id).get(), UserDTO.class);
	}
	
	public List<UserDTO> findAll() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		userDao.findAll().forEach( user -> {
			list.add(modelMapper.map(user, UserDTO.class));
		});
		return list;
	}

	public void save(UserDTO userDTO) {
		User newUser = modelMapper.map(userDTO, User.class);
	    newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        userDao.save(newUser);
	}

	public UserDTO update(UserDTO userDTO) {
		// TODO add implementation
		return null;
	}
	
	public void delete(long id) {
		userDao.deleteById(id);
	}
}
