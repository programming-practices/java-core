package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_sredstva_standartnoi_biblioteki;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; ++i) {
            new DemoThread(latch).start();
        }
    }

    private static class DemoThread extends Thread {
        private final CountDownLatch latch;

        public DemoThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                runUnsafe();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrypted");
            }
        }

        public void runUnsafe() throws InterruptedException {
            // inicialization phase
            Thread.sleep((long) (Math.random() * 10000L));

            System.out.println(getName() + " finished initialization");

            latch.countDown();
            latch.await();

            System.out.println(getName() + " entered main phase");

            // main phase
            Thread.sleep((long) (Math.random() * 10000L));
        }
    }

}
