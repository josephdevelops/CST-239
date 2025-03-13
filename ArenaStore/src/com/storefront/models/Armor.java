package com.storefront.models;

public class Armor extends SalableProduct {
    private int defense;

    public Armor(String name, String description, double price, int quantity, int defense, int cartQuantity) {
        super(name, description, price, quantity, cartQuantity);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public void use() {
        System.out.println(getName() + " is equipped, providing " + defense + " defense.");
    }
}