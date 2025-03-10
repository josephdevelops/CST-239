package com.storefront.models;

//Ensure Java SE 11 compatibility

public abstract class SalableProduct {
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	public SalableProduct(String name, String description, double price, int quantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public abstract void use();
	
	@Override
	public String toString() {
		return name + " - " + description + ", Price: $" + price + ", Quantity:" + quantity;
	}
}


