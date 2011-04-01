package com.home.server.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.server.dao.IContactsDao;
import com.home.server.entities.ContactDetailsEntity;
import com.home.shared.entities.ContactDetails;

@Repository
public class ContactsDao implements IContactsDao{

	private HibernateTemplate hibernateTemplate;

    public ContactsDao(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	@Override
	public boolean delete(ContactDetailsEntity test) {
		this.hibernateTemplate.delete(test);
		return true;
		
	}

	@Override
	public ContactDetailsEntity findContact(int code) {
		//List obj = hibernateTemplate.find("select t.id, t.name, t.mobile, t.address from test as t where id = ?1", code);
		//Test test = new Test(obj["name"], obj["mobile"], obj["address"]);
		ContactDetailsEntity contact = (ContactDetailsEntity) this.hibernateTemplate.get("com.home.server.entities.ContactDetailsEntity", code);
		return contact; 
	}

	@Override
	public boolean save(ContactDetailsEntity test) {
		hibernateTemplate.saveOrUpdate(test);
		return true;
	}

	@Override
	public boolean update(ContactDetailsEntity test) {
		this.hibernateTemplate.update(test);
		return true;
		
	}

	@Override
	@Transactional
	public List<ContactDetailsEntity> getAllContacts() {
		//return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from test").list();
		return hibernateTemplate.find("from ContactDetailsEntity");
		
	}

}
