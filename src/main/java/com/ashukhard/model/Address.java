package com.ashukhard.model;

import javax.persistence.*;

import lombok.Data;

/**
 * The entity for address table
 * 
 * @author ashutosh
 */
@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@Column
	private AddressType type;

}
