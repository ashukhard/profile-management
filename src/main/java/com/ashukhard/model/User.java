package com.ashukhard.model;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import lombok.Data;

/**
 * Entity class for user table
 * 
 * @author ashutosh
 */
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private Date birthdate;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") },
		inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	private Set<Role> roles;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ADDRESS", joinColumns = { @JoinColumn(name = "USER_ID") },
		inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
	private Set<Address> address;
}
