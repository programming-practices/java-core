package Examples.Multithreading.Others.Golovach;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FalseSharingDetector {

    volatile static long value00 = 0;
    volatile static long value01 = 0;
    volatile static long value02 = 0;
    volatile static long value03 = 0;
    volatile static long value04 = 0;
    volatile static long value05 = 0;
    volatile static long value06 = 0;
    volatile static long value07 = 0;
    volatile static long value08 = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        final CountDownLatch latch00 = new CountDownLatch(2);
        final CountDownLatch latch01 = new CountDownLatch(2);
        pool.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                latch00.countDown();  // Thread #1 ready
                latch00.await();     // Wait for start signal
                long startTimer = System.nanoTime();
                for (int i = 0; i < 1_000_000_000; i++) {
                    value00 = value00 * i;
                }
                long endTimer = System.nanoTime();
                System.out.println((endTimer - startTimer) / 1_000_000 + " ms");
                latch01.countDown();  // Thread #1 finished
                return null;
            }
        });
        pool.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                latch00.countDown();  // Thread #2 ready
                latch00.await();     // Wait for start signal
                long startTimer = System.nanoTime();
                for (int i = 0; i < 1_000_000_000; i++) {
                    value01 = value01 * i;
                }
                long endTimer = System.nanoTime();
                System.out.println((endTimer - startTimer) / 1_000_000 + " ms");
                latch01.countDown();  // Thread #2 finished
                return null;
            }
        });
        latch01.await();   // Wait for #1 + #2 threads finished
        pool.shutdownNow();  // Kill tread pool

    }
}
