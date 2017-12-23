package com.kszr.securelogin.exceptions;

public class InvalidPasswordException extends IllegalArgumentException {
	
	public InvalidPasswordException(String msg) {
		super(msg);
	}

}
