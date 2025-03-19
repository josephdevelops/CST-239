package app;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Car class represents a vehicle with details such as year, make, model, odometer reading, and engine size.
 */
public class Car {
    private int year;
    private String make;
    private String model;
    private int odometer;
    private double engineLiters;

    /**
     * Default constructor initializes properties to default values.
     */
    public Car() {
        this.year = 0;
        this.make = "";
        this.model = "";
        this.odometer = 0;
        this.engineLiters = 0.0;
    }

    /**
     * Constructor with parameters to initialize the Car object.
     * 
     * @param year         The manufacturing year of the car.
     * @param make         The brand of the car.
     * @param model        The model of the car.
     * @param odometer     The current mileage of the car.
     * @param engineLiters The engine size in liters.
     */
    @JsonCreator
    public Car(@JsonProperty("year") int year,
               @JsonProperty("make") String make,
               @JsonProperty("model") String model,
               @JsonProperty("odometer") int odometer,
               @JsonProperty("engineLiters") double engineLiters) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.odometer = odometer;
        this.engineLiters = engineLiters;
    }

    // Getters and Setters
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getOdometer() { return odometer; }
    public void setOdometer(int odometer) { this.odometer = odometer; }

    public double getEngineLiters() { return engineLiters; }
    public void setEngineLiters(double engineLiters) { this.engineLiters = engineLiters; }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " (Odometer: " + odometer + " miles, Engine: " + engineLiters + "L)";
    }

    public static void main(String[] args) {
        // Create Car objects
        Car car1 = new Car(2020, "Toyota", "Camry", 50000, 2.5);
        Car car2 = new Car(2018, "Honda", "Civic", 75000, 1.8);

        // Print car details
        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
    }
}