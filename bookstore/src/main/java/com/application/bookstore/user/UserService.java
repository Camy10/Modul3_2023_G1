package com.application.bookstore.user;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
//		Optional<User> optionUser = userRepository.findById(id);
//		if(optionUser.isPresent()) {
//			return optionUser.get();
//		}
//		return null;
		
	return userRepository.findById(id).orElseThrow();
	}
	
	public User update(User user, Integer id) {
		User existingUser = userRepository.findById(id).orElseThrow();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setAge(user.getAge());
		
		userRepository.saveAndFlush(existingUser);
		
		return existingUser;
	}
	
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
	
}
