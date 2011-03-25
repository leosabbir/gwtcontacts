package com.home.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.server.dao.ITestDao;
import com.home.server.service.IContactsService;
import com.home.shared.entities.ContactDetails;

@Service
public class ContactsService implements IContactsService {

	@Autowired
	ITestDao contactDao;
	
	public ContactsService(ITestDao contactDao){
		this.contactDao = contactDao;
	}
	
	@Override
	@Transactional
	public boolean delete(int id) {
		ContactDetails test = this.contactDao.findByProductCode(id);
		if(test != null){
			return this.contactDao.delete(test);
		}
		return false;
	}

	@Override
	@Transactional
	public ContactDetails findByProductCode(int code) {
		return this.contactDao.findByProductCode(code);
	}

	@Override
	@Transactional
	public boolean save(ContactDetails test) {
		return this.contactDao.save(test);
	}

	@Override
	public boolean update(ContactDetails test) {
		ContactDetails updated = this.contactDao.findByProductCode(test.getId());
		updated.setAddress(test.getAddress());
		return this.contactDao.update(updated);
		
	}

	@Override
	public List<ContactDetails> getAllContacts() {
		return this.contactDao.getAllContacts();
	}

}
