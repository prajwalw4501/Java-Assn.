package com.app.tester;

import static com.app.utils.ValidationRule.validateItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import com.app.core.Items;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HashMap<String, Items> item = new HashMap<String, Items>();

			boolean exit = false;
			while (!exit)
				try {
					System.out.println("---MENU---" + "\n1.Store Items" + "\n2.Display Items"
							+ "\n3.Sort as per Item Code:" + "\n4.Sort as per Item price:" + "\n0.Exit");
					System.out.println("Enter Choice: ");

					switch (sc.nextInt()) {
					case 1:
						System.out.println("Code,Description,Price,Shipment_date");
						String id = sc.next();
						validateItem(id, item);
						item.put(id, new Items(id, sc.next(), sc.nextDouble(), LocalDate.parse(sc.next())));
						System.out.println("Item Added!!");
						break;
					case 2:
						for (Items i : item.values())
							System.out.println(i);
						break;
					case 3:
//						System.out.println("Enter Item Code: ");
						ArrayList<Items> sortItem = new ArrayList<Items>(item.values());
////						sortItem.stream().sorted().forEach(i -> System.out.println(i));
//						Collections.sort(sortItem);
//						System.out.println(sortItem);
						sortItem.stream().sorted().forEach(i -> System.out.println(i));

						break;
					case 4:
						System.out.println("Enter Price to sort::");
						Stream<Items> sorted = item.values().stream().sorted(new Comparator<Items>() {
							@Override
							public int compare(Items o, Items p) {
								if (o.getPrice() > p.getPrice()) {
									return 1;
								} else if (p.getPrice() < p.getPrice()) {
									return -1;
								}
								return 0;
							}
						});
						sorted.forEach(i -> System.out.println(i));
						break;

					case 0:
						System.exit(0);
						break;

					default:
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
