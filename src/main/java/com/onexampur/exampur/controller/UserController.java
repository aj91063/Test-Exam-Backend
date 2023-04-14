package com.onexampur.exampur.controller;

import com.onexampur.exampur.customException.UserFoundException;
import com.onexampur.exampur.model.RoleType;
import com.onexampur.exampur.model.User;
import com.onexampur.exampur.model.UserRole;
import com.onexampur.exampur.servises.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @ApiOperation(value = "createUser", notes="Create the User",nickname = "")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 201, message = "Successful Created",
                    response = UserController.class, responseContainer = "List") })
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
    public void deleteUser(@PathVariable(value = "userId") Long userId) {

        this.userService.deleteUserById(userId);
    }

    @PutMapping("/{username}")
    public User updateUser(@PathVariable(value = "username") String username, @RequestBody User user){
        final User user1 = this.userService.updateUserByUsername(username, user);

        return user1;
    }

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ue){
          return (ResponseEntity<?>) ResponseEntity.notFound();
    }

}
