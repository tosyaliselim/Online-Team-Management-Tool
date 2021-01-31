package com.sunday.otmt.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProjectId")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "StartDate")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "EndDate")
	private Date endDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@Column(name = "Description")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinColumn(name = "ProjectManagerId")
	private User manager;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinColumn(name = "OwnerTeam")
	private Team ownerTeam;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
	}, mappedBy = "ownerProject")
	private List<Task> projectTasks;

	public void addTask(Task task) {
		projectTasks.add(task);
	}
	
}
