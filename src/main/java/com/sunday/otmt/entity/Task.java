package com.sunday.otmt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {
	
	private int id;
	private String taskTitle;
	private String description;
	private Date createdAt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date finishDate;
	private List<User> respondents;
	private Project ownerProject;
	
	public Task() {
		this.createdAt = new Date();
		this.respondents = new ArrayList<User>();
	}

	public Task(String taskTitle, String description, Project ownerProject) {
		this.taskTitle = taskTitle;
		this.description = description;
		this.ownerProject = ownerProject;
		this.createdAt = new Date();
		this.respondents = new ArrayList<User>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public List<User> getRespondents() {
		return respondents;
	}

	public void setRespondents(List<User> respondents) {
		this.respondents = respondents;
	}
	
	public Project getOwnerProject() {
		return ownerProject;
	}

	public void setOwnerProject(Project ownerProject) {
		this.ownerProject = ownerProject;
	}

	public void addRespondent(User user) {
		respondents.add(user);
	}
	
}
