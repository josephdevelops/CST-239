package app;

/**
 * MyThread1 extends Thread and executes 100 iterations.
 * In each iteration, it prints a unique message and sleeps for 1000 milliseconds.
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("MyThread1 - iteration: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}