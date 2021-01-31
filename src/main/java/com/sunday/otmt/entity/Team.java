package com.sunday.otmt.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TeamId")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Category")
	private String category;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinColumn(name = "TeamManagerId")
	private User manager;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinTable(
			name="TEAM_MEMBER",
			joinColumns = { @JoinColumn("TeamId") },
			inverseJoinColumns = { @JoinColumn("UserId") }
	)
	private List<User> teamMembers;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	}, mappedBy = "ownerTeam")
	private List<Project> teamProjects;
	
	public void addTeamMember(User teamMember) {
		teamMembers.add(teamMember);
	}
	
	public void addProject(Project project) {
		teamProjects.add(project);
	}
	
}
