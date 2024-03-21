package com.jsp.ProductEntity.exception;

public class ProductNotFoundException3 extends RuntimeException{
	private String message;
	public ProductNotFoundException3(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
