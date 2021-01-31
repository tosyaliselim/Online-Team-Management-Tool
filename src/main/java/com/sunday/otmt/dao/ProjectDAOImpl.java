package com.sunday.otmt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunday.otmt.entity.Project;

@Repository
public class ProjectDAOImpl implements GenericDAO<Project> {

	private final SessionFactory sessionFactory;

	@Autowired
	public ProjectDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Project save(Project project) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(project);
		return project;
	}

	@Override
	public Project getEntityById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Project project = session.get(Project.class, id);
		return project;
	}

	@Override
	public List<Project> getAllEntities() {
		Session session = sessionFactory.getCurrentSession();
		List<Project> projects = session.createQuery(
				"from Project p " +
				"left join fetch p.projectTasks",
				Project.class).getResultList();

		return projects;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Project project = session.get(Project.class, id);
		session.delete(project);
	}
	
}
