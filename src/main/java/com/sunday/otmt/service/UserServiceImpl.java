package com.sunday.otmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sunday.otmt.dao.GenericDAO;
import com.sunday.otmt.entity.User;
import com.sunday.otmt.exception.EntityNotFoundException;

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
	public User getById(int id) {
		return userDAO.getEntityById(id);
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAllEntities();
	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
	}
	
	@Override
	public User getByName(String name) throws EntityNotFoundException {
		User user = userDAO.getEntityByName(name);
		if(user == null) {
			throw new EntityNotFoundException();
		}
		return user;
	}
	
}
