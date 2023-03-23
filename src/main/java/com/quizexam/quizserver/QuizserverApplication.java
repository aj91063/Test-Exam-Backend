package com.quizexam.quizserver;

import com.quizexam.quizserver.model.RoleType;
import com.quizexam.quizserver.model.User;
import com.quizexam.quizserver.model.UserRole;
import com.quizexam.quizserver.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class QuizserverApplication implements CommandLineRunner {
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(QuizserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting point");
		User user =new User();
		user.setFirstName("Karan");
		user.setLastName("Jaiswal");
		user.setGender("Male");
		user.setEmail("aj91063@gmail.com");
		user.setPassword("123");
		user.setPhone("9695844246");
		user.setProfile("default.png");
		user.setUserName("aj91063");

		RoleType roleType = new RoleType();
		roleType.setRoleId(55L);
		roleType.setRoleName("ADMIN");

		UserRole userRole =	new UserRole();
		userRole.setRole(roleType);
		userRole.setUser(user);

		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(userRole);

		 User userCreate = this.userService.createUser(user, userRoles);
		System.out.println(userCreate.getUserName());

	}
}
