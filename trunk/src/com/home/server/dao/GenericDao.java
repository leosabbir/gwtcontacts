package com.home.server.dao;

import java.io.Serializable;


public interface GenericDao<T> {
	
	public boolean save(T  entity);
	
	public boolean delete(T entity);
	
	public boolean update(T entity);
	
	public <R extends Serializable> T find(R id);
	
}
