package com.sunday.otmt.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sunday.otmt.entity.Project;

@Repository
public class ProjectDAOImpl implements GenericDAO<Project> {
	
	private List<Project> allProjects;
	private int idNumber;
	
	public ProjectDAOImpl() {
		allProjects = new ArrayList<Project>();
		idNumber=1;
	}
	
	@Override
	public Project save(Project entity) {
		entity.setId(idNumber++);
		allProjects.add(entity);
		return entity;
	}

	@Override
	public Project getEntityById(int id) {
		for(Project project : allProjects) {
			if(project.getId() == id)
				return project;
		}
		return null;
	}

	@Override
	public List<Project> getAllEntities() {
		return allProjects;
	}

	@Override
	public void delete(int id) {
		Iterator<Project> iterator = allProjects.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getId() == id)
				iterator.remove();
		}
	}
	
}
