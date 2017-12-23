package com.kszr.securelogin.entities;

public class UserImpl implements User {
	private final String username;
	private String password;
	
	public UserImpl(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
