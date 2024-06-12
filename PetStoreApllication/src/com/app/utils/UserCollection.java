package com.app.utils;

import java.util.HashMap;

import com.app.core.Role;
import com.app.core.User;
import com.app.exception.AuthenticationException;

public class UserCollection {
	public static HashMap<String, User> populateUser() {
		HashMap<String, User> users = new HashMap<>();
		users.put("admin@gmail.com", new User("admin@gmail.com", "admin", Role.ADMIN));
		users.put("prajwal@gmail.com", new User("prajwal@gmail.com", "prajwal", Role.CUSTOMER));
		users.put("darshan@gmail.com", new User("darshan@gmail.com", "darshan", Role.CUSTOMER));
		return users;
	}

	public static User userLogin(String username, String password, HashMap<String, User> users)
			throws AuthenticationException {
		for (User u : users.values()) {
			if (u.getUsername().equals(username))
				if (u.getPassword().equals(password))
					System.out.println("Login Succesfully");
			return u;
		}
		throw new AuthenticationException("invaild!!");
	}

}
