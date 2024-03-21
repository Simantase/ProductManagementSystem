package com.jsp.ProductEntity.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.ProductEntity.entity.User;
import com.jsp.ProductEntity.service.UserService;
import com.jsp.ProductEntity.utility.ResponseStructure;

import jakarta.validation.Valid;
@RestController
public class UserController {
	private UserService userService;
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> save(@RequestBody @Valid User user){
		return userService.save(user);
	}
}
