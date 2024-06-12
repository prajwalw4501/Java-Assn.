package com.app.utils;

import com.app.exception.AuthenticationException;

public class CustomerUtility {
	public static void customerLogin(String userid, String pass) throws AuthenticationException {
		if (userid.equals("Customer") && pass.equals("customer")) {
			System.out.println("Customer Login Success!!");

		} else
			throw new AuthenticationException("Invalid Credentials!!");

	}

}
