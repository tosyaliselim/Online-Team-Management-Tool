package com.sunday.otmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunday.otmt.entity.Team;
import com.sunday.otmt.entity.User;
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
	public String createTeam(@ModelAttribute("team") Team team, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("currentUser");
		
		if (user == null) return "redirect:/showLoginPage";
		
		user.addRegisteredTeam(team);
		team.setManager(user);
		team.addTeamMember(user);
		teamService.save(team);
		
		session.setAttribute("currentTeam", team);
		
		return "redirect:/team/details";
	}
	
	@GetMapping("/details")
	public String showTeam(Model model) {
		return "team-detail";
	}
	
	
	@RequestMapping("/list")
	public String showTeams(Model model) {
		return "list-team";
	}
	
}
