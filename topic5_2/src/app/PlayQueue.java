package app;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The {@code PlayQueue} class demonstrates the use of Java's {@code Queue} interface
 * with {@code LinkedList} implementation.
 */
public class PlayQueue {

    /**
     * The main method demonstrates various queue operations such as adding elements,
     * retrieving the head element, and iterating over elements.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.offer("Mark Reha");
        stringQueue.add("Mary Reha");
        stringQueue.add("Justine Reha");
        stringQueue.add("Jason Huber Reha");
        stringQueue.add("Joseph Abraham Reha");

        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(1);
        integerQueue.offer(-1);
        integerQueue.add(5);
        integerQueue.offer(10);
        integerQueue.add(500);

        System.out.println(integerQueue);
        System.out.printf("IntegerQueue size: %d, head element: %d\n",
                integerQueue.size(), integerQueue.peek());

        // Iterate through the string queue
        Iterator<String> itr = stringQueue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}