package com.app.entities;

import java.time.LocalDate;

public class Pen {
private int id=1;
private String brand;
private Color color;
private String material;
private double stock;
private LocalDate update_date;
private LocalDate listing_date;
private double price;
private double discount;
public static int counter=0;


public Pen(String brand, Color color, String material, double stock, LocalDate update_date,
		LocalDate listing_date, double price, double discount) {
	super();
	this.id =++counter;
	this.brand = brand;
	this.color = color;
	this.material = material;
	this.stock = stock;
	this.update_date = update_date;
	this.listing_date = listing_date;
	this.price = price;
	this.discount = discount;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public Color getColor() {
	return color;
}
public void setColor(Color color) {
	this.color = color;
}
public String getMaterial() {
	return material;
}
public void setMaterial(String material) {
	this.material = material;
}
public double getStock() {
	return stock;
}
public void setStock(double stock) {
	this.stock = stock;
}
public LocalDate getUpdate_date() {
	return update_date;
}
public void setUpdate_date(LocalDate update_date) {
	this.update_date = update_date;
}
public LocalDate getListing_date() {
	return listing_date;
}
public void setListing_date(LocalDate listing_date) {
	this.listing_date = listing_date;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;

}
@Override
public String toString() {
	return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", material=" + material + ", stock=" + stock
			+ ", update_date=" + update_date + ", listing_date=" + listing_date + ", price=" + price + ", discount="
			+ discount + "]";
}



}
