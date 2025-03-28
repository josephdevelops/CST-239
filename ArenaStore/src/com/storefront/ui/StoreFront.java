package com.storefront.ui;

import java.util.Scanner;

import com.storefront.cart.ShoppingCart;
import com.storefront.managers.InventoryManager;
import com.storefront.models.SalableProduct;
import json.CreateJson;
import json.LoadJson;

/**
 * The {@code StoreFront} class represents the user interface for the storefront application.
 * It allows users to view inventory, add/remove products from the shopping cart,
 * checkout, and view past orders.
 */
public class StoreFront {
    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;
    private Scanner scanner;

    /**
     * Constructs a {@code StoreFront} instance, initializes the inventory, 
     * and sets up the shopping cart.
     */
    public StoreFront() {
        inventoryManager = new InventoryManager();
        setShoppingCart(new ShoppingCart());
        scanner = new Scanner(System.in);
        initializeStore();
    }

    /**
     * Sets the shopping cart instance.
     *
     * @param shoppingCart The ShoppingCart instance to be assigned.
     */
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Initializes the store with predefined products such as weapons, armor, and health items.
     */
    private void initializeStore() {
        CreateJson.createJsonFile();
        LoadJson.loadInventory(inventoryManager);
    }

    /**
     * Displays the main menu options for the user.
     */
    public void displayMenu() {
        System.out.println("\n --- \n");
        System.out.println("0. Preferences");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. Remove Product from Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Checkout");
        System.out.println("6. Past Orders");
        System.out.println("7. Exit");
        System.out.println("\n --- \n");
        System.out.print("Enter your choice: ");
    }

    /**
     * The main entry point of the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        StoreFront storeFront = new StoreFront();
        storeFront.displayMenu();
        storeFront.handleUserInput();  // Keeps the program running.
    }

    /**
     * Handles user input for navigating the store's options.
     */
    public void handleUserInput() {
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("\n --- \n\nInvalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                displayMenu();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline character

            switch (choice) {                
                case 0:
                    sortInventory();
                    break;
                case 1:
                    viewInventory();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    shoppingCart.viewCart();
                    break;
                case 5:
                    shoppingCart.checkout();
                    break;
                case 6:
                    shoppingCart.pastOrders();
                    break;
                case 7:
                    System.out.println("Exiting the store. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n --- \n\nInvalid choice. Try again.");
            }
            displayMenu();
        } while (choice != 7);
    }

    /**
     * Provides sorting options for inventory based on Name, Price, or Quantity,
     * and lets the user choose ascending or descending order.
     */
    private void sortInventory() {
        System.out.println("\nSort Inventory By:");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Quantity");
        System.out.print("Enter sorting option: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a number (1-3): ");
            scanner.next();
        }
        int sortChoice = scanner.nextInt();
        scanner.nextLine();

        // New prompt for sort order
        System.out.println("Choose order: 1 for Ascending, 2 for Descending");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a number (1-2): ");
            scanner.next();
        }
        int orderChoice = scanner.nextInt();
        scanner.nextLine();
        boolean ascending = (orderChoice == 1); // true for ascending, false for descending
        
        switch (sortChoice) {
            case 1:
                inventoryManager.sortByName(ascending);
                System.out.println("Inventory sorted by Name in " + (ascending ? "Ascending" : "Descending") + " order.");
                break;
            case 2:
                inventoryManager.sortByPrice(ascending);
                System.out.println("Inventory sorted by Price in " + (ascending ? "Ascending" : "Descending") + " order.");
                break;
            case 3:
                inventoryManager.sortByQuantity(ascending);
                System.out.println("Inventory sorted by Quantity in " + (ascending ? "Ascending" : "Descending") + " order.");
                break;
            default:
                System.out.println("Invalid option. Returning to main menu.");
        }
    }

    /**
     * Displays the available inventory.
     */
    private void viewInventory() {
        System.out.println("\nAvailable Products:");
        for (SalableProduct product : inventoryManager.getProducts()) {
            System.out.println(product);
        }
    }

    /**
     * Adds a product to the shopping cart.
     * Users must enter the product name.
     */
    private void addToCart() {
        System.out.print("Enter the product name to add: ");
        String productName = scanner.nextLine().trim();
        SalableProduct product = inventoryManager.getProductByName(productName);

        if (product != null && product.getQuantity() > 0) {
            shoppingCart.addItem(product);
            product.setQuantity(product.getQuantity() - 1);
            product.setCartQuantity(product.getCartQuantity() + 1);
            System.out.println("1 " + productName + " added to cart.");
        } else {
            System.out.println("Product not available or out of stock.");
        }
    }

    /**
     * Removes a product from the shopping cart.
     * Users must enter the product name.
     */
    private void removeFromCart() {
        System.out.print("Enter the product name to remove: ");
        String productName = scanner.nextLine().trim();
        SalableProduct product = inventoryManager.getProductByName(productName);

        if (product != null && product.getCartQuantity() > 1) {
            System.out.println(productName + " removed from cart.");
            product.setQuantity(product.getQuantity() + 1);
            product.setCartQuantity(product.getCartQuantity() - 1);
        } else if (product != null && product.getCartQuantity() > 0) {
            shoppingCart.removeItem(productName);
            System.out.println(productName + " removed from cart.");
        } else {
            System.out.println(productName + " is not in the cart.");
        }
    }

    /**
     * Gets the shopping cart instance.
     *
     * @return The {@code ShoppingCart} instance.
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}