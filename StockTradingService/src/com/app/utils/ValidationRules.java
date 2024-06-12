package com.app.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;

import com.app.core.Stock;
import com.app.exception.DuplicateStockExcp;
import com.app.exception.FutureDateExcep;

public class ValidationRules {
	public static Stock validateStock(HashMap<String, Stock> map, String id) throws DuplicateStockExcp {
		Stock stocks = map.get(id);
		if (map.containsKey(id))
			throw new DuplicateStockExcp("Already in Market");
		return stocks;
	}

	public static LocalDate validateFutureDate(String date) throws FutureDateExcep {
		if (LocalDate.parse(date).isBefore(LocalDate.now()))
			throw new FutureDateExcep("Enter Expiry Date!!");
		return LocalDate.parse(date);
	}

	public static String purchaseStocks(String id, int quant, HashMap<String, Stock> map) throws DuplicateStockExcp {
		for (Stock s : map.values())
			if (map.containsKey(id)) {
				s.setQuantity(quant + s.getQuantity());
				System.out.println(quant + " Stocks Purchased");
				return id;
			}
		throw new DuplicateStockExcp("ID NOT FOUND!!");
	}

	public static String sellStocks(String id, int quant, HashMap<String, Stock> map) throws DuplicateStockExcp {
		for (Stock s : map.values())
			if (map.containsKey(id)) {
				s.setQuantity(s.getQuantity() - quant);
				System.out.println(quant + " Stocks Sold!");
				return id;
			}
		throw new DuplicateStockExcp("ID NOT FOUND!!");
	}

	public static void writeDetails(String file, HashMap<String, Stock> map) throws IOException {
//		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
//			out.writeObject(map);
//		}
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.append(map.toString());
		}

	}

//	@SuppressWarnings("unchecked")
	public static void readDetails(String file, HashMap<String, Stock> stock)
			throws IOException, ClassNotFoundException, FileNotFoundException {
//		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
//			return (HashMap<String, Stock>) in.readObject();

//		}
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bf.readLine()) != null) {
//				System.out.println(line + "\n");
				for (Stock s : stock.values())
					System.out.println(s);

				return;
			}
		}
		throw new FileNotFoundException("enter Valid filname");
	}
}
