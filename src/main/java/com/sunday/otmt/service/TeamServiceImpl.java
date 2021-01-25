package com.sunday.otmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sunday.otmt.dao.GenericDAO;
import com.sunday.otmt.entity.Team;

@Service
public class TeamServiceImpl implements GenericService<Team> {

	@Autowired
	@Qualifier("teamDAOImpl")
	private GenericDAO<Team> teamDAO;
	
	@Override
	public Team save(Team entity) {
		return teamDAO.save(entity);
	}

	@Override
	public Team getEntityById(int id) {
		return teamDAO.getEntityById(id);
	}

	@Override
	public List<Team> getAllEntities() {
		return teamDAO.getAllEntities();
	}

	@Override
	public void delete(int id) {
		teamDAO.delete(id);
	}
	
}
