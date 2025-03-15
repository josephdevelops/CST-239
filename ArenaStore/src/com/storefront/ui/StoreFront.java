package com.storefront.ui;

import com.storefront.cart.ShoppingCart;
import com.storefront.managers.InventoryManager;
import com.storefront.models.Armor;
import com.storefront.models.Health;
import com.storefront.models.Weapon;
import com.storefront.models.SalableProduct;

import java.util.Scanner;

/**
 * The StoreFront class represents the user interface for a storefront application.
 * It allows users to view inventory, add/remove products from the shopping cart,
 * checkout, and view past orders.
 */
public class StoreFront {
    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;
    private Scanner scanner;

    /**
     * Constructs a StoreFront instance, initializes the inventory, and sets up the shopping cart.
     */
    public StoreFront() {
        inventoryManager = new InventoryManager();
        setShoppingCart(new ShoppingCart());
        scanner = new Scanner(System.in);
        initializeStore();
    }
    
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Initializes the store with predefined products (weapons, armor, health items).
     */
    private void initializeStore() {
        inventoryManager.addProduct(new Weapon("Sword", "A sharp steel sword", 99.99, 10, 50, 0));
        inventoryManager.addProduct(new Weapon("Axe", "A well-crafted axe", 89.99, 10, 50, 0));
        inventoryManager.addProduct(new Armor("Shield", "A sturdy wooden shield", 79.99, 5, 30, 0));
        inventoryManager.addProduct(new Armor("Helmet", "An iron helmet", 69.99, 5, 30, 0));
        inventoryManager.addProduct(new Health("Minor Potion", "Restores 10 HP", 9.99, 10, 50, 0));
        inventoryManager.addProduct(new Health("Potion", "Restores 50 HP", 19.99, 20, 50, 0));

        System.out.println("Welcome to the Store Front!");
    }

    /**
     * Displays the main menu options for the user.
     */
    public void displayMenu() {
        System.out.println("\n --- \n");
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
                case 1:
                    viewInventory();
                    System.out.println("\n --- \n");
                    break;
                case 2:
                    addToCart();
                    System.out.println("\n --- \n");
                    break;
                case 3:
                    removeFromCart();
                    System.out.println("\n --- \n");
                    break;
                case 4:
                    shoppingCart.viewCart();
                    break;
                case 5:
                    shoppingCart.checkout();
                    break;
                case 6:
                    shoppingCart.pastOrders();
                    displayMenu();
                    break;
                case 7:
                    System.out.println("Exiting the store. Goodbye!");
                    break;
                default:
                    System.out.println("\n --- \n\nInvalid choice. Try again.");
                    displayMenu();
            }
        } while (choice != 7);
        scanner.close();
        System.exit(0);
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
     * @return The ShoppingCart instance.
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Sets the shopping cart instance.
     * 
     * @param shoppingCart The ShoppingCart instance to be assigned.
     */
  
}