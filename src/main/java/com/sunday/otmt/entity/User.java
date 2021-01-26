package com.sunday.otmt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private Date createdAt;
	private List<String> roles;
	private List<Team> registeredTeams;
	
	public User() {
		this.createdAt = new Date();
		this.roles = new ArrayList<String>();
		this.registeredTeams = new ArrayList<Team>();
	}

	public User(String userName, String firstName, String lastName, String emailAddress, String phoneNumber) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.createdAt = new Date();
		this.roles = new ArrayList<String>();
		this.registeredTeams = new ArrayList<Team>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public List<Team> getRegisteredTeams() {
		return registeredTeams;
	}

	public void setRegisteredTeams(List<Team> registeredTeams) {
		this.registeredTeams = registeredTeams;
	}

	public void addRole(String role) {
		roles.add(role);
	}
	
	public void addRegisteredTeam(Team team) {
		registeredTeams.add(team);
	}

}
