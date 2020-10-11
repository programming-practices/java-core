package Examples.Multithreading;

public class ExampleDeadLockTwo {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[2];
        threads[0] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("#0 join to #1");
                    threads[1].join();
                } catch (InterruptedException e) { /* NOP */}
            }
        });
        threads[1] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("#1 join to #0");
                    threads[0].join();
                } catch (InterruptedException e) { /* NOP */}
            }
        });

        threads[0].start();
        threads[1].start();

    }
}
