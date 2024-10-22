package com.receipt.exceptions;

public class ReceiptNotFoundException extends RuntimeException{
	public ReceiptNotFoundException(String message) {
		super(message);
	}
}
