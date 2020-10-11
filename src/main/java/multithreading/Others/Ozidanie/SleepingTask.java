package Examples.Multithreading.Ozidanie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends Examples.Multithreading.Opredilenie_Zadach.LiftOff {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) exec.execute(new SleepingTask());

        exec.shutdown();
    }

    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.print(status());
                // Old-style:
                // Thread.sleep(100);
                // Java SE5/6-style:
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }
}
