package com.sunday.otmt.controller;

import com.sunday.otmt.entity.Project;
import com.sunday.otmt.entity.Team;
import com.sunday.otmt.entity.User;
import com.sunday.otmt.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/proj")
public class ProjectController {

    @Autowired
    private GenericService<Project> projectService;

    @GetMapping("/getForm")
    public String getProjectForm(HttpServletRequest req, Model model){

        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("currentUser");
        if (currentUser == null)
            return "login-page";

        Team currentTeam = (Team) session.getAttribute("currentTeam");
        if (currentTeam == null)
            return "redirect:/home";

        List<User> teamMembers = currentTeam.getTeamMembers();
        model.addAttribute("teamMembers", teamMembers);

        Project project = new Project();
        model.addAttribute("project", project);

        return "create-project-form";
    }

    @PostMapping("/create")
    public String createProject(HttpServletRequest req,
                                @ModelAttribute("project") Project project){

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");
        if (user == null)
            return "login-page";

        User manager = project.getManager();
        Team team = (Team) session.getAttribute("currentTeam");

        if (manager == null || team == null)
            return "error-page";
        
        project.setOwnerTeam(team);
        team.addProject(project);
        String informMessage = "Project was created successfully!";
        req.setAttribute("informMessage", informMessage);
        return "project-page";
    }
}