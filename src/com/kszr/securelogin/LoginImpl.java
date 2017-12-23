package com.kszr.securelogin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import com.kszr.securelogin.exceptions.InvalidPasswordException;
import com.kszr.securelogin.exceptions.UserExistsException;

public class LoginImpl implements Login {
	
	private static final String PASSWORDS = "data/passwords.csv";
	private final Logger LOGGER;
	
	public LoginImpl() {
		LOGGER = Logger.getLogger("LoginImpl");
	}
    
	@Override
	public boolean register(String username, String password) {
		try {
			userExists(username);
			validatePassword(password);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			userExists(username);
			return false;
		} catch (Exception e) {
			
		}
		
		return true;
	}
	
	/**
	 * Returns whether a user is already registered.
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	private boolean userExists(String username) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new FileReader(PASSWORDS));
			String line;
			String csvSplitBy = ",";
			
			while ((line = br.readLine()) != null) {
				String user[] = line.split(csvSplitBy);
				
				if (user[0].equalsIgnoreCase(username)) {
					throw new UserExistsException("User " + username + " already exists, and his/her password is: " + user[1]);
				}
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			LOGGER.severe("Unable to read " + PASSWORDS);
			throw e;
		} 
		return false;
	}
	
	/**
	 * A password must be 2-6 characters long and contain lowercase letters a-z ONLY.
	 * 
	 * @param password
	 * @return
	 */
	private void validatePassword(String password) {
		throw new InvalidPasswordException("A password must be 2-6 characters long and contain lowercase letters a-z ONLY. Suggestion: \"abc\".");
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private boolean checkPassword(String username, String password) {
		try {
			userExists(username);
		} catch (UserExistsException e) {
			
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	private boolean registerUser(String username, String password) {
		return false;
	}

}
