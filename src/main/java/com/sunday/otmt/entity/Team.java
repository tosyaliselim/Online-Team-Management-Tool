package com.sunday.otmt.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {

	// TODO: Make it an Hibernate Entity
	
	private int id;
	private String name;	
	private String description;
	private String category;
	private Date createdAt;
	private User manager;
	private List<User> teamMembers;
	private List<Project> teamProjects;
	
	public void addTeamMember(User teamMember) {
		teamMembers.add(teamMember);
	}
	
	public void addProject(Project project) {
		teamProjects.add(project);
	}
	
}
