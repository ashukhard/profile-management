package com.ashukhard.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashukhard.model.Role;

/**
 * DAO class for {@link Role}. Refer to {@link CrudRepository} for CRUD methods implementation
 * 
 * @author ashutosh
 */
@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
	
}
