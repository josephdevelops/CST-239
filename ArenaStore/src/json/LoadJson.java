package json;

import com.storefront.managers.InventoryManager;
import com.storefront.models.Armor;
import com.storefront.models.Health;
import com.storefront.models.Weapon;
import com.storefront.models.SalableProduct;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadJson {
    
    /**
     * Loads inventory from the JSON file into the InventoryManager.
     *
     * @param inventoryManager The InventoryManager instance to populate.
     */
    public static void loadInventory(InventoryManager inventoryManager) {
        String filePath = "inv.json";

        // Check if inv.json exists
        if (!Files.exists(Paths.get(filePath))) {
            System.out.println("inv.json not found! Please create the file.");
            return;
        }

        try {
            // Read JSON file as a string
            String jsonContent = Files.readString(Paths.get(filePath)).trim();
            jsonContent = jsonContent.substring(1, jsonContent.length() - 1); // Remove [ ] brackets

            String[] items = jsonContent.split("},\\s*\\{"); // Split JSON objects
            for (String item : items) {
                item = item.trim();
                if (!item.startsWith("{")) item = "{" + item;
                if (!item.endsWith("}")) item += "}";

                // Extract item properties
                String type = extractValue(item, "\"type\"");
                String name = extractValue(item, "\"name\"");
                String description = extractValue(item, "\"description\"");
                double price = safeParseDouble(extractValue(item, "\"price\""), 0.0);
                int quantity = safeParseInt(extractValue(item, "\"quantity\""), 0);
                int cartQuantity = safeParseInt(extractValue(item, "\"cartQuantity\""), 0);

                SalableProduct product = null;

                // Create product object based on type
                if (type.equalsIgnoreCase("Weapon")) {
                    int damage = safeParseInt(extractValue(item, "\"damage\""), 0);
                    product = new Weapon(name, description, price, quantity, damage, cartQuantity);
                } else if (type.equalsIgnoreCase("Armor")) {
                    int defense = safeParseInt(extractValue(item, "\"defense\""), 0);
                    product = new Armor(name, description, price, quantity, defense, cartQuantity);
                } else if (type.equalsIgnoreCase("Health")) {
                    int healthRestored = safeParseInt(extractValue(item, "\"healthRestored\""), 0);
                    product = new Health(name, description, price, quantity, healthRestored, cartQuantity);
                }

                if (product != null) {
                    inventoryManager.addProduct(product);
                }
            }

            System.out.println("✅ Inventory successfully loaded from inv.json!");

        } catch (IOException e) {
            System.out.println("!!!Error loading inv.json");
            e.printStackTrace();
        }
    }

    /**
     * Extracts a value from a JSON-like string.
     */
    private static String extractValue(String json, String key) {
        int start = json.indexOf(key);
        if (start == -1) return "";

        start = json.indexOf(":", start) + 1;
        int end = json.indexOf(",", start);
        if (end == -1) end = json.indexOf("}", start);

        if (start == -1 || end == -1 || end <= start) return "";

        return json.substring(start, end).trim().replaceAll("[\"{}]", "");  
    }

    /**
     * Safely parses an integer.
     */
    private static int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * Safely parses a double.
     */
    private static double safeParseDouble(String value, double defaultValue) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}