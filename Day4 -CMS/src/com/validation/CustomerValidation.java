package com.validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.cust_exception.*;
import com.enums.ServicePlan;

import customerpackage.CustomerField;
import customerpackage.CustomerField.*;

public class CustomerValidation {
	public static LocalDate parseDate(String date) throws ValidDate {
		
		return LocalDate.parse(date);
//		throw new ValidDate("Enter Valid Date Format!!!");
	}

	public static CustomerField dupCustomer(String mail, List<CustomerField> cust) throws InvalidEmail {
		CustomerField cst = new CustomerField(mail);
		if (cust.contains(cst))
		return cst;
		throw new InvalidEmail("Enter Valid E-Mail!!!");
	}

	public static ServicePlan validatePlan(String plan, double regAmount) throws InvalidPlan {
		ServicePlan type = ServicePlan.valueOf(plan.toUpperCase());
		if (type.getCharge() == regAmount)
		  return type ;
		throw new InvalidPlan("Enter the valid Plan Details!!!!");
	}

	public static CustomerField validCustomerIP(String first, String last,String email, String pass, double regAmount,
			String dob, String plan,List<CustomerField> cust) throws InvalidEmail, InvalidPlan, ValidDate{
//		CustomerField cs;
		dupCustomer(email, cust);
		ServicePlan type=validatePlan(plan, regAmount);
		LocalDate birth=parseDate(dob);
//		CustomerField c =new CustomerField(0, first, last, email, pass, birth, type, regAmount);
		CustomerField f=new CustomerField(first, last, email, pass, birth, type, regAmount);
//		throw new ValidCredits("Check Inputs!!!");
		return f;
	}
	

}
