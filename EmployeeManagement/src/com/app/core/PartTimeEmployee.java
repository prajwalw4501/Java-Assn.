package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class PartTimeEmployee extends Employee implements Serializable {
	private double hourly_pay;

	public PartTimeEmployee(int id, String name, LocalDate date_of_joining, String phone, String aadhar_no,
			double hourly_pay) {
		super(id, name, date_of_joining, phone, aadhar_no);
		this.hourly_pay = hourly_pay;
	}

	public double getHourly_pay() {
		return hourly_pay;
	}

	public void setHourly_pay(double hourly_pay) {
		this.hourly_pay = hourly_pay;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee: " + super.toString() + "[hourly_pay=" + hourly_pay + "]";
	}

}
