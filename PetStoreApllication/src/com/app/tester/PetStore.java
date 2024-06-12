package com.app.tester;

import static com.app.utils.AdminUtility.adminLogin;
import static com.app.utils.AdminUtility.updatePet;
import static com.app.utils.AdminUtility.validatePet;
import static com.app.utils.CustomerUtility.customerLogin;
import static com.app.utils.UserCollection.*;
import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Category;
import com.app.core.Order;
import com.app.core.Pet;
import com.app.core.Role;
import com.app.core.User;

public class PetStore {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HashMap<Integer, Pet> pets = new HashMap<>();
			HashMap<Integer, Order> orders = new HashMap<>();
			HashMap<String, User> users = populateUser();
			boolean exit = false;
			while (!exit)
				try {
					System.out.println("---CONSOLE---");
					System.out.println("1.Login" + "\n2.Add NEW Pet" + "\n3.Update Pet Details"
							+ "\n4.Dsiplay All Available Pets" + "\n5.Order a Pet" + "\n6.Check Order Status"
							+ "\n7.Update Order Status" + "\n0.Exit");
					System.out.println("Press a KEY:");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter LogIn Details:");
						String userid = sc.next();
						String pass = sc.next();
						userLogin(userid, pass, users);

						break;
					case 2:
						System.out.println("Enter Login Details!");
						adminLogin(sc.next(), sc.next());
						System.out.println("Admin Login!");
						System.out.println("Add Pet Details!!");
						System.out.println("PetId");
						int id = sc.nextInt();
						validatePet(id, pets);
						System.out.println("Name,Category ,UnitPrice,Stocks");
						pets.put(id, new Pet(id, sc.next(), Category.valueOf(sc.next().toUpperCase()), sc.nextDouble(),
								sc.nextInt()));
						System.out.println("Pet Add succesfully!!");

						break;
					case 3:
						System.out.println("Enter Login Details!");
						adminLogin(sc.next(), sc.next());
						System.out.println("Admin Login!");
						System.out.println("Update Pet Details");
						int pid = sc.nextInt();
						System.out.println("Update Stock and Price:");
						updatePet(pid, sc.nextInt(), sc.nextDouble(), pets);

						break;
					case 4:
//						for(Pet p:pets)
						break;
					case 0:
						System.exit(0);
						break;

					default:
						System.out.println("Invalid Choice, Re-Enter KEY!");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
