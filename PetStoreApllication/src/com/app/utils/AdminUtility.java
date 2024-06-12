package com.app.utils;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Pet;
import com.app.exception.AuthenticationException;
import com.app.exception.DuplicateIdException;

public class AdminUtility {
	public static void adminLogin(String userid, String pass) throws AuthenticationException {
		if (userid.equals("Admin") && pass.equals("admin"))
			System.out.println("Admin Login Success!!");

		else
			throw new AuthenticationException("Invalid Credentials!!");

	}

	public static HashMap<Integer, Pet> addPet(HashMap<Integer, Pet> pets, int id, Scanner sc)
			throws DuplicateIdException {
		validatePet(id, pets);
		return pets;

	}

	public static Pet validatePet(int id, HashMap<Integer, Pet> pets) throws DuplicateIdException {
		Pet p = pets.get(id);
		if (pets.containsKey(id))
			throw new DuplicateIdException("Already Added!!");
		else
			return p;

	}

	public static HashMap<Integer, Pet> updatePet(int id, int stocks, double price, HashMap<Integer, Pet> pets)
			throws DuplicateIdException {
		for (Pet p : pets.values()) {
			if (p.getPetId() == id)
				p.setStocks(stocks);
			p.setUnitPrice(price);
		}

		return pets;

	}

}
