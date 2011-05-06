package com.home.server.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.home.server.dao.GenericDao;

public class GenericDaoImpl<T> extends HibernateDaoSupport implements GenericDao<T> {

	Class<T> entityClass;
	
	public GenericDaoImpl(){
		entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public boolean save(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return true;
	}

	@Override
	public <R extends Serializable> T find(R id) {
		return getHibernateTemplate().get(entityClass, id);
	}
	
	@Override
	public boolean delete(T entity) {
		getHibernateTemplate().delete(entity);
		return true;
	}
	
	@Override
	public boolean update(T entity) {
		getHibernateTemplate().update(entity);
		return true;
	}

}
