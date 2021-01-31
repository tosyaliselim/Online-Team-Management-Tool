package com.sunday.otmt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunday.otmt.entity.User;

import javax.persistence.TypedQuery;

@Repository
public class UserDAOImpl implements GenericDAO<User> {

	private final SessionFactory sessionFactory;

	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User save(User newUser) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(newUser);

		return newUser;
	}

	@Override
	public User getEntityById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public List<User> getAllEntities() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery(
				"from User u " +
				"left join fetch u.assignedTasks left join fetch " +
				"left join fetch u.registeredTeams", User.class).getResultList();

		return users;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.delete(user);
	}
	
	@Override
	public User getEntityByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		TypedQuery<User> query = session.createQuery(
				"from User u " +
				"where u.userName =: id", User.class);
		query.setParameter("id", name);

		User user = query.getSingleResult();
		return user;
	}
	
}