package com.app.tester;

import static com.app.dao.CricketerDaoImpl.populateMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.app.core.Cricketer;
import com.app.dao.CricketerDao;
import com.app.dao.CricketerDaoImpl;

public class TestCricket {

	public static void main(String[] args) {
		CricketerDao dao = new CricketerDaoImpl();
		HashMap<String, Cricketer> cricketer = populateMap();
		List<Cricketer> ckt = new ArrayList<Cricketer>(cricketer.values());

		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!false)
				try {
					System.out.println("---CONSOLE---");
					System.out.println("1.Accept Cricketer" + "\n2.Update Cricketer Ratings"
							+ "\n3.Search Cricketer(Name)" + "\n4.Display All Cricketers" + "\n5.Sort By Ratings"
							+ "\n6.Sort By Name " + "\n7.Save Data" + "\n8.Retrieve Data");
					System.out.println("Enter KEY");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Details of Cricketer");
						System.out.println("Enter E-mail:");
						String email = sc.next();
						System.out.println("Name,Age,Phone,Rating");
						cricketer.put(email, new Cricketer(sc.next(), sc.nextInt(), email, sc.next(), sc.nextInt()));
						System.out.println("Cricketer Added Successfully with " + email);

						break;
					case 2:
						System.out.println("Enter Id n Ratings!");
						dao.updateRating(sc.next(), sc.nextInt(), cricketer);

						break;
					case 3:
						System.out.println("Enter Cricketer Name: ");
						System.out.println(dao.searchCricketer(sc.next(), cricketer));
						break;
					case 4:
						cricketer.values().stream().forEach(i -> System.out.println(i));
						break;
					case 5:
//						Collections.sort(ckt, (o1, o2) -> o2.getRating() - o1.getRating());
//						ckt.forEach(i -> System.out.println(i));
						cricketer.values().stream().sorted(Comparator.comparing(Cricketer::getRating).reversed())
								.forEach(i -> System.out.println(i));

						break;
					case 6:
						Collections.sort(ckt, (o1, o2) -> o1.getName().compareTo(o2.getName()));
						ckt.forEach(i -> System.out.println(i));
						break;
					case 7:
						System.out.println("Enter file name");
						dao.writeDetails(sc.next(), cricketer);
						System.out.println("Data saved Successfully!!");
						break;
					case 8:
						System.out.println("File name ");
						dao.readDetails(sc.next());
						System.out.println("Data Restored!!");
						break;

					default:
						System.out.println("Invalid Choice!!");
						break;
					}

				} catch (Exception e) {
					// e.printStackTrace();
					System.out.println(e);
				}
		}

	}

}
