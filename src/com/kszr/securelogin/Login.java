package com.kszr.securelogin;

import com.kszr.securelogin.entities.User;

public interface Login {
	
	public boolean register(String username, String password);
	
	public boolean login(String username, String password);
}
