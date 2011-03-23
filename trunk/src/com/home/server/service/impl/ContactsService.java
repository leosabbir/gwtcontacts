package com.home.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.server.dao.ITestDao;
import com.home.server.service.IContactsService;
import com.home.shared.entities.Test;

@Service
public class ContactsService implements IContactsService {

	@Autowired
	ITestDao contactDao;
	
	public ContactsService(ITestDao contactDao){
		this.contactDao = contactDao;
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		Test test = this.contactDao.findByProductCode(id);
		if(test != null){
			this.contactDao.delete(test);
		}
	}

	@Override
	@Transactional
	public Test findByProductCode(int code) {
		return this.contactDao.findByProductCode(code);
	}

	@Override
	@Transactional
	public void save(Test test) {
		this.contactDao.save(test);
	}

	@Override
	public void update(Test test) {
		Test updated = this.contactDao.findByProductCode(test.getId());
		updated.setAddress(test.getAddress());
		this.contactDao.update(updated);
		
	}

	@Override
	public List<Test> getAllContacts() {
		return this.contactDao.getAllContacts();
	}

}
