package customerpackage;

import com.cust_exception.*;
import com.enums.ServicePlan;

import java.util.*;
import java.time.LocalDate;

@SuppressWarnings("unused")
public class CustomerField {
	private static int customerid;
	private String firstname, lastname;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;

	private static int id;

	public CustomerField(String first, String last, String email, String pass, LocalDate dob, ServicePlan plan,
			double amnt) {
		this.customerid = ++id;
		this.firstname = first;
		this.lastname = last;
		this.email = email;
		this.password = pass;
		this.regAmount = amnt;
		this.dob = dob;
		this.plan = plan;
	}

	public CustomerField(String email) {
		this.email = email;

	}

//	@Override
//	public String toString() {
//		return "===Customers===\nCustomer Id= " + customerid + "\nEmail= " + email + "\nPassword= " + password
//				+ "\nRegistration Amount= " + regAmount + "\nD.O.B= " + dob + "\nService Plan= " + plan;
//	}
	@Override
	public String toString() {
		return "CustomerField=======================" + "\nCustomer ID: " + customerid + "\nFirstName: " + firstname
				+ "\nLastName: " + lastname + "\nEmail: " + email + "\nPassword: " + password + "\nReg.Amount: "
				+ regAmount + "\nD.O.B: " + dob + "\nPlan=" + plan;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof CustomerField) {
			CustomerField cust = (CustomerField) o;
			return this.email.equals(cust.email);
		}
		return false;
	}

	public int compareTo(CustomerField cust) {
		return this.getEmail().compareTo(cust.getEmail());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
