package com.app.tester;

import static com.app.utils.CollectionUtility.populateMap;
import static com.app.utils.ValidationRules.purchaseStocks;
import static com.app.utils.ValidationRules.readDetails;
import static com.app.utils.ValidationRules.sellStocks;
import static com.app.utils.ValidationRules.*;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Stock;

public class Dashboard {
	static HashMap<String, Stock> stock = populateMap();
//	TreeMap<String, Stock>stocks= new TreeMap<String, Stock>(stock);

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			while (!exit)
				try {
					System.out.println("---MENU---" + "\n1.Sample Stocks:" + "\n2.Add new Stocks:"
							+ "\n3.View Available stocks by Company:" + "\n4.Purchase stocks:" + "\n5.Sell Stocks"
							+ "\n6.Save n Exit" + "\n0.Exit");
					System.out.println("Enter Your choice: ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("SAMPLE");
//						HashMap<String, Stock> stocks = populateMap();
						for (Stock s : stock.values())
							System.out.println(s);

						break;
					case 2:
						System.out.println("Enter Stock Id: ");
						String ids = sc.next();
						validateStock(stock, ids);
						System.out.println("stock_name,company, price, closing_date, quantity");
						stock.put(ids, new Stock(ids, sc.next(), sc.next(), sc.nextDouble(),
								validateFutureDate(sc.next()), sc.nextInt()));
//						System.out.println("Stock Added In Market!!");
//						Stock st = stock.remove(ids);
//						System.out.println(ids);
//						System.out.println(st);

						break;
					case 3:
						System.out.println("Enter Company Name: ");
//						stock.values().stream().filter(i -> i.getCompany().equals(sc.next()))
//								.forEach(j -> System.out.println(j));
						for (Stock s : stock.values())
							if (s.getCompany().equals(sc.next()))
								System.out.println(s);
						break;
					case 4:

						System.out.println("Enter id and Quantity:");
						String id = sc.next();
						int quant = sc.nextInt();
						purchaseStocks(id, quant, stock);
						stock.values().stream().filter(i -> i.getId().equals(id)).forEach(i -> System.out.println(i));

						break;
					case 5:
						System.out.println("Enter id and Quantity:");
						String ref = sc.next();
						sellStocks(ref, sc.nextInt(), stock);
						stock.values().stream().filter(i -> i.getId().equals(ref)).forEach(i -> System.out.println(i));
						break;
					case 6:
						System.out.println("Enter FileName to SAVE: ");
						writeDetails(sc.next(), stock);
						System.out.println("DATA Saved!!");
						break;
					case 7:
						System.out.println("Enter FileName to Retrieve: ");
//						 readDetails = readDetails(sc.next());
						readDetails(sc.next(), stock);
//						readDetails.forEach((k, v) -> System.out.println(v));

						System.out.println("DATA Retrieved!!");

						break;
					case 0:
						System.exit(0);
						break;

					default:
						System.out.println("Invalid Choice!!!");
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
