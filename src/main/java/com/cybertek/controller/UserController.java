package com.cybertek.controller;

import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

//  since 'UserController' Class has dependency on 'RoleService' Class
//  we can inject 'RoleService' (dependency injection).. and other services

    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    @GetMapping("/create")
    public String createUser(Model model){

        // we need to show inside the table: user, roles, users
        model.addAttribute("user",new UserDTO()); // to pass an empty Object
        model.addAttribute("roles",roleService.findAll()); // to print all the Assigned Managers in the drop-down and Projects in the table
        model.addAttribute("users",userService.findAll()); // this will return everything inside the Map...
                                                                //...(DataGenerator/UserDTO user1, user2, user3, user4)
        return "/user/create";
    }

    @PostMapping("/create") // This Post method works when we click 'Save' button when creating a new user.
    public String insertUser(UserDTO user,Model model){

//        model.addAttribute("user",new UserDTO());
//        model.addAttribute("roles",roleService.findAll());
//        model.addAttribute("users",userService.findAll());

        userService.save(user); // this user/object comes from above Get method (model.addAttribute("user",new UserDTO());)

        return "redirect:/user/create"; // this 'insertUser' method is same as above 'createUser' method...
    }                                   // ...instead of going back to 'create.html', we just call the above 'createUser' method "redirect:/user/create"


//                       'username' comes from 'create.html' inside the Table
    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username,Model model){

        model.addAttribute("user",userService.findById(username));
        model.addAttribute("users",userService.findAll());
        model.addAttribute("roles",roleService.findAll());

        return "/user/update";  // we cannot 'redirect' this one because it has a different method 'model.addAttribute("user",userService.findById(username));'...
                                //... and a different view  'user/update' =='update.html'.

    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username,UserDTO user,Model model){
        userService.update(user);
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){
        userService.deleteById(username); //
        return "redirect:/user/create";
    }






















}
