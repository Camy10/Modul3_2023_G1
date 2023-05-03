package com.application.bookstore.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.bookstore.user.dto.UserCreateDTO;
import com.application.bookstore.user.dto.UserGetDTO;
import com.application.bookstore.user.mapper.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	/* CRUD
	 * C- CREATE
	 * R-  READ
	 * U - UPDATE
	 * D - DELETE
	 */
	
	@PostMapping()
	public UserGetDTO create(@RequestBody UserCreateDTO userCreateDTO) {
		User user = userMapper.userCreateDTO2User(userCreateDTO);	
		return userMapper.user2UserGetDTO(userService.create(user));
	}
	
	@GetMapping("/list")
	public List<UserGetDTO> findAll() {
		return userMapper.userList2UserListDTO(userService.findAll());
	}
	
	@GetMapping("/{id}")
	public UserGetDTO findById(@PathVariable Integer id) {
		return userMapper.user2UserGetDTO(userService.findById(id));
	}
	
	@PutMapping("/{id}")
	public UserGetDTO update(@RequestBody UserCreateDTO userCreateDTO, @PathVariable Integer  id) {
		User user = userMapper.userCreateDTO2User(userCreateDTO);
		User updateUser = userService.update(user, id);
		return userMapper.user2UserGetDTO(updateUser);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		userService.delete(id);
	}

}
