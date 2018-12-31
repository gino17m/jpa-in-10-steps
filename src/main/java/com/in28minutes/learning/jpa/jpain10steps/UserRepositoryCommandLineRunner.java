package com.in28minutes.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

import com.in28minutes.learning.jpa.jpain10steps.service.UserRepository;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
			
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jillyyyyy Gillyyyyy", "Admin");
		userRepository.save(user);
		log.info("New User is created : " + user);
		
		user.setName("Jilly");
		
		userRepository.save(user);
		log.info("User is updated : " + user);
		
		user = new User("Mikey mouse", "Admin");
		
		userRepository.save(user);
		log.info("New User is created : " + user);	
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived : " + userWithIdOne);
			
		List<User> users = userRepository.findAll();
		log.info("All users :" + users);
		
	}

}
