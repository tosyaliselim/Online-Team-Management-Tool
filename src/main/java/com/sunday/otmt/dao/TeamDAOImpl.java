package com.sunday.otmt.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sunday.otmt.entity.Team;

@Repository
public class TeamDAOImpl implements GenericDAO<Team> {
	
	private List<Team> allTeams;
	private int idNumber;
	
	public TeamDAOImpl() {
		allTeams = new ArrayList<Team>();
		idNumber = 1;
	}
	
	@Override
	public Team save(Team entity) {
		entity.setId(idNumber++);
		allTeams.add(entity);
		return entity;
	}

	@Override
	public Team getEntityById(int id) {
		for(Team team : allTeams) {
			if(team.getId() == id) 
				return team;
		}
		return null;
	}

	@Override
	public List<Team> getAllEntities() {
		return allTeams;
	}

	@Override
	public void delete(int id) {
		Iterator<Team> iterator = allTeams.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getId() == id) 
				iterator.remove();
		}
	}
	
}