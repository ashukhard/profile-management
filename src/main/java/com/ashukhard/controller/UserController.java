package com.ashukhard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashukhard.config.TokenProvider;
import com.ashukhard.dto.LoginDTO;
import com.ashukhard.dto.UserDTO;
import com.ashukhard.dto.UserPasswordDTO;
import com.ashukhard.model.AuthToken;
import com.ashukhard.service.UserService;

/**
 * Controller for User services
 * 
 * @author ashutosh
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenProvider jwtTokenUtil;
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody LoginDTO loginDTO) throws AuthenticationException {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
		return ResponseEntity.ok(new AuthToken(token));
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public UserDTO get(@PathVariable(value = "id") Long id) {
		// TODO add check that the user authenticated can get it's own profile only
		return userService.getById(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
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
	
	@PreAuthorize("hasRole('ADMIN')")
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
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable(value = "id") Long id) {
		try {
			// TODO add check that the user authenticated can delete it's own profile only
			userService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.OK;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDTO> listUser() {
		return userService.findAll();
	}

}
