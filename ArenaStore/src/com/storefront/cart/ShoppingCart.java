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
        if (cartItems.isEmpty()) {
            System.out.println("\nYour cart is empty.\n");
        } else {
            double totalCartCost = 0.0; // Track total cost of the shopping cart

            for (SalableProduct item : cartItems) {
                int orderQuantity = item.getCartQuantity();
                double totalPrice = orderQuantity * item.getPrice(); // Calculate total for item
                totalCartCost += totalPrice; // Add to total cart cost

                System.out.println(orderQuantity + " x " + item.getName() + " - $" + String.format("%.2f", totalPrice));
            }

            // Display the total cost of the cart
            System.out.println("Total Cost: $" + String.format("%.2f", totalCartCost));
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
            System.out.println("Nothing was purchased because cart was empty.");
        } else {
            // Capture the date and time of the order
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = now.format(formatter);

            // Save the order with a timestamp
            StringBuilder orderDetails = new StringBuilder();
            orderDetails.append("Order Date: ").append(formattedDate).append("\n");

            double totalOrderCost = 0.0; // Track total cost of the order

            for (SalableProduct item : cartItems) {
            	int orderQuantity = item.getCartQuantity(); 
                double totalPrice = orderQuantity * item.getPrice(); // Calculate total price for that item
                totalOrderCost += totalPrice; // Add to total order cost
                
                orderDetails.append(orderQuantity) // Display quantity first
                            .append(" x ")
                            .append(item.getName()) // Then product name
                            .append(" - $")
                            .append(String.format("%.2f", totalPrice)) // Format price to 2 decimal places
                            .append("\n");
            }
         // Add total cost at the end of the order summary
            orderDetails.append("Total Cost: $").append(String.format("%.2f", totalOrderCost)).append("\n");

            pastOrders.add(orderDetails.toString()); // Store past order
        	
            resetCartQuantities();
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