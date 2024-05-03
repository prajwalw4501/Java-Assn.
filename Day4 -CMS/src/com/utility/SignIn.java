package com.utility;

import java.util.ArrayList;
import java.util.List;

import com.cust_exception.InvalidCredits;
import com.cust_exception.InvalidEmail;
import com.validation.CustomerValidation;

import customerpackage.CustomerField;

public class SignIn {
//		for (CustomerField c : cust) {
//			if (checkEmail(cust, email).equals(email) && checkPassword(cust,password).equals(password)) {
//				return "Login Successful";
//			}
//		}
//		throw new InvalidCredits("Invalid email or password");
//	}
	public static String logIn(List<CustomerField> cust, String email, String password)
			throws InvalidEmail, InvalidCredits {
		CustomerValidation.dupCustomer(email, cust);

		CustomerField c = new CustomerField(email);
		int index = cust.indexOf(c);
		if (index == -1) {
			throw new InvalidEmail("Invalid Email!!!");
		}
		if (cust.get(index).getPassword().equals(password)) {
			return "Login Success!!";
		}
		throw new InvalidCredits("Re-Enter Email n Password!!");

	}

	
}
