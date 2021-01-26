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
		loadInitially();
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
	
	@Override
	public User getEntityByName(String name) {
		User user = null;
		User tempUser = null;
		Iterator<User> iterator = allUsers.iterator();
		while(iterator.hasNext()) {
			tempUser = iterator.next();
			if(tempUser.getUserName().equals(name))
				user = tempUser;
		}
		return user;
	}
	
	private void loadInitially(){
        allUsers = new ArrayList<User>();
        User user1 = new User("bilgehan", "Bilgehan", "Kaya", "bilgehankaya@protonmail.com", "05170000055");
        user1.setId(idNumber); idNumber++;
        allUsers.add(user1);
        User user2 = new User("kerem", "Kerem", "Kaya", "bilgehankaya@protonmail.com", "05170000055");
        user2.setId(idNumber); idNumber++;
        allUsers.add(user2);
        User user3 = new User("selim", "Selim", "Kaya", "bilgehankaya@protonmail.com", "05170000055");
        user3.setId(idNumber); idNumber++;
        allUsers.add(user3);
        User user4 = new User("mert", "Mert", "Kaya", "bilgehankaya@protonmail.com", "05170000055");
        user4.setId(idNumber); idNumber++;
        allUsers.add(user4);
        User user5 = new User("ramo", "Ramazan", "Kaya", "bilgehankaya@protonmail.com", "05170000055");
        user5.setId(idNumber); idNumber++;
        allUsers.add(user5);
    }
	
}