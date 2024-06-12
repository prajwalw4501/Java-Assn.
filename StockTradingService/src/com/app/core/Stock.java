package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Stock implements Serializable {
private String id;
private String stock_name;
private String company;
private double price;
private LocalDate closing_date;
private int quantity;

public Stock(String id, String stock_name, String company, double price, LocalDate closing_date, int quantity) {
	super();
	this.id = id;
	this.stock_name = stock_name;
	this.company = company;
	this.price = price;
	this.closing_date = closing_date;
	this.quantity = quantity;
}

@Override
public String toString() {
	return "Stock-- Id=" + id + ", Stock_name=" + stock_name + ", Company=" + company + ", Price=" + price
			+ ", closing_date=" + closing_date + ", quantity=" + quantity + "]";
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getStock_name() {
	return stock_name;
}

public void setStock_name(String stock_name) {
	this.stock_name = stock_name;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public LocalDate getClosing_date() {
	return closing_date;
}

public void setClosing_date(LocalDate closing_date) {
	this.closing_date = closing_date;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}





}
