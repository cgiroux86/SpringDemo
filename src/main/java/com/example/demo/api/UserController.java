package com.example.demo.api;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO: ADD AUTHORIZATION TO ENDPOINTS
@RequestMapping(value = "api/user")
@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {this.userService = userService;}
    @PostMapping
    public void addUser(@RequestBody User user) {userService.addUser(user);}
    @GetMapping
    public List<User> getAllUsers() {return userService.getAllUsers();}

}
