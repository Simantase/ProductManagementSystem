package com.jsp.ProductEntity.utility;
import org.springframework.stereotype.Component;
@Component
public class ErrorStructure {
	private int errorCode;
	private String errorMessage;
	private Object rootCause;
	public int getErrorCode() {
		return errorCode;
	}
	public ErrorStructure setErrorCode(int errorCode) {
		this.errorCode = errorCode;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorStructure setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
	public Object getRootCause() {
		return rootCause;
	}
	public ErrorStructure setRootCause(Object rootCause) {
		this.rootCause = rootCause;
		return this;
	}
	
	
}
