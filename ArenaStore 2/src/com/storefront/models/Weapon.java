package com.storefront.models;

public class Weapon extends SalableProduct {
    private int damage;

    public Weapon(String name, String description, double price, int quantity, int damage, int cartQuantity) {
        super(name, description, price, quantity, cartQuantity);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void use() {
        System.out.println(getName() + " is used to deal " + damage + " damage.");
    }
}
