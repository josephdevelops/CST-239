package app;

/**
 * The {@code Storage} class represents a simple generic container 
 * that holds a single value of a specified type.
 * 
 * @param <T> the type of data to be stored
 */
public class Storage<T> {
    private T s = null;

    /**
     * Constructs a new {@code Storage} object with the given data.
     * 
     * @param s the data to store
     */
    public Storage(T s) {
        this.s = s;
    }

    /**
     * Retrieves the stored data.
     * 
     * @return the stored data of type {@code T}
     */
    public T getData() {
        return this.s;
    }

    /**
     * The main method demonstrates the usage of the {@code Storage} class
     * with String and Integer data types.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating a Storage object for a String
        Storage<String> storage1 = new Storage<>("Mark Reha");
        System.out.println("This is data: " + storage1.getData());

        // Creating a Storage object for an Integer
        Storage<Integer> storage2 = new Storage<>(0);
        System.out.println("This is data: " + storage2.getData());
    }
}