package com.jsp.ProductEntity.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.ProductEntity.entity.User;
@Repository
 public interface UserRepository extends JpaRepository<User,Integer>{

}
