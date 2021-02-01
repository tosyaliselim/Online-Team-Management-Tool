package com.sunday.otmt.service;

import java.util.List;

import com.sunday.otmt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sunday.otmt.dao.GenericDAO;
import com.sunday.otmt.exception.EntityNotFoundException;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements GenericService<User> {

	@Autowired
	@Qualifier("userDAOImpl")
	private GenericDAO<User> userDAO;
	
	@Override
	@Transactional
	public User save(User entity) {
		return userDAO.save(entity);
	}

	@Override
	@Transactional
	public User getById(int id) {
		return userDAO.getEntityById(id);
	}

	@Override
	@Transactional
	public List<User> getAll() {
		return userDAO.getAllEntities();
	}

	@Override
	@Transactional
	public void delete(int id) {
		userDAO.delete(id);
	}
	
	@Override
	@Transactional
	public User getByName(String name) throws EntityNotFoundException {
		User user = userDAO.getEntityByName(name);
		if(user == null) {
			throw new EntityNotFoundException();
		}
		return user;
	}
	
}
