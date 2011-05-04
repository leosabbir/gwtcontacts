package com.home.server.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.home.server.dao.impl.UserDao;
import com.home.server.entities.UserDetails;
import com.home.server.service.UserDetailsService;

public class UserDetailsServiceImpl extends JdbcDaoImpl implements UserDetailsService {
	UserDao userDao;
	
	@Override  
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {  
//        UserDetails user = userDao.findUserByName(username);  
//        if (user != null) {  
//  
//            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
//            authorities.add(new GrantedAuthorityImpl("ROLE_USER"));  
//  
//            return new UserDetails(user.getEmail(), user.getUsername(), user.getPassword(), true, true, true, true,  
//                    authorities);  
//        }  
//  
//        throw new UsernameNotFoundException(  
//                messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} not found"), username);  
		return null;
    }  
  
    public void setUserDao(UserDao userDao) {  
        this.userDao = userDao;  
    }  
}
