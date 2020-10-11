package Examples.Multithreading.Others.Golovach;

import static java.lang.System.currentTimeMillis;

public class Consumer1 implements Runnable {
    private final int id;
    private final SingleElementBuffer buffer;

    public Consumer1(int id, SingleElementBuffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer element = buffer.get();
                System.out.println(currentTimeMillis() + ":" + " consumed by " + id);
                System.out.println();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopped.");
                return;
            }
        }
    }
}
