package com.sunday.otmt.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserId")
	private int id;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "EmailAddress")
	private String emailAddress;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date createdAt;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinTable(
			name = "REGISTERED_TEAMS",
			joinColumns = { @JoinColumn(name = "UserId") },
			inverseJoinColumns = { @JoinColumn(name = "TeamId") }
	)
	private Set<Team> registeredTeams;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinTable(
			name = "ASSIGNED_TASK",
			joinColumns = { @JoinColumn(name = "UserId") },
			inverseJoinColumns = { @JoinColumn(name = "TaskId") }
	)
	private Set<Task> assignedTasks;

	public void addRegisteredTeam(Team team) {
		if (registeredTeams == null){
			registeredTeams = new HashSet<>();
		}
		registeredTeams.add(team);
	}

	public void addAssignedTask(Task newTask) {
		if (assignedTasks == null){
			assignedTasks = new HashSet<>();
		}
		this.assignedTasks.add(newTask);
	}

}
