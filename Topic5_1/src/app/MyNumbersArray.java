package app;

/**
 * The {@code MyNumbersArray} class demonstrates a generic method 
 * restricted to types that extend {@code Number}.
 */
public class MyNumbersArray {

    /**
     * Prints the elements of a numeric array.
     * 
     * @param <E> the type of elements in the array, extending {@code Number}
     * @param inputArray the array to be printed
     */
    public <E extends Number> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
    }

    /**
     * The main method demonstrates the usage of the {@code printArray} method
     * with Integer, Double, and Float arrays.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Float[] floatArray = { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };

        MyNumbersArray ma = new MyNumbersArray();

        System.out.println("Array integerArray contains:");
        ma.printArray(intArray);

        System.out.println("\nArray doubleArray contains:");
        ma.printArray(doubleArray);

        System.out.println("\nArray floatArray contains:");
        ma.printArray(floatArray);
    }
}