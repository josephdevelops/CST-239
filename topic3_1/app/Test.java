package app;

import java.util.Arrays;

/**
 * The Test class demonstrates object comparison and string representation of Person objects.
 */
public class Test {
    /**
     * The main method creates Person objects and compares them using different techniques.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create instances of Person with different last names
        Person[] people = {
            new Person("John", "Doe", 33),
            new Person("Alice", "Smith", 21),
            new Person("Bob", "Johnson", 44),
            new Person("Charlie", "Brown", 55),
            new Person("David", "Adams", 66)
        };

        // Print the unsorted list
        System.out.println("Before Sorting:");
        printPeople(people);

        // Sort the array by last name using Arrays.sort()
        Arrays.sort(people);
        System.out.println("\nAfter Sorting (by last name, then first name):");
        printPeople(people);

        // Shuffle the array manually to demonstrate sorting again
        swap(people, 0, 3);
        swap(people, 1, 4);
        
        System.out.println("\nAfter Reordering:");
        printPeople(people);

        // Sort again
        Arrays.sort(people);
        System.out.println("\nAfter Sorting Again:");
        printPeople(people);

        // Demonstrate equality checks
        Person person1 = new Person("John", "Doe", 77);
        Person person2 = new Person("John", "Doe", 88);
        Person person3 = new Person(person1);

        System.out.println("\nEquality Checks:");
        System.out.println("person1 == person2: " + (person1 == person2)); // False (different memory locations)
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // True (same values)
        System.out.println("person1.equals(person3): " + person1.equals(person3)); // True (copy constructor maintains values)

        // Demonstrate walk/run behavior
        System.out.println("\nWalk and Run Behavior:");
        person1.walk();
        person1.run();
        System.out.println("Person 1 is running: " + person1.isRunning());
        person1.walk();
        System.out.println("Person 1 is running: " + person1.isRunning());
    }

    /**
     * Prints an array of Person objects.
     *
     * @param people The array of Person objects to print.
     */
    private static void printPeople(Person[] people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param array The array of Person objects.
     * @param i First index to swap.
     * @param j Second index to swap.
     */
    private static void swap(Person[] array, int i, int j) {
        Person temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}