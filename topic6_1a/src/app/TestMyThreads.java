package app;

/**
 * TestMyThreads contains the main() method to run our threads.
 */
public class TestMyThreads {
    public static void main(String[] args) {
        // Create an instance of MyThread1 and start it.
        MyThread1 thread1 = new MyThread1();
        thread1.start();

        // Create an instance of MyThread2 (as Runnable) and pass it to a new Thread instance.
        Runnable myRunnable = new MyThread2();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();
    }
}