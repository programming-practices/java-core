package Examples.Multithreading.Others.Golovach;

public class Consumer implements Runnable {
    private final int id;
    private final SingleElementBuffer buffer;

    public Consumer(int id, SingleElementBuffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer element = buffer.get();
                System.out.println("  " + System.currentTimeMillis() + ": " + element + " consumed by C#" + id);
            } catch (InterruptedException ignore) {/*NOP*/}
        }

    }
}
