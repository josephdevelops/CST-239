package com.storefront.cart;

import java.util.ArrayList;
import java.util.List;

import com.storefront.models.SalableProduct;

public class ShoppingCart {
    private List<SalableProduct> cartItems = new ArrayList<>();

    public void addItem(SalableProduct product) {
        cartItems.add(product);
    }

    public void removeItem(String productName) {
        cartItems.removeIf(product -> product.getName().equalsIgnoreCase(productName));
    }

    public void viewCart() {
        System.out.println("Shopping Cart:");
        for (SalableProduct item : cartItems) {
            System.out.println(item);
        }
    }

    public void checkout() {
        System.out.println("Checking out the following items:");
        viewCart();
        cartItems.clear();
        System.out.println("Checkout complete.");
    }
}
