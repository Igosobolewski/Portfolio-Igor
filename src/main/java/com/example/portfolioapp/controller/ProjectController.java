package com.example.portfolioapp.controller;

import com.example.portfolioapp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("projects", projectService.getProjects());
        return "index";
    }
}
