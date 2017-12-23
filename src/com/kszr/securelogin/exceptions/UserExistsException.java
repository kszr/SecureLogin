package com.kszr.securelogin.exceptions;

public class UserExistsException extends IllegalArgumentException {

	public UserExistsException(String msg) {
		super(msg);
	}
}
