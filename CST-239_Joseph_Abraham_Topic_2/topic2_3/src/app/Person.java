package app;

import java.util.Objects;

/**
 * The Person class represents an individual with a first name and last name.
 * It includes methods for comparing Person objects and returning their string representation.
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Constructs a Person object with the given first name and last name.
     *
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Copy constructor that creates a new Person object based on an existing one.
     *
     * @param other The Person object to copy.
     */
    public Person(Person other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
    }

    /**
     * Retrieves the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retrieves the last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Compares this Person object to another object for equality.
     * Returns true if both first names and last names are identical.
     *
     * @param obj The object to compare with.
     * @return true if both objects have the same first and last name, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if same memory reference
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    /**
     * Returns a string representation of the Person object.
     *
     * @return A formatted string containing the first and last name.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}