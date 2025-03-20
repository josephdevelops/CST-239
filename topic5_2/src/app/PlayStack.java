package app;

import java.util.Iterator;
import java.util.Stack;

/**
 * The {@code PlayStack} class demonstrates the use of Java's {@code Stack} collection.
 * It creates and manipulates stacks of integers and strings.
 */
public class PlayStack {
    
    /**
     * The main method demonstrates various operations on a stack, such as push, pop, and iteration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Mark Reha");
        stringStack.push("Jason Reha");
        stringStack.push("Huber Reha");
        stringStack.push("Joseph Reha");
        stringStack.push("Abraham Reha");

        System.out.println(integerStack);
        System.out.printf("\nInteger Stack size: %d, 2nd element: %d\n",
                integerStack.size(), integerStack.elementAt(1));

        // Iterate through the string stack and pop each element
        Iterator<String> itr = stringStack.iterator();
        while (itr.hasNext()) {
            System.out.println(stringStack.pop());
        }
    }
}