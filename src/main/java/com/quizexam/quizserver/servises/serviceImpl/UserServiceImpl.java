package com.quizexam.quizserver.servises.serviceImpl;

import com.quizexam.quizserver.model.User;
import com.quizexam.quizserver.model.UserRole;
import com.quizexam.quizserver.repository.RoleTypeRepository;
import com.quizexam.quizserver.repository.UserRepository;
import com.quizexam.quizserver.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        User localUser = this.userRepository.findByUserName(user.getUserName());

      try{
          if(localUser != null){
              System.out.println("User already there !! "+localUser.getUserName() );
          }
          else {
              //create user
              for(UserRole ur: userRoles){
                  roleTypeRepository.save(ur.getRole());
              }
              user.getUserRoles().addAll(userRoles);
              localUser = this.userRepository.save(user);
          }
      }catch (Exception e){
          e.printStackTrace();
      }
        return localUser;
    }
}
