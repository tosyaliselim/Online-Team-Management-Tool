package com.sunday.otmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sunday.otmt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sunday.otmt.entity.Project;
import com.sunday.otmt.entity.Team;
import com.sunday.otmt.service.GenericService;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	@Qualifier("teamServiceImpl")
	private GenericService<Team> teamService;

	@Autowired
	@Qualifier("userServiceImpl")
	private GenericService<User> userService;

	@PostMapping("/create")
	public String createTeam(@ModelAttribute("team") Team team,
							 Model model,
							 HttpServletRequest req) {

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("currentUser");
		if (user == null) return "redirect:/showLoginPage";

		team.setManager(user);
		team.addTeamMember(user);
		user.addRegisteredTeam(team);
		teamService.save(team);

		session.setAttribute("currentTeam", team);

		Project project = new Project();
		model.addAttribute("project", project);

		return "team-detail";
	}

	@GetMapping("/details")
	public String showTeam(Model model,
						   HttpServletRequest req) {

		int teamId = Integer.parseInt(req.getParameter("teamId"));
		Team team = teamService.getById(teamId);
		if (team == null){
			return "error-page";
		}

		Project project = new Project();
		model.addAttribute("project", project);

		HttpSession session = req.getSession();
		session.setAttribute("currentTeam", team);

		return "team-detail";
	}

}