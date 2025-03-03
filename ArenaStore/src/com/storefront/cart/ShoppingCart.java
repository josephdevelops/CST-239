package com.storefront.cart;

import java.util.ArrayList;
import java.util.List;

import com.storefront.models.SalableProduct;

public class ShoppingCart {
    private List<SalableProduct> cartItems = new ArrayList<>();

    public void addItem(SalableProduct product) {
        cartItems.add(product);
    }
    /* when user enters '3' this is called indirectly*/
    public void removeItem(String productName) {
        cartItems.removeIf(product -> product.getName().equalsIgnoreCase(productName));
    }

    /* when user enteres '4' */
    public void viewCart() {
        System.out.println("Shopping Cart:");
        for (SalableProduct item : cartItems) {
            System.out.println(item);
        }
    }
    
    /* when user enteres '5' */
    public void checkout() {
        System.out.println("Checking out the following items:");
        viewCart();
        cartItems.clear();
        System.out.println("Checkout complete.");
    }
}
