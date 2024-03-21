package com.jsp.ProductEntity;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsp.ProductEntity.entity.ProductEntity;
@SpringBootApplication
public class ProductEntityApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductEntityApplication.class, args);
		System.out.println("Application Has Started");
//		ProductEntity productEntity=new ProductEntity();
//		Optional.of(productEntity).map(p->{
//			System.out.println("Inside Map");
//			return p;
//		}).orElseThrow(()->new RuntimeException());
	}

}
