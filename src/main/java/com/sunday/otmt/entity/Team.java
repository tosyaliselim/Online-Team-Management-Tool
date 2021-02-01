package com.sunday.otmt.entity;

import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TEAM")
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
			joinColumns = { @JoinColumn(name = "TeamId") },
			inverseJoinColumns = { @JoinColumn(name = "UserId") }
	)
	private Set<User> teamMembers;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	}, mappedBy = "ownerTeam")
	private Set<Project> teamProjects;
	
	public void addTeamMember(User teamMember) {
		if (teamMembers == null) {
			teamMembers = new HashSet<>();
		}
		teamMembers.add(teamMember);
	}
	
	public void addProject(Project project) {
		if (teamProjects == null){
			teamProjects = new HashSet<>();
		}
		teamProjects.add(project);
	}
	
}
