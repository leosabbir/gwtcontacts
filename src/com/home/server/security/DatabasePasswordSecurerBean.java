/**
 * 
 */
package com.home.server.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class DatabasePasswordSecurerBean extends JdbcDaoSupport {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsService userDetailsService;
	
	public void secureDatabase() {
		getJdbcTemplate().query("select username, password from users", new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String username = rs.getString(1);
				String password = rs.getString(2);
				// Ch 4 Salt Exercise
				UserDetails user = userDetailsService.loadUserByUsername(username);
				//String encodedPassword = passwordEncoder.encodePassword(password, saltSource.getSalt(user));
				String encodedPassword = passwordEncoder.encodePassword(password, null);
				getJdbcTemplate().update("update users set password = ? where username = ?", 
						encodedPassword, 
						username);
				logger.debug("Updating password for username: "+username+" to: "+encodedPassword);
			}			
		});
	}
}
