package com.cybertek.controller;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {


    @Autowired // to inject all the projects (1,2,3) into the table
    ProjectService projectService; // below: 'model.addAttribute("projects",projectService.findAll());'

    @Autowired
    UserService userService; // in this case we'll inject all users as managers ('model.addAttribute("managers",userService.findAll());')

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("projects",projectService.findAll());
//      model.addAttribute("managers",userService.findAll()); // to get all the managers:
        model.addAttribute("managers",userService.findManagers());

        return "/project/create";
    }

    @PostMapping("/create") // 'Save' button
    public String insertProject(ProjectDTO project){ // passing the Object

        projectService.save(project); // save it in the Map
        project.setProjectStatus(Status.OPEN); // 'Status' column

        return "redirect:/project/create"; // after selecting 'Save' button we want to land on 'project/create'

    }
    // 'Delete' button:
    // '/{projectcode}' path variable
    @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectcode){

        projectService.deleteById(projectcode); // we are deleting based on the project code.

        return "redirect:/project/create";
    }

    // Step 1. (Step 2. service/ProjectService)
    // COMPLETE button
    @GetMapping("/complete/{projectcode")
    public String comleteProject(@PathVariable("projectcode") String projectcode){

        // Step 4. (Step 5 project/create.html)
        projectService.comlete(projectService.findById(projectcode)); // run 'complete'

        return "redirect:/project/create";
    }

    // Step 1. (Step 2. project/update.html)
    // UPDATE button
    @GetMapping("/update/{projectcode")
    public String updateProject(@PathVariable("projectcode") String projectcode, Model model){

        // 'new ProjectDTO()' would give us an empty Object, which we don't need, cause the fields under Project Create would be empty,
        // instead when we select 'Update' button for a user from the User List, we want the fields under Project Create to be populated with that user info

        // model.addAttribute("project",new ProjectDTO());

        model.addAttribute("project", projectService.findById(projectcode));
        model.addAttribute("projects",projectService.findAll()); // we want to see all current projects
        model.addAttribute("managers",userService.findManagers()); // it will show us all Assigned Managers from the it's drop-down.

        return "/project/update";
    }

}
