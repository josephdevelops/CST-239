package app;

/**
 * MyThread2 implements Runnable and prints a message when run.
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("This is MyThread2 class running.");
    }
}