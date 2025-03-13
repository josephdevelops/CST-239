package com.storefront.cart;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.storefront.models.SalableProduct;

public class ShoppingCart {
    private List<SalableProduct> cartItems = new ArrayList<>();
    private List<String> pastOrders = new ArrayList<>(); // Store past orders with timestamps

    public void addItem(SalableProduct product) {
        if (product.getCartQuantity() <= 0) {
            cartItems.add(product);
        }
    }

    /* when user enters '3' this is called indirectly */
    public void removeItem(String productName) {
        cartItems.removeIf(product -> product.getName().equalsIgnoreCase(productName));
    }

    /* when user enters '4' */
    public void viewCart() {
        System.out.println("\nShopping Cart:");
        for (SalableProduct item : cartItems) {
            System.out.println(item);
        }
        if (cartItems.isEmpty()) {
            System.out.println("\nYour cart is empty.\n");
        }
    }

    /* when user enters '5' */
    
    public void resetCartQuantities() {
        for (SalableProduct item : cartItems) {
            item.setCartQuantity(0); // Reset each item's cart quantity since they will have been bought
        }
    }
    
    public void checkout() {
        System.out.println("Checking out the following items:");
        viewCart();

        if (cartItems.isEmpty()) {
            System.out.println("Nothing was purchased.");
        } else {
        	resetCartQuantities();
            // Capture the date and time of the order
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = now.format(formatter);

            // Save the order with a timestamp
            StringBuilder orderDetails = new StringBuilder();
            orderDetails.append("Order Date: ").append(formattedDate).append("\n");

            for (SalableProduct item : cartItems) {
                orderDetails.append(item.toString()).append("\n");
            }

            pastOrders.add(orderDetails.toString()); // Store past order

            cartItems.clear(); // Clear cart after checkout
            System.out.println("Checkout complete. Your order has been saved.");
        }
    }

    /* when user enters '6' */
    public void pastOrders() {
        System.out.println("\n--- Past Orders ---");
        if (pastOrders.isEmpty()) {
            System.out.println("No past orders found.");
        } else {
            for (String order : pastOrders) {
                System.out.println(order);
            }
        }
    }
}