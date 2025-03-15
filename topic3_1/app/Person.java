package app;

/**
 * The Person class represents an individual with a first name and last name.
 * It includes methods for comparing Person objects and returning their string representation.
 */
public class Person implements PersonInterface, Comparable<Person>{
    private String firstName;
    private String lastName;
    private boolean running;
    private int age;
    
    /**
     * Constructs a Person object with the given first name and last name.
     *
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     * @param age       The age of the person.
     */
    
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.running = false;
        this.age = age;
    }
    
    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void walk() {
    	System.out.println("I am walking");
    	running = false;
    }
    public void run() {
    	System.out.println("I am running");
    	running = true;
    }
    public boolean isRunning() {
    	return running;
    }

    /**
     * Copy constructor that creates a new Person object based on an existing one.
     *
     * @param other The Person object to copy.
     */
    public Person(Person other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.age = other.age;
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
        return firstName.equals(person.firstName) 
        		&& lastName.equals(person.lastName)
        		&& age == person.age;
    }

    /**
     * Returns a string representation of the Person object.
     *
     * @return A formatted string containing the first and last name.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age;
    }

    @Override
    public int compareTo(Person p) {
        int value = this.lastName.compareTo(p.lastName);
        if (value == 0) {
            value = this.firstName.compareTo(p.firstName);
            if (value == 0) {
                return Integer.compare(this.age, p.age);
            }
        }
        return value;
    }
}    