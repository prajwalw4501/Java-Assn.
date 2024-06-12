package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public class Items implements Comparable<Items>, Serializable {
	private String code;
	private String description;
	private double price;
	private LocalDate shipment_date;

	public Items(String code, String description, double price, LocalDate shipment_date) {
		super();
		this.code = code;
		this.description = description;
		this.price = price;
		this.shipment_date = shipment_date;
	}

	@Override
	public String toString() {
		return "Items [code=" + code + ", description=" + description + ", price=" + price + ", shipment_date="
				+ shipment_date + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getShipment_date() {
		return shipment_date;
	}

	public void setShipment_date(LocalDate shipment_date) {
		this.shipment_date = shipment_date;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Items) {
			return this.code.equals(((Items) obj).code);

		}
		return false;
	}

	@Override
	public int compareTo(Items o) {

		return this.code.compareTo(((Items) o).code);
	}

}
