package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


// I COULN'D GET IMPORTS TO WORK, KEPT GETTING AN ERROR.
// I GOT THE ONE ON CAR.JAVA TO WORK.
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.type.TypeReference;



/**
 * The DemoJsonFiles class provides functionality to serialize and deserialize a list of Car objects
 * to and from a file in a CSV-like format.
 */
public class DemoJsonFiles {

    /**
     * Saves a list of Car objects to a text file.
     * If the file already contains data, it appends new data instead of overwriting.
     *
     * @param filename The name of the file where the data will be stored.
     * @param newCars  The list of Car objects to be serialized and saved.
     */
    private static void saveToFile(String filename, List<Car> newCars) {
        List<Car> existingCars = readFromFile(filename); // Read existing cars from file
        existingCars.addAll(newCars); // Merge new cars with existing data

        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Car car : existingCars) {
                // Store as CSV-like format: year,make,model,odometer,engineLiters
                pw.println(car.getYear() + "," + car.getMake() + "," + car.getModel() + "," +
                        car.getOdometer() + "," + car.getEngineLiters());
            }
            System.out.println("Cars successfully saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a list of Car objects from a file.
     *
     * @param filename The name of the file containing the car data.
     * @return A list of Car objects deserialized from the file.
     */
    private static List<Car> readFromFile(String filename) {
        List<Car> cars = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            return cars; // Return empty list if file doesn't exist
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split line by comma
                String[] tokens = line.split(",");
                if (tokens.length == 5) {  // Ensure valid data format
                    int year = Integer.parseInt(tokens[0]);
                    String make = tokens[1];
                    String model = tokens[2];
                    int odometer = Integer.parseInt(tokens[3]);
                    double engineLiters = Double.parseDouble(tokens[4]);

                    // Create a new Car object and add to list
                    cars.add(new Car(year, make, model, odometer, engineLiters));
                }
            }
            System.out.println("Cars successfully loaded from " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    /**
     * The main method that demonstrates saving and reading Car objects using text-based serialization.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        String filename = "cars.json"; // Storing as a simple text-based file

        // New cars to be added
        List<Car> newCars = new ArrayList<>();
        newCars.add(new Car(2023, "Tesla", "Model S", 10000, 2.0));
        newCars.add(new Car(2021, "BMW", "X5", 30000, 3.0));

        // Save new cars to file without overwriting
        System.out.println("Saving Cars...");
        saveToFile(filename, newCars);

        // Read from file and reconstruct cars
        System.out.println("\nReading Cars from File...");
        List<Car> loadedCars = readFromFile(filename);

        // Display loaded cars
        System.out.println("\nCars Loaded:");
        for (Car car : loadedCars) {
            System.out.println(car);
        }
    }
}