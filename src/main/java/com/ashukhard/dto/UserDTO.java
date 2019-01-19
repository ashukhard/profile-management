package com.ashukhard.dto;

import java.util.Date;
import java.util.Set;

import lombok.Data;

import com.ashukhard.model.User;

/**
 * DTO class for {@link User}
 * 
 * @author ashutosh
 */
@Data
public class UserDTO {

	private long id;
	
	private String username;
	
	private String password;
	
	private String firstname;
	
	private String lastname;
	
	private Date birthdate;

	private Set<RoleDTO> roles;

	private Set<AddressDTO> address;
}
