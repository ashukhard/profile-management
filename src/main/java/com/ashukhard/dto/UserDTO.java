package com.ashukhard.dto;

import java.util.Date;
import java.util.Set;

import lombok.Data;

import com.ashukhard.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private String dateOfBirth;
	
	@JsonIgnore
	private Date birthdate;

	private Set<RoleDTO> roles;

	private Set<AddressDTO> address;
	
	public Date getBirthdate() {
		//TODO return the formated date of String dateOfBirth
		if (birthdate == null && dateOfBirth != null)
			return new Date();
		else 
			return this.birthdate;
	}
	
	public String getDateOfBirth() {
		//TODO return the formated date of Date birthdate
		if (dateOfBirth == null && birthdate != null)
			return new String();
		else 
			return this.dateOfBirth;
	}
}
