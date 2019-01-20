package com.ashukhard.model;

import javax.persistence.*;

import lombok.Data;

/**
 * The entity for roles table
 * 
 * @author ashutosh
 */
@Entity
@Data
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

}
