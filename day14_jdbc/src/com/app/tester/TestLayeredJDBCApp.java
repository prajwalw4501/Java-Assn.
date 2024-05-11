package com.app.tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.app.dao.*;
import com.app.dao.AccountDao;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

public class TestLayeredJDBCApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 1. init phase --invoked once @ beginning of app
			// created dao instance (i.e Tester :
			// dependent is creating it's own dependency)
			UserDaoImpl userDao = new UserDaoImpl();
			AccountDaoImpl AccountDao = new AccountDaoImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println("---Options--- \n1. Login" + "\n2. Display user details by DoB"
						+ "\n3. Voter registration \n4. Update Password \n5. Remover Voter \n6.Transfer(Proc)"
						+ " \n7. Transfer(Func)" + "\n0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // login
						System.out.println("Enter email n password");
						User user = userDao.signIn(sc.next(), sc.next());
						if (user != null) {
							System.out.println("Login Successful !!!");
							System.out.println(user);
						} else
							System.out.println("Invalid email or password!!!!");
						break;
					case 2:
						System.out.println("Enter start n end DoBs(yr-mon-day)");
						List<User> list = userDao.getUserDetails(Date.valueOf(sc.next()), Date.valueOf(sc.next()));
						System.out.println("Users -");
						list.forEach(System.out::println);// u -> sop(u)
						break;
					case 3:
						System.out.println("Enter Voter's details - firstName,  lastName, email,  password,  dob");
						// create transient(not yet persistent in DB) user instance
						user = new User(sc.next(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()));
						System.out.println("Reg status " + userDao.voterRegistration(user));
						break;
					case 4:// update voter's password:
						System.out
								.println("Enter Details to update Password\nEmail:  \nOld Password:  \nNew Password: ");
						System.out.println(userDao.updatePassword(sc.next(), sc.next(), sc.next()));
						break;
					case 5:
						System.out.println("Enter Details to Remove");
						System.out.println("Email: \nPassword: ");
						System.out.println(userDao.deleteVoter(sc.next(), sc.next()));
						break;
					case 6:// transfer fund with proc
						System.out.println("enter src acc  dest acc amount:");
						System.out.println(AccountDao.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble()));
						break;

					case 7:// with function
						System.out.println("enter src acc  dest acc amount:");
						System.out.println(AccountDao.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble()));
						break;

					case 0:
						exit = true;
						// destroy (shutdown/terminate app)
						userDao.cleanUp();
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
