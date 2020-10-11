package multithreading.Others.Potoki_Demonu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool(new Examples.Multithreading.Potoki_Demonu.DaemonThreadFactory());

        for (int i = 0; i < 10; i++) exec.execute(new DaemonFromFactory());

        System.out.println("All daemons started");

        TimeUnit.MILLISECONDS.sleep(500); // Run for a while
    }

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
