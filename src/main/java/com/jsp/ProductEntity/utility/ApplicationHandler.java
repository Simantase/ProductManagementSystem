package com.jsp.ProductEntity.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.ProductEntity.exception.ProductNotFoundException;
import com.jsp.ProductEntity.exception.ProductNotFoundException1;
import com.jsp.ProductEntity.exception.ProductNotFoundException2;
import com.jsp.ProductEntity.exception.ProductNotFoundException3;

@RestControllerAdvice
public class ApplicationHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> productNotUpdated(ProductNotFoundException ex){
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setRootCause("Data Is Not Updated!!!");
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> productNotDeleted(ProductNotFoundException1 ex1){
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex1.getMessage());
		errorStructure.setRootCause("Data Is Not Deleted!!!");
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> productNotFetched(ProductNotFoundException2 ex2){
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex2.getMessage());
		errorStructure.setRootCause("Data Is Not Fetched!!!");
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> productsNotFetched(ProductNotFoundException3 ex3){
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex3.getMessage());
		errorStructure.setRootCause("All The Data Are Not Fetched!!!");
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);
	}

}
