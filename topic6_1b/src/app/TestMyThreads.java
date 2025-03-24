package app;

/**
 * TestMyThreads starts MyThread1 and MyThread2 to demonstrate concurrent execution.
 */
public class TestMyThreads {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        thread1.start();

        Runnable myRunnable = new MyThread2();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();
    }
}