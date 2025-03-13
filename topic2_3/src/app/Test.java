package app;

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
        // Create two instances of Person with the same name
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("John", "Doe");

        // Create a third instance using the copy constructor
        Person person3 = new Person(person1);

        // Compare person1 and person2 using '=='
        System.out.println("person1 == person2: " + (person1 == person2)); // Should be false (different memory locations)

        // Compare person1 and person2 using .equals()
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // Should be true (same name values)

        // Compare person1 and person3 using .equals()
        System.out.println("person1.equals(person3): " + person1.equals(person3)); // Should be true (copy constructor maintains values)

        // Print all Person objects using toString()
        System.out.println("Person 1: " + person1);
        System.out.println("Person 2: " + person2);
        System.out.println("Person 3: " + person3);
    }
}