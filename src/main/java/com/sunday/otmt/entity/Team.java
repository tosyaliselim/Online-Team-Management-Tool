package com.sunday.otmt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Team {
	
	private int id;
	private String name;	
	private String description;
	private String category;
	private Date createdAt;
	private User manager;
	private List<User> teamMembers;
	private List<Project> teamProjects;
	
	public Team() {	
		this.createdAt = new Date();
		this.teamMembers = new ArrayList<User>();
		this.teamProjects = new ArrayList<Project>();
	}

	public Team(String name, String description, String category, User manager) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.manager = manager;
		this.createdAt = new Date();
		this.teamMembers = new ArrayList<User>();
		this.teamProjects = new ArrayList<Project>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public List<User> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<User> teamMembers) {
		this.teamMembers = teamMembers;
	}
	
	public List<Project> getTeamProjects() {
		return teamProjects;
	}

	public void setTeamProjects(List<Project> teamProjects) {
		this.teamProjects = teamProjects;
	}

	public void addTeamMember(User teamMember) {
		teamMembers.add(teamMember);
	}
	
	public void addProject(Project project) {
		teamProjects.add(project);
	}
	
}
