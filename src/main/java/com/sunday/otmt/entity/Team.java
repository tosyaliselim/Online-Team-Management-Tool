package com.sunday.otmt.entity;

import lombok.*;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TeamManagerId")
	private User manager;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="TEAM_MEMBER",
			joinColumns = { @JoinColumn(name = "TeamId") },
			inverseJoinColumns = { @JoinColumn(name = "UserId") }
	)
	private List<User> teamMembers;

	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerTeam")
	private List<Project> teamProjects;
	
	public void addTeamMember(User teamMember) {
		if (teamMembers == null) {
			teamMembers = new ArrayList<>();
		}
		teamMembers.add(teamMember);
	}

	public void addProject(Project project) {
		if (teamProjects == null){
			teamProjects = new ArrayList<>();

		}
		teamProjects.add(project);
	}
	
}
