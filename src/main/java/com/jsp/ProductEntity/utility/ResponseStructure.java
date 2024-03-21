package com.jsp.ProductEntity.utility;
import org.springframework.stereotype.Component;
@Component
public class ResponseStructure<T> {
	private int statusCode;
	private String statusMessage;
	private T data;
	
	public int getStatusCode() {
		return statusCode;
	}
	public ResponseStructure<T> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public ResponseStructure<T> setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
		return this;
	}
	public T getData() {
		return data;
	}
	public ResponseStructure<T> setData(T data) {
		this.data = data;
		return this;
	}


}
