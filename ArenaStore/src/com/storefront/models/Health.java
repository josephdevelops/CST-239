package com.storefront.models;


public class Health extends SalableProduct {
    private int healthRestored;

    public Health(String name, String description, double price, int quantity, int healthRestored) {
        super(name, description, price, quantity);
        this.healthRestored = healthRestored;
    }

    public int getHealthRestored() {
        return healthRestored;
    }

    public void setHealthRestored(int healthRestored) {
        this.healthRestored = healthRestored;
    }

    @Override
    public void use() {
        System.out.println(getName() + " is consumed, restoring " + healthRestored + " health.");
    }
}
