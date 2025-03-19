package json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateJson {
    public static void createJsonFile() {
        // Define file path
        String filePath = "inv.json";

        // Check if file already exists
        if (Files.exists(Paths.get(filePath))) {
            System.out.println("Wecome friend. Your data: " + filePath);
            return; // Exit the method without creating a new file
        }

        // JSON content formatted as a valid String for JRE 11
        String jsonContent = "[\n"
                + "  {\n"
                + "    \"type\": \"Weapon\",\n"
                + "    \"name\": \"Sword\",\n"
                + "    \"description\": \"A sharp steel sword\",\n"
                + "    \"price\": 99.99,\n"
                + "    \"quantity\": 10,\n"
                + "    \"cartQuantity\": 0\n"
                + "  },\n"
                + "  {\n"
                + "    \"type\": \"Weapon\",\n"
                + "    \"name\": \"Axe\",\n"
                + "    \"description\": \"A heavy battle axe\",\n"
                + "    \"price\": 89.99,\n"
                + "    \"quantity\": 8,\n"
                + "    \"damage\": 7,\n"
                + "    \"cartQuantity\": 0\n"
                + "  },\n"
                + "  {\n"
                + "    \"type\": \"Armor\",\n"
                + "    \"name\": \"Shield\",\n"
                + "    \"description\": \"A sturdy wooden shield\",\n"
                + "    \"price\": 79.99,\n"
                + "    \"quantity\": 5,\n"
                + "    \"defense\": 10,\n"
                + "    \"cartQuantity\": 0\n"
                + "  },\n"
                + "  {\n"
                + "    \"type\": \"Armor\",\n"
                + "    \"name\": \"Helmet\",\n"
                + "    \"description\": \"A reinforced steel helmet\",\n"
                + "    \"price\": 69.99,\n"
                + "    \"quantity\": 7,\n"
                + "    \"defense\": 5,\n"
                + "    \"cartQuantity\": 0\n"
                + "  },\n"
                + "  {\n"
                + "    \"type\": \"Health\",\n"
                + "    \"name\": \"Minor Potion\",\n"
                + "    \"description\": \"Restores 10 HP\",\n"
                + "    \"price\": 9.99,\n"
                + "    \"quantity\": 15,\n"
                + "    \"healthRestored\": 5,\n"
                + "    \"cartQuantity\": 0\n"
                + "  },\n"
                + "  {\n"
                + "    \"type\": \"Health\",\n"
                + "    \"name\": \"Potion\",\n"
                + "    \"description\": \"Restores 50 HP\",\n"
                + "    \"price\": 19.99,\n"
                + "    \"quantity\": 20,\n"
                + "    \"healthRestored\": 50,\n"
                + "    \"cartQuantity\": 0\n"
                + "  }\n"
                + "]";

        try {
            Files.write(Paths.get(filePath), jsonContent.getBytes());  // Write JSON content to file
            System.out.println("Welcome stranger! Your data: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing JSON file");
            e.printStackTrace();
        }
    }
}