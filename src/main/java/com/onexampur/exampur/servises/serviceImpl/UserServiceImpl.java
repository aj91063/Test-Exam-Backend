package com.onexampur.exampur.servises.serviceImpl;

import com.onexampur.exampur.model.User;
import com.onexampur.exampur.model.UserRole;
import com.onexampur.exampur.repository.RoleTypeRepository;
import com.onexampur.exampur.repository.UserRepository;
import com.onexampur.exampur.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RoleTypeRepository roleTypeRepository;

    /* Creating User */
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User localUser = this.userRepository.findByUsername(user.getUsername());

        try {
            if (localUser != null) {
                System.out.println("User already there !! " + localUser);
                return localUser;
            } else {
                //create user
                for (UserRole ur : userRoles) {
                    roleTypeRepository.save(ur.getRole());
                }
                user.getUserRoles().addAll(userRoles);
                localUser = this.userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localUser;
    }

    //getting the user by username
    @Override
    public User getUserByUsername(String userName) {
        return this.userRepository.findByUsername(userName);
    }

    //deleting user by ID
    @Override
    public String deleteUserById(Long userId) {
        User user = this.userRepository.findById(userId).get();
        if (user != null) {
            this.userRepository.deleteById(userId);
            return "User " + user.getUsername() + " remove successfully";
        } else {
            return "User " + user.getUsername() + " not presented";
        }
    }

    @Override
    public List<User> getAllUser() {

        List<User> allUser = this.userRepository.findAll();
        return allUser;
    }


    @Override
    public User updateUserByUsername(String username, User user) {
        final User byUsername = this.userRepository.findByUsername(username);
        try {
            if (byUsername != null) {
                byUsername.setProfile(user.getProfile());
                byUsername.setEmail(user.getEmail());
                byUsername.setPhone(user.getPhone());
                byUsername.setGender(user.getGender());
                userRepository.save(byUsername);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return byUsername;
    }


}
