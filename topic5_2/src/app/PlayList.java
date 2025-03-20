package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The {@code PlayList} class demonstrates the use of Java's {@code ArrayList}
 * for storing and iterating through lists of different data types.
 */
public class PlayList {

    /**
     * The main method demonstrates adding elements to lists, retrieving elements,
     * and iterating through lists using loops and iterators.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(Integer.valueOf(10));
        integerList.add(Integer.valueOf(11));

        List<String> stringList = new ArrayList<>();
        stringList.add("Hello World");
        stringList.add("Hi World");

        System.out.printf("Integer Value: %d\n", integerList.get(0));
        System.out.printf("String Value: %s\n", stringList.get(0));

        // Iterate using enhanced for-loop
        for (Integer data : integerList) {
            System.out.printf("Integer Value: %s\n", data);
        }

        // Iterate using Iterator
        Iterator<String> stringIterator = stringList.iterator();
        while (stringIterator.hasNext()) {
            System.out.printf("String Value: %s\n", stringIterator.next());
        }
    }
}