package com.onexampur.exampur.controller;

import com.onexampur.exampur.model.RoleType;
import com.onexampur.exampur.model.User;
import com.onexampur.exampur.model.UserRole;
import com.onexampur.exampur.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("logo.png");
        // Encrypt Password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
    @GetMapping("/")
    public List<User> getAllUser(){

        return userService.getAllUser();
    }
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable(value = "username") String userName) {

        return this.userService.getUserByUsername(userName);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable(value = "userId") Long userId) {

        return this.userService.deleteUserById(userId);
    }

    @PutMapping("/{username}")
    public User updateUser(@PathVariable(value = "username") String username, @RequestBody User user){
        final User user1 = this.userService.updateUserByUsername(username, user);

        return user1;
    }

}
