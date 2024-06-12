package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	public int id;
	private String name;
	private LocalDate date_of_joining;
	private String phone;
	private String aadhar_no;
	public static int counter = 1;

	public Employee(int id, String name, LocalDate date_of_joining, String phone, String aadhar_no) {
		super();
		this.id = counter++;
		this.name = name;
		this.date_of_joining = date_of_joining;
		this.phone = phone;
		this.aadhar_no = aadhar_no;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", date_of_joining=" + date_of_joining + ", phone=" + phone
				+ ", aadhar_no=" + aadhar_no + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(LocalDate date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Employee.counter = counter;
	}

}
