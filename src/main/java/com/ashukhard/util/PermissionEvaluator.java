package com.ashukhard.util;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashukhard.dao.UserDao;
import com.ashukhard.model.User;

/**
 * This is the permission evaluation for users
 * 
 * @author ashutosh
 */
@Component
public class PermissionEvaluator {
	
	@Autowired
	private UserDao userDao;
	
	public boolean hasPermission(HttpServletRequest request, Long requestedId) {
		boolean permission = true;
		Principal principal = request.getUserPrincipal();
		if (!request.isUserInRole(Constants.ROLE_ADMIN)) {
			User user = userDao.findByUsername(principal.getName());
			// No need for null as authenticated
			if (user.getId() != requestedId)
				permission = false;
		}
		return permission;
	}
	
}
