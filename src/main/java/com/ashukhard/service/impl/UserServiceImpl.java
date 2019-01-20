package com.ashukhard.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashukhard.dao.RoleDao;
import com.ashukhard.dao.UserDao;
import com.ashukhard.dto.UserDTO;
import com.ashukhard.dto.UserPasswordDTO;
import com.ashukhard.model.Role;
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
	private RoleDao roleDao;

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

	public void save(UserPasswordDTO userPasswordDTO) {
		User newUser = modelMapper.map(userPasswordDTO, User.class);
		newUser.setId(null);
	    newUser.setPassword(bcryptEncoder.encode(userPasswordDTO.getPassword()));
	    Set<Role> roles = new HashSet<Role>();
	    userPasswordDTO.getRoles().forEach( roleDTO -> {
	    	roles.add(roleDao.findById(roleDTO.getId()).get());
	    });
	    newUser.setRoles(roles);
	    newUser.getAddress().forEach(address -> {
	    	address.setId(null);
	    });
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
