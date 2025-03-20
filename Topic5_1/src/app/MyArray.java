package app;

/**
 * The {@code MyArray} class demonstrates a generic method 
 * that prints elements of an array.
 */
public class MyArray {

    /**
     * Prints the elements of a generic array.
     * 
     * @param <E> the type of elements in the array
     * @param inputArray the array to be printed
     */
    public <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
    }

    /**
     * The main method demonstrates the usage of the {@code printArray} method
     * with Integer, Double, and Character arrays.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        MyArray ma = new MyArray();

        System.out.println("Array integerArray contains:");
        ma.printArray(intArray);

        System.out.println("\nArray doubleArray contains:");
        ma.printArray(doubleArray);

        System.out.println("\nArray charArray contains:");
        ma.printArray(charArray);
    }
}