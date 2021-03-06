package com.sunday.otmt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TASK")
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

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private Status status = Status.PENDING;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "ASSIGNED_TASK",
			joinColumns = { @JoinColumn(name = "TaskId") },
			inverseJoinColumns = { @JoinColumn(name = "UserId") }
	)
	private List<User> respondents;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OwnerProject")
	private Project ownerProject;

	public void addRespondent(User user) {
		if (respondents == null){
			respondents = new ArrayList<>();
		}
		respondents.add(user);
	}
	
}
