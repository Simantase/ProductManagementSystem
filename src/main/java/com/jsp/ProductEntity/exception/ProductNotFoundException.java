package com.jsp.ProductEntity.exception;

public class ProductNotFoundException extends RuntimeException{
	private String message;
	public ProductNotFoundException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
