package com.sunday.otmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sunday.otmt.dao.GenericDAO;
import com.sunday.otmt.entity.Project;

import javax.transaction.Transactional;


@Service
public class ProjectServiceImpl implements GenericService<Project> {
	
	@Autowired
	@Qualifier("projectDAOImpl")
	private GenericDAO<Project> projectDAO;
	
	@Override
	@Transactional
	public Project save(Project entity) {
		return projectDAO.save(entity);
	}

	@Override
	@Transactional
	public Project getById(int id) {
		return projectDAO.getEntityById(id);
	}

	@Override
	@Transactional
	public List<Project> getAll() {
		return projectDAO.getAllEntities();
	}

	@Override
	@Transactional
	public void delete(int id) {
		projectDAO.delete(id);
	}
	
}
