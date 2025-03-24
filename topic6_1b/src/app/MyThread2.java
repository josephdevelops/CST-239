package app;

/**
 * MyThread2 implements Runnable and executes 100 iterations.
 * In each iteration, it prints a unique message and sleeps for 500 milliseconds.
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("MyThread2 - iteration: " + i);
            try {
                Thread.sleep(500); // Sleep for 0.5 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}