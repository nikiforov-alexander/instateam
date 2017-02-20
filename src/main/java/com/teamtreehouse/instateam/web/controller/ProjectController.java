package com.teamtreehouse.instateam.web.controller;

import com.teamtreehouse.instateam.model.Project;
import com.teamtreehouse.instateam.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    // Home page - index of all projects
    @RequestMapping("/")
    public String listProjects(Model model) {
        // Get all projects from the database and store the list into the project variable
        List<Project> projects = projectService.findAll();

        model.addAttribute("projects", projects);
        return "index";
    }

    // Single project page
    @RequestMapping("/projects/{projectId}")
    public String project(@PathVariable Long projectId, Model model) {
        // Get the project given by projectId
        Project project = null;

        model.addAttribute("project", project);
        return "project/details";
    }

    // Form for adding a new project
    @RequestMapping("projects/add")
    public String formNewProject(Model model) {
        // TODO: Add model attributes needed for new form
        model.addAttribute("project", new Project());

        return "project/index";
    }

    // Edit an existing project
    @RequestMapping("projects/{projectId}/edit")
    public String editProject(@PathVariable Long projectId, Model model) {
        // TODO: Add model attributes needed for edit form

        return "project/form";
    }

    // Update an existing project
    @RequestMapping(value = "/projects/{projectId}", method = RequestMethod.POST)
    public String updateProject() {
        // TODO: Update project if valid data was received

        // TODO: Redirect browser to home page
        return null;
    }

    // Add a project
    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public String addProject(Project project) {
        // TODO: Add project if valid data was received
        projectService.save(project);

        // TODO: Redirect browser to home page
        return "redirect:/projects";
    }

    // Delete an existing project
    @RequestMapping(value = "/projects/{projectId}/delete", method = RequestMethod.POST)
    public String deleteProject(@PathVariable Long projectId) {
        // TODO: Delete project whose id is projectId

        // TODO: Redirect browser to home page
        return null;
    }
}
