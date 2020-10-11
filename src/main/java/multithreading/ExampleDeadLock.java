package Examples.Multithreading;

public class ExampleDeadLock {
    public static void main(String[] args) {
        Thread[] threads = new Thread[2];

        threads[0] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threads[1].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threads[1] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threads[0].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threads[0].start();
        threads[1].start();

    }
}
