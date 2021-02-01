package com.sunday.otmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunday.otmt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/getForm")
	public String showForm(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("currentUser");
		
		if (user == null) return "redirect:/showLoginPage";
		
		model.addAttribute("team", new Team());

		return "create-team-form";
	}

	@PostMapping("/create")
	public String createTeam(@ModelAttribute("team") Team team,
							 HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("currentUser");
		
		if (user == null) return "redirect:/showLoginPage";

		team.setManager(user);
		team.addTeamMember(user);
		user.addRegisteredTeam(team);
		teamService.save(team);

		session.setAttribute("currentTeam", team);
		return "team-detail";
	}
	
	@GetMapping("/details")
	public String showTeam(HttpServletRequest req) {

		int teamId = Integer.parseInt(req.getParameter("teamId"));
		Team team = teamService.getById(teamId);
		if (team == null){
			return "error-page";
		}

		HttpSession session = req.getSession();
		session.setAttribute("currentTeam", team);

		return "team-detail";
	}
	
	
	@RequestMapping("/list")
	public String showTeams(Model model) {
		return "list-team";
	}
	
}
