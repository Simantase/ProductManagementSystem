package com.jsp.ProductEntity.service.impl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.ProductEntity.entity.User;
import com.jsp.ProductEntity.repository.UserRepository;
import com.jsp.ProductEntity.service.UserService;
import com.jsp.ProductEntity.utility.ResponseStructure;
@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	private ResponseStructure<User> responseStructure;
	public UserServiceImpl(UserRepository userRepository, ResponseStructure<User> responseStructure) {
		super();
		this.userRepository = userRepository;
		this.responseStructure = responseStructure;
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> save(User user) {
		return	ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
				.setStatusMessage("Data Is Saved Successfully")
				.setData(userRepository.save(user))
				);
	}

}















