package com.sunday.otmt.entity;

import java.util.Date;

public class Project {
	
	private int id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Date createdAt;
	private String description;
	private User manager;
	private Team ownerTeam;
	
	public Project() {}

	public Project(String name, String description, User manager, Team ownerTeam) {
		this.name = name;
		this.description = description;
		this.manager = manager;
		this.ownerTeam = ownerTeam;
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
	
}
