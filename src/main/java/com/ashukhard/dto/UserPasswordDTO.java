package com.ashukhard.dto;

import lombok.Getter;
import lombok.Setter;

import com.ashukhard.model.User;

/**
 * DTO class for {@link User}
 * 
 * @author ashutosh
 */
@Getter@Setter
public class UserPasswordDTO extends UserDTO{

	private String password;
}
