package com.sunday.otmt.dao;

import java.util.List;

import com.sunday.otmt.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements GenericDAO<User> {

	private final SessionFactory sessionFactory;

	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);

		return user;
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
		List<User> people = session.createQuery(
				"from User u " +
				"left join fetch u.assignedTasks " +
				"left join fetch u.registeredTeams", User.class).getResultList();

		return people;
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

		User user = session.createQuery(
				"from User u " +
						"left join fetch u.registeredTeams " +
						"left join fetch u.assignedTasks " +
						"where u.userName =: uName", User.class)
				.setParameter("uName", name)
				.getSingleResult();
		return user;
	}
	
}