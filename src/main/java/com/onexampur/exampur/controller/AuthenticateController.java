package com.onexampur.exampur.controller;

import com.onexampur.exampur.config.JwtUtils;
import com.onexampur.exampur.model.JwtRequest;
import com.onexampur.exampur.model.JwtResponce;
import com.onexampur.exampur.model.User;
import com.onexampur.exampur.servises.serviceImpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

@PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            this.authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());
        } catch (Exception e) {
            throw new Exception("User not found!! " + e.getMessage());
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUserName());
        final String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponce(token));
    }


    @GetMapping("/currentUser")
    public User getCurrentLoginUser(Principal principal) {
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }

    private void authenticate(String userName, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (DisabledException e) {
            throw new Exception("USER DISABLED " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credential " + e.getMessage());
        }
    }
}
