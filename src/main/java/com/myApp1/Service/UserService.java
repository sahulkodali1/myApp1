package com.myApp1.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.myApp1.Exception.UserNotFound;
import com.myApp1.Model.User;
import com.myApp1.Repositories.UserRepository;

public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User save(User user) throws Exception {
		return userRepository.save(user);
	}

	public void delete(String userName) throws Exception {
		User user = userRepository.findOne(userName);
		if (user != null) {
			userRepository.delete(userName);
		} else {
			throw new UserNotFound("search with " + userName + " is failed");
		}
	}

	public User getDetails(String userName) throws Exception {
		return userRepository.findOne(userName);
	}
}
