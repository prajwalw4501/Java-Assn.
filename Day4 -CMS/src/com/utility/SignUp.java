package com.utility;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.cust_exception.InvalidPlan;
import com.enums.ServicePlan;
import com.validation.CustomerValidation;

import customerpackage.CustomerField;

public class SignUp {
	Scanner sc = new Scanner(System.in);

	public static CustomerField registration(List<CustomerField> cust, Scanner sc)throws InvalidPlan{
//			throws InvalidCredits,InvalidPlan {
//		System.out.println("Enter Id: ");
////		int cid=CustomerField.getCustomerid(sc.nextInt());
//		int id=sc.nextInt();
		System.out.println("Enter Customer FirstName: ");
		String firstname = sc.next();
		System.out.println("Enter Customer LastName: ");
		String lname=sc.next();
		System.out.println("Enter Customer E-mail: ");
		String email=sc.next();
		System.out.println("Enter Password: ");
		String password=sc.next();
		System.out.println("Enter D.O.B(yyyy-mm-dd): ");
		String dob=sc.next();
		LocalDate date=LocalDate.parse(dob);
		System.out.println("Enter Registration Amount: ");
		double regAmount=sc.nextDouble();
		System.out.println("Enter Service Plan\n"
				+ "(Silver(1000)--Gold(2000)--Diamond(5000)--Platinum(10000)): ");
		ServicePlan sp=CustomerValidation.validatePlan(sc.next(),regAmount);
		CustomerField cs = new CustomerField(firstname, lname, email, password, date,sp,regAmount);
		System.out.println(cs);
		cust.add(cs);
		System.out.println("Customer Registered!");
		return cs;

	}

}
