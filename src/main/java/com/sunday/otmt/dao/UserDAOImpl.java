package com.sunday.otmt.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sunday.otmt.entity.User;

@Repository
public class UserDAOImpl implements GenericDAO<User> {

	private List<User> allUsers;
	private int idNumber;
	
	public UserDAOImpl() {
		allUsers = new ArrayList<User>();
		idNumber = 1;
	}
	
	@Override
	public User save(User entity) {
		entity.setId(idNumber++);
		allUsers.add(entity);
		return entity;
	}

	@Override
	public User getEntityById(int id) {
		for(User user : allUsers) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getAllEntities() {
		return allUsers;
	}

	@Override
	public void delete(int id) {
		Iterator<User> iterator = allUsers.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getId() == id)
				iterator.remove();
		}
	}
	
}