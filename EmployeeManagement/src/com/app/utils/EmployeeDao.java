package com.app.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.time.LocalDate;
import java.util.Map;

import com.app.core.Employee;

public interface EmployeeDao {
	LocalDate validateDate(String date) throws IllegalArgumentException;

//	Employee validateId(int id,Map<Integer, Employee>emap) throws InvalidKeyException;
	String validatePhone(String phone) throws IllegalArgumentException;

	String validateAadhar(String aadhar, Map<Integer, Employee> emap) throws IllegalArgumentException;

	void writeDetails(String filename, Map<Integer, Employee> emap) throws IOException, ClassNotFoundException;

	Map<Integer, Employee> readDetails(String filename, Map<Integer, Employee> emap)
			throws IOException, ClassNotFoundException, FileNotFoundException;

	Employee searchEmployee(String name, Map<Integer, Employee> emap) throws IllegalArgumentException;
}
