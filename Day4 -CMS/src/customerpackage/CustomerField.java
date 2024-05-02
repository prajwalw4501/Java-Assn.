package customerpackage;

import java.util.*;
import java.time.LocalDate;

@SuppressWarnings("unused")
public class CustomerField {
	private static int customerid;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;

	public CustomerField(int id, String email, String pass, double regAmount, LocalDate dob, ServicePlan plan) {
		this.customerid = id++; // AUTO_INCREMENT
		this.email = email;
		this.password = pass;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "CustomerField---\nCustomer Id= " + customerid + "\nEmail= " + email + "\nPassword= " + password
				+ "\nRegistration Amount= " + regAmount + "\nD.O.B= " + dob + "\nService Plan= " + plan;
	}

	public static int getCustomerid() {
		return customerid;
	}

	public static void setCustomerid(int customerid) {
		CustomerField.customerid = customerid;
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
	public static void registration() throws CustomerException{
		
	}

}
