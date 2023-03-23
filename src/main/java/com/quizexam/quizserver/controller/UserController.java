package com.quizexam.quizserver.controller;

import com.quizexam.quizserver.model.RoleType;
import com.quizexam.quizserver.model.User;
import com.quizexam.quizserver.model.UserRole;
import com.quizexam.quizserver.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) throws Exception {

        RoleType role=new RoleType();
        role.setRoleId(56L);
        role.setRoleName("NORMAL");

        UserRole userRole= new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        Set<UserRole> userRoles= new HashSet<>();
        userRoles.add(userRole);

        User savedUser = this.userService.createUser(user, userRoles);
        return savedUser;
    }
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable(value = "username") String userName) {

        return this.userService.getUserByUsername(userName);
    }

}
