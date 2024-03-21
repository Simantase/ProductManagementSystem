package com.jsp.ProductEntity.exception;

public class ProductNotFoundException1 extends RuntimeException{
	private String message;
	public ProductNotFoundException1(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
