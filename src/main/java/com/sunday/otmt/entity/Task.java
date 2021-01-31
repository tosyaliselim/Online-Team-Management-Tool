package com.sunday.otmt.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TaskId")
	private int id;
	
	@Column(name = "TaskTitle")
	private String taskTitle;
	
	@Column(name = "Description")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "StartDate")
	private Date startDate;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "FinishDate")
	private Date finishDate;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinTable(
			name = "ASSIGNED_TASK",
			joinColumns = { @JoinColumn("TaskId") },
			inverseJoinColumns = { @JoinColumn("UserId") }
	)
	private List<User> respondents;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinColumn(name = "OwnerProject")
	private Project ownerProject;
	

	public void addRespondent(User user) {
		respondents.add(user);
	}
	
}
