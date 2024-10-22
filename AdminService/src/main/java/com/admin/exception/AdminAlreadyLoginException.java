package com.admin.exception;

public class AdminAlreadyLoginException extends RuntimeException{

	public AdminAlreadyLoginException(String message) {
		super(message);
	}

}
