package Examples.Multithreading.Others.Golovach;

import static java.lang.System.currentTimeMillis;

public class Producer implements Runnable {
    private final int period;
    private final SingleElementBuffer buffer;
    private int startValue;

    public Producer(int startValue, int period, SingleElementBuffer buffer) {
        this.buffer = buffer;
        this.period = period;
        this.startValue = startValue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(currentTimeMillis() + ":" + " produced " + startValue);
                buffer.put(startValue++);
                Thread.sleep(period);
            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName() + " stopped");
//                break;
            }
        }
    }
}
