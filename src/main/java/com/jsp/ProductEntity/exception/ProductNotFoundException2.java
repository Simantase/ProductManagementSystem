package com.jsp.ProductEntity.exception;

public class ProductNotFoundException2 extends RuntimeException{
	private String message;
	public ProductNotFoundException2(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
