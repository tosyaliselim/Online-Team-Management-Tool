package com.sunday.otmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sunday.otmt.dao.GenericDAO;
import com.sunday.otmt.entity.Team;

import javax.transaction.Transactional;

@Service
public class TeamServiceImpl implements GenericService<Team> {

	@Autowired
	@Qualifier("teamDAOImpl")
	private GenericDAO<Team> teamDAO;
	
	@Override
	@Transactional
	public Team save(Team entity) {
		return teamDAO.save(entity);
	}

	@Override
	@Transactional
	public Team getById(int id) {
		return teamDAO.getEntityById(id);
	}

	@Override
	@Transactional
	public List<Team> getAll() {
		return teamDAO.getAllEntities();
	}

	@Override
	@Transactional
	public void delete(int id) {
		teamDAO.delete(id);
	}
	
}
