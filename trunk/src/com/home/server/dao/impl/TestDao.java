package com.home.server.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.server.dao.ITestDao;
import com.home.shared.entities.Test;

@Repository
public class TestDao implements ITestDao{

	private HibernateTemplate hibernateTemplate;

    public TestDao(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	@Override
	public void delete(Test test) {
		this.hibernateTemplate.delete(test);
		
	}

	@Override
	public Test findByProductCode(int code) {
		//List obj = hibernateTemplate.find("select t.id, t.name, t.mobile, t.address from test as t where id = ?1", code);
		//Test test = new Test(obj["name"], obj["mobile"], obj["address"]);
		Test contact = (Test) this.hibernateTemplate.get("com.home.shared.entities.Test", code);
		return contact; 
	}

	@Override
	public void save(Test test) {
		hibernateTemplate.saveOrUpdate(test);		
	}

	@Override
	public void update(Test test) {
		hibernateTemplate.update(test);
		
	}

	@Override
	@Transactional
	public List<Test> getAllContacts() {
		//return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from test").list();
		return hibernateTemplate.find("from Test");
		
	}

}
