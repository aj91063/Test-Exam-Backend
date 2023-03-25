package com.onexampur.exampur.servises;

import com.onexampur.exampur.model.User;
import com.onexampur.exampur.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    //creating user

    User createUser(User user, Set<UserRole> userRoles) throws Exception;
    User getUserByUsername(String userName);
    String deleteUserById(Long userId);
     List<User> getAllUser();
}
