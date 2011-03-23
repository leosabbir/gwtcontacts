package com.home.server.service;

import java.util.List;

import com.home.shared.entities.Test;


public interface IContactsService {
	public void save(Test test);
    public void update(Test test);
    public void delete(int id);
    public List<Test> getAllContacts();
    public Test findByProductCode(int code);
}
