package app;

/**
 * MyThread1 extends Thread and prints a message when run.
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("This is MyThread1 class running.");
    }
}