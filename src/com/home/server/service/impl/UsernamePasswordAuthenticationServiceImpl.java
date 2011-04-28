package com.home.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.home.server.service.UsernamePasswordAuthenticationService;

public class UsernamePasswordAuthenticationServiceImpl implements UsernamePasswordAuthenticationService {

	private DataSource dataSource;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		String sql = "SELECT * from users where username like :username";
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("username", username);
		
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("username", username);
		
		SimpleJdbcTemplate sjt = new SimpleJdbcTemplate( getDataSource() );
		//User user = sjt.queryForObject(sql, new UserMapper(), source);
		
		User user = sjt.queryForObject(sql, new UserMapper(), parameters);
        return user;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(boolean isAdmin) {
		Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));
        if (isAdmin) {
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }
        return authList;
    }
	
	
	private class UserMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			return new User(rs.getString("username"), rs.getString("password"), true, true, true, true, getAuthorities(true));
		}
	}
}
