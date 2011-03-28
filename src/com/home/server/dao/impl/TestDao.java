package com.home.server.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.server.dao.ITestDao;
import com.home.shared.entities.ContactDetails;

@Repository
public class TestDao implements ITestDao{

	private HibernateTemplate hibernateTemplate;

    public TestDao(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	@Override
	public boolean delete(ContactDetails test) {
		this.hibernateTemplate.delete(test);
		return true;
		
	}

	@Override
	public ContactDetails findByProductCode(int code) {
		//List obj = hibernateTemplate.find("select t.id, t.name, t.mobile, t.address from test as t where id = ?1", code);
		//Test test = new Test(obj["name"], obj["mobile"], obj["address"]);
		ContactDetails contact = (ContactDetails) this.hibernateTemplate.get("com.home.shared.entities.ContactDetails", code);
		return contact; 
	}

	@Override
	public boolean save(ContactDetails test) {
		hibernateTemplate.saveOrUpdate(test);
		return true;
	}

	@Override
	public boolean update(ContactDetails test) {
		this.hibernateTemplate.update(test);
		return true;
		
	}

	@Override
	@Transactional
	public List<ContactDetails> getAllContacts() {
		//return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from test").list();
		return hibernateTemplate.find("from ContactDetails");
		
	}

}
