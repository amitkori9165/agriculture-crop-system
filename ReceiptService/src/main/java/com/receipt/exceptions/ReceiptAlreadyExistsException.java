package com.receipt.exceptions;

public class ReceiptAlreadyExistsException extends RuntimeException{
	public ReceiptAlreadyExistsException(String message) {
		super(message);
	}

}
