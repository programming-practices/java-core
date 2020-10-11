package Examples.Multithreading.Others.Golovach;

public class Produser implements Runnable {
    private final int id;
    private final int period;
    private final SingleElementBuffer buffer;
    private int value;

    public Produser(int id, int value, int period, SingleElementBuffer buffer) {
        this.id = id;
        this.value = value;
        this.period = period;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(System.currentTimeMillis() + ": " + value + " produce by P#" + id);
                buffer.put(value++);
                Thread.sleep(period);
            } catch (InterruptedException ignore) {/*NOP*/}
        }
    }
}
