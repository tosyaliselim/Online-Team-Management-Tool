package com.sunday.otmt.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "USER")
@Getter @Setter
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
	@DateTimeFormat("yyyy/MM/dd")
	private Date createdAt;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinTable(
			name = "REGISTERED_TEAMS",
			joinColumns = { @JoinColumn("UserId") },
			inverseJoinColumns = { @JoinColumn("TeamId") }
	)
	private List<Team> registeredTeams;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinTable(
			name = "ASSIGNED_TASK",
			joinColumns = { @JoinColumn("UserId") },
			inverseJoinColumns = { @JoinColumn("TaskId") }
	)
	private List<Task> assignedTasks;

	public void addRegisteredTeam(Team team) {
		registeredTeams.add(team);
	}

	public void addAssignedTask(Task newTask) {
		this.assignedTasks.add(newTask);
	}

}
