package com.app.utility;

import java.time.LocalDate;

import com.app.entities.Color;
import com.app.entities.Pen;

public class PenUtility {
	Pen pen;

	public Pen validatePen(String brand, Color color, String material, double stock, LocalDate update_date,
			LocalDate listing_date, double price, double discount) {
		pen = new Pen(brand, color, material, stock, update_date, listing_date, price, discount);
		return pen;
	}

}
