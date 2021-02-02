package com.sunday.otmt.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PROJECT")
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ProjectManagerId")
	private User manager;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OwnerTeam")
	private Team ownerTeam;

	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.PERSIST})
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "ownerProject")
	private List<Task> projectTasks = new ArrayList<>();

	public void addTask(Task task) {
		projectTasks.add(task);
	}
	
}
