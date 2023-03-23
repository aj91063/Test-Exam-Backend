package com.quizexam.quizserver.servises;

import com.quizexam.quizserver.model.User;
import com.quizexam.quizserver.model.UserRole;

import java.util.Set;

public interface UserService {
    //creating user

    User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
