package com.sunday.otmt.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sunday.otmt.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunday.otmt.entity.Team;

import javax.persistence.TypedQuery;

@Repository
public class TeamDAOImpl implements GenericDAO<Team> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Team save(Team newTeam) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(newTeam);
		return newTeam;
	}

	@Override
	public Team getEntityById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Team user = session.get(Team.class, id);
		return user;
	}

	@Override
	public List<Team> getAllEntities() {
		Session session = sessionFactory.getCurrentSession();
		List<Team> teams = session.createQuery(
				"from Team t " +
						"left join fetch t.teamMembers " +
						"left join fetch t.teamProjects", Team.class
		).getResultList();

		return teams;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Team team = session.get(Team.class, id);
		session.delete(team);
	}
	
}