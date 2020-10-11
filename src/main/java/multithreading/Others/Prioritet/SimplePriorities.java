package multithreading.Others.Prioritet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d; // No optimization
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }

        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));

        exec.shutdown();
    }

    public String toString() {
        return Thread.currentThread() + ": " + countDown + "  Thread priority: " + Thread.currentThread().getPriority();
    }

    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            // An expensive, interruptable operation:
            for (int i = 1; i < 100_000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

}
