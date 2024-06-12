package com.app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Map;

import com.app.core.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public LocalDate validateDate(String date) throws IllegalArgumentException {
		LocalDate d1;
		if ((d1 = LocalDate.parse(date)) != null)
			return d1;
		throw new IllegalArgumentException("Enter Valid Date");
	}

	@Override
	public String validatePhone(String phone) throws IllegalArgumentException {
		if (phone.matches("^[0-9]*$") && phone.length() == 10)
			return phone;
		throw new IllegalArgumentException("Enter valid Phone No.!!");

	}

	@Override
	public String validateAadhar(String aadhar, Map<Integer, Employee> emap) throws IllegalArgumentException {
		for (Employee e : emap.values()) {
			if (e.getAadhar_no().equals(aadhar))
				throw new IllegalArgumentException("Should be  unique!");
		}
		if (aadhar.matches("\\d{12}$") && aadhar.length() == 12)
			return aadhar;
		throw new IllegalArgumentException("Check AAdhar Number!!!!!!");

	}

	@Override
	public void writeDetails(String filename, Map<Integer, Employee> emap) throws IOException, ClassNotFoundException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(emap);
		}

	}

	@Override
	public Map<Integer, Employee> readDetails(String filename, Map<Integer, Employee> emap)
			throws IOException, ClassNotFoundException, FileNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			return (Map<Integer, Employee>) in.readObject();
		}

	}

	@Override
	public Employee searchEmployee(String name, Map<Integer, Employee> emap) throws IllegalArgumentException {
		validateAadhar(name, emap);
		for (Employee e : emap.values())
			if (e.getAadhar_no().equals(name)) {
				System.out.println(e);
				return e;
			}
		throw new IllegalArgumentException("Enter Valid ID");
	}

}
