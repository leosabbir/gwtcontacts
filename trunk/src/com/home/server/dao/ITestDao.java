package com.home.server.dao;

import java.util.List;

import com.home.shared.entities.Test;

public interface ITestDao {
	public void save(Test test);
    public void update(Test test);
    public void delete(Test test);
    public List<Test> getAllContacts();
    public Test findByProductCode(int code);
}
