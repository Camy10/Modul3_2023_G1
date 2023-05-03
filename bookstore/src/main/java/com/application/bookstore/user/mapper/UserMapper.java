package com.application.bookstore.user.mapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.Comment;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Component;

import com.application.bookstore.user.User;
import com.application.bookstore.user.dto.UserCreateDTO;
import com.application.bookstore.user.dto.UserGetDTO;
@Component
public class UserMapper {
	public User userCreateDTO2User(UserCreateDTO userCreateDTO) {
		User user = new User();
		user.setFirstName(userCreateDTO.getFirstName());
		user.setLastName(userCreateDTO.getLastName());
		user.setAge(userCreateDTO.getAge());

		return user;
	}

	public UserGetDTO user2UserGetDTO(User user) {
		UserGetDTO userGetDTO = new UserGetDTO();
		userGetDTO.setId(user.getId());
		userGetDTO.setFirstName(user.getFirstName());
		userGetDTO.setLastName(user.getLastName());
		userGetDTO.setAge(user.getAge());

		return userGetDTO;
	}
	
	public List<UserGetDTO> userList2UserListDTO(List<User> users){
		return users
				.stream()
				.map(user->user2UserGetDTO(user))
				.collect(Collectors.toList());
	}

}
