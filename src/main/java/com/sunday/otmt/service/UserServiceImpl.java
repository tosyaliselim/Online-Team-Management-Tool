package com.sunday.otmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sunday.otmt.dao.GenericDAO;
import com.sunday.otmt.entity.User;

@Service
public class UserServiceImpl implements GenericService<User> {

	@Autowired
	@Qualifier("userDAOImpl")
	private GenericDAO<User> userDAO;
	
	@Override
	public User save(User entity) {
		return userDAO.save(entity);
	}

	@Override
	public User getEntityById(int id) {
		return userDAO.getEntityById(id);
	}

	@Override
	public List<User> getAllEntities() {
		return userDAO.getAllEntities();
	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
	}
	
}
