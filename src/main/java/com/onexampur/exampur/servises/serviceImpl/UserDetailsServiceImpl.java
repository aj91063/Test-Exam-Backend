package com.onexampur.exampur.servises.serviceImpl;

import com.onexampur.exampur.model.User;
import com.onexampur.exampur.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User byUserName = this.userRepository.findByUsername(username);
        if(byUserName ==null){
            System.out.println("User not found!!");
            throw new RuntimeException("User not found!!");
        }
        return byUserName;
    }
}
