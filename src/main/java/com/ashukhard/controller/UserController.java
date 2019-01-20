package com.ashukhard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashukhard.dto.UserDTO;
import com.ashukhard.dto.UserPasswordDTO;
import com.ashukhard.service.UserService;

/**
 * Controller for User services
 * 
 * @author ashutosh
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDTO> listUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public UserDTO get(@PathVariable(value = "id") Long id) {
		return userService.getById(id);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public HttpStatus post(@RequestBody UserPasswordDTO userPasswordDTO) {
		try {
			userService.save(userPasswordDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.OK;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public HttpStatus update(@PathVariable(value = "id") Long id, @RequestBody UserDTO userDTO) {
		try {
			userService.update(userDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.OK;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable(value = "id") Long id) {
		try {
			userService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.OK;
	}

}
