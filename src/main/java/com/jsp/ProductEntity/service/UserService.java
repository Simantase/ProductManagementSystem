package com.jsp.ProductEntity.service;
import org.springframework.http.ResponseEntity;
import com.jsp.ProductEntity.entity.User;
import com.jsp.ProductEntity.utility.ResponseStructure;
public interface UserService {
	ResponseEntity<ResponseStructure<User>> save(User user);

}
