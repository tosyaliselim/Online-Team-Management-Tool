package com.sunday.otmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@GetMapping("/showCreateTeamForm")
	public String showCreateTeamForm(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//if (!(authentication instanceof AnonymousAuthenticationToken))
	    String currentUserName = authentication.getName();
		
		model.addAttribute("currentUserName", currentUserName);
		model.addAttribute("team", new Team());

		return "create-team-form";
	}
	
	@GetMapping("/createTeam")
	public String createTeam(@ModelAttribute("team") Team team) {
		teamService.save(team);
		return "redirect:/team/all";
	}
	
	@RequestMapping("/all")
	public String showTeams(Model model) {
		List<Team> allTeams = teamService.getAllEntities();
		model.addAttribute("teams", allTeams);
		return "list-team";
	}
	
}
