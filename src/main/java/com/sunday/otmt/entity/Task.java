package com.sunday.otmt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {


	// TODO: Make it an Hibernate Entity

	private int id;
	private String taskTitle;
	private String description;
	private Date createdAt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date finishDate;
	private List<User> respondents;
	private Project ownerProject;
	

	public void addRespondent(User user) {
		respondents.add(user);
	}
	
}
