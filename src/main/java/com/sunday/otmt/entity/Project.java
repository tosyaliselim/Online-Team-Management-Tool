package com.sunday.otmt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
	
	private int id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Date createdAt;
	private String description;
	private User manager;
	private Team ownerTeam;
	private List<Task> projectTasks;
	
	public Project() {
		this.createdAt = new Date();
		this.projectTasks = new ArrayList<Task>();
	}

	public Project(String name, String description, User manager, Team ownerTeam) {
		this.name = name;
		this.description = description;
		this.manager = manager;
		this.ownerTeam = ownerTeam;
		this.createdAt = new Date();
		this.projectTasks = new ArrayList<Task>();
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public Team getOwnerTeam() {
		return ownerTeam;
	}

	public void setOwnerTeam(Team ownerTeam) {
		this.ownerTeam = ownerTeam;
	}

	public List<Task> getProjectTasks() {
		return projectTasks;
	}

	public void setProjectTasks(List<Task> projectTasks) {
		this.projectTasks = projectTasks;
	}
	
	public void addTask(Task task) {
		projectTasks.add(task);
	}
	
}
