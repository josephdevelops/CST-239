package com.storefront.models;

//Ensure Java SE 11 compatibility

public abstract class SalableProduct {
	private String name;
	private String description;
	private double price;
	private int quantity;
	private int cartQuantity;
	
	public SalableProduct(String name, String description, double price, int quantity, int cartQuantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.cartQuantity = cartQuantity;
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
	
	public int getCartQuantity() {
		return cartQuantity;
	}
	
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	
	
	@Override
	public String toString() {
		return name + " - " + description + ", Price: $" + price + ", Stock:" + quantity + ", Cart:" + cartQuantity;
	}
}


