package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class FullTimeEmployee extends Employee implements Serializable {
	private double monthly_sal;

	public FullTimeEmployee(int id, String name, LocalDate date_of_joining, String phone, String aadhar_no,
			double monthly_sal) {
		super(id, name, date_of_joining, phone, aadhar_no);
		this.monthly_sal = monthly_sal;
	}

	public double getMonthly_sal() {
		return monthly_sal;
	}

	public void setMonthly_sal(double monthly_sal) {
		this.monthly_sal = monthly_sal;
	}

	@Override
	public String toString() {
		return "FullTimeEmployee: " + super.toString() + "monthly_sal=" + monthly_sal + "]";
	}

}
