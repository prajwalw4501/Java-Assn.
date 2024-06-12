package com.app.utils;

import java.time.LocalDate;
import java.util.HashMap;

import com.app.core.Stock;

public class CollectionUtility {
	public static HashMap<String, Stock> populateMap() {
		HashMap<String, Stock> stocks = new HashMap<String, Stock>();
		stocks.put("101", new Stock("101", "Adani Power", "Adani", 450, LocalDate.parse("2024-06-11"), 20));
		stocks.put("102", new Stock("102", "Adani Green", "Adani", 1850, LocalDate.parse("2024-07-11"), 10));
		stocks.put("103", new Stock("103", "Adani Ports", "Adani", 1350, LocalDate.parse("2024-08-11"), 30));
		stocks.put("104", new Stock("104", "Tata Power", "Tata", 440, LocalDate.parse("2024-09-11"), 50));
		stocks.put("105", new Stock("105", "Tata Steel", "Tata", 170, LocalDate.parse("2024-10-11"), 60));
//		System.out.println(stocks);
		return stocks;
	}
}
