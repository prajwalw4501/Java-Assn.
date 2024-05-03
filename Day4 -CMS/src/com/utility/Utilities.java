package com.utility;

import java.util.ArrayList;

import com.cust_exception.InvalidEmail;

import customerpackage.CustomerField;

public class Utilities {
	public static CustomerField checkEmail(ArrayList<CustomerField> c, String mail) throws InvalidEmail {

//		for (CustomerField cust : c) {
//			if (mail.equals(cust.getEmail()))
//				return cust.get(cust.
//		}
		CustomerField cust = new CustomerField(mail);
		int acc=c.indexOf(cust);
		if(acc!=-1) {
			return c.get(acc);
		}
		throw new InvalidEmail("Re-Enter Your Email-id");
	}

	public static CustomerField checkPassword(ArrayList<CustomerField> c, String pass) throws InvalidEmail {

		for (CustomerField cust : c) {
			if (pass.equals(cust.getEmail()))
				;
		}
		throw new InvalidEmail("Invalid Password!!");
	}

	public static void changePassword(ArrayList<CustomerField> cust, String email, String pass) throws InvalidEmail {
//		checkEmail(cust, email);
		CustomerField c = checkEmail(cust, email);
		c.setPassword(pass);

//	throw new InvalidEmail("Check Email!!");

	}
	public static void unSubscribe(ArrayList<CustomerField> cust, String email) throws InvalidEmail {
		CustomerField c=checkEmail(cust, email);
		cust.remove(c);
		}
}
