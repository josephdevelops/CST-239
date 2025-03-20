package app;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code PlayMap} class demonstrates the use of Java's {@code HashMap} for
 * storing and retrieving key-value pairs of various types.
 */
public class PlayMap {

    /**
     * The main method demonstrates how to use HashMap to store and retrieve
     * integer-to-integer, integer-to-string, and string-to-string mappings.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(1, 1);
        integerMap.put(2, 2);
        integerMap.put(3, 3);
        integerMap.put(4, 4);
        integerMap.put(5, 5);

        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "One");
        stringMap.put(2, "Two");
        stringMap.put(3, "Three");
        stringMap.put(4, "Four");
        stringMap.put(5, "Five");

        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("FirstName", "Mark");
        nameMap.put("LastName", "Reha");
        nameMap.put("Occupation", "Teacher");
        nameMap.put("Gender", "Male");
        nameMap.put("Country of Origin", "USA");

        System.out.printf("NameMap Test: size is %d and is empty: %b\n",
                nameMap.size(), nameMap.isEmpty());

        // Iterate through nameMap and print key-value pairs
        for (Map.Entry<String, String> entry : nameMap.entrySet()) {
            System.out.printf("Key: %s, Value: %s\n", entry.getKey(), entry.getValue());
        }

        // Clearing maps
        integerMap.clear();
        stringMap.remove(1);
        stringMap.clear();
        nameMap.clear();
    }
}