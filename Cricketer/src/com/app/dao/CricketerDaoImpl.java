package com.app.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.app.core.Cricketer;
import com.app.exception.InvalidIdException;

public class CricketerDaoImpl implements CricketerDao {
	public static HashMap<String, Cricketer> populateMap() {
		HashMap<String, Cricketer> cricketer = new HashMap<>();
		cricketer.put("dhoni@gmail.com", new Cricketer("Dhoni", 42, "dhoni@gmail.com", "1234567890", 9));
		cricketer.put("kholi@gmail.com", new Cricketer("Kholi", 35, "kholi@gmail.com", "1234567890", 10));
		cricketer.put("rohit@gmail.com", new Cricketer("Rohit", 36, "rohit@gmail.com", "1234567890", 8));
		return cricketer;
	}

	@Override
	public String updateRating(String email, int rating, HashMap<String, Cricketer> cmap) throws InvalidIdException {
		if (cmap.containsKey(email))
			for (Cricketer c : cmap.values())
				if (c.getEmail_id().equals(email)) {
					c.setRating(rating);
					return "Set rating!!";
				}
		throw new InvalidIdException("invalid");
	}

	@Override
	public Cricketer searchCricketer(String name, HashMap<String, Cricketer> cmap) throws InputMismatchException {

		for (Cricketer c : cmap.values()) {
			if (c.getName().equals(name))
				return c;
		}
		throw new InputMismatchException("invalid input");

	}

	@Override
	public void writeDetails(String name, HashMap<String, Cricketer> cmap) throws IOException, FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(name)) {
			pw.write(cmap.toString());
		}

	}

	@Override
	public void readDetails(String file) throws FileNotFoundException, IOException {
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bf.readLine()) != null) {

				System.out.println(line);
			}
		}

	}
}
