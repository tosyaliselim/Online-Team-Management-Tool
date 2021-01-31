package com.sunday.otmt.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

	// TODO: Make it an Hibernate Entity

	private int id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Date createdAt;
	private String description;
	private User manager;
	private Team ownerTeam;
	private List<Task> projectTasks;

	public void addTask(Task task) {
		projectTasks.add(task);
	}
	
}
