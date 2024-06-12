package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.entities.Color;
import com.app.entities.Pen;

public class Admin {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Pen> pens = new ArrayList<>();
			boolean flag = false;
			while (!false) {
				System.out.println("---MENU---\n" + "1. Add a New Pen\n" + "2.Update Stock\n" + "3. Set Discount\n"
						+ "4.Remove Pens\n" + "0. Exit");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("--Enter Pen Details--\n"
								+ "Brand Name:  Color:  Material:  Stock:  Update Date:  Listing Date:  Price:  Discount:  ");
						Pen pen = new Pen(sc.next(), Color.valueOf(sc.next().toUpperCase()), sc.next(), sc.nextDouble(),
								LocalDate.parse(sc.next()), LocalDate.parse(sc.next()), sc.nextDouble(),
								sc.nextDouble());
						pens.add(pen);
						System.out.println(pens);

						break;

					default:
						break;
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
