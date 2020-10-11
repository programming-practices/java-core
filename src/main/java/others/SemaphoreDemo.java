package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_sredstva_standartnoi_biblioteki;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2, true);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            DemoThread thread = new DemoThread(semaphore);
            threads.add(thread);
            thread.start();
        }
        Thread.sleep(20_000);

        for (Thread thread : threads) {
            thread.interrupt();
        }
    }


    private static class DemoThread extends Thread {
        private final Semaphore semaphore;

        public DemoThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                runUnsafe();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interruped");
            }
        }

        private void runUnsafe() throws InterruptedException {
            for (; ; ) {
                semaphore.acquire();
                try {
                    System.out.println(getName() + " acquiered semaphore");
                    Thread.sleep(5000L);
                } finally {
                    System.out.println(getName() + " release semaphore");
                    semaphore.release();
                }
            }
        }
    }
}
