package com.msat.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msat.dao.UserDAO;
import com.msat.vo.UserVO;

@Service("customUserDetailsService")
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	protected static Logger logger = Logger
			.getLogger("CustomUserDetailsService");

	@Autowired
	private UserDAO userDAO;
	
	// @Autowired
	// private LoginDetailHandler loginDetailHandler;

	/**
	 * Retrieves a user record containing the user's credentials and access.
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// Declare a null Spring User
		UserDetails user = null;

		try {

			UserVO userVO = getUserDAO().fetchUserDetails(username);

			// Populate the Spring User object with details from the dbUser
			// Here we just pass the username, password, and access level
			// getAuthorities() will translate the access level to the correct
			// role type

			user = new User(userVO.getStrLoginName(), userVO.getStrUserPwd()
					.toLowerCase(), true, true, true, true,
					getAuthorities(userVO.getStrUserRole()));
			// LoginDetail loginDetail = new LoginDetail();
			// loginDetail.setValue(username);
			// loginDetailHandler.setLoginBean(loginDetail);
			

		} catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("No user with username '"
					+ username + "' found!");
		} catch (Exception e) {
			logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("No user with username '"
					+ username + "' found!");
		}

		// Return user to Spring for processing.
		// Take note we're not the one evaluating whether this user is
		// authenticated or valid
		// We just merely retrieve a user that matches the specified username
		return user;
	}

	/**
	 * Retrieves the correct ROLE type depending on the access level, where
	 * access level is an Integer. Basically, this interprets the access value
	 * whether it's for a regular user or admin.
	 * 
	 * @param access
	 *            an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	public Collection<GrantedAuthority> getAuthorities(String access) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// All users are granted with ROLE_USER access
		// Therefore this user gets a ROLE_USER by default
		logger.debug("Grant ROLE_USER to this user");
		authList.add(new GrantedAuthorityImpl("ROLE_USER"));

		// Check if this user has admin access
		// We interpret Integer(1) as an admin user
		if ("ROLE_ADMIN".equals(access)) {
			// User has admin access
			logger.debug("Grant ROLE_ADMIN to this user");
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			authList.add(new GrantedAuthorityImpl("ROLE_USER"));
		}

		// Return list of granted authorities
		return authList;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
