package Examples.Multithreading.Vzaimodeistvie_potokov_ispolnenia;

public class Producer implements Runnable {
    SynchronizedQueue synchronizedQueue;

    Producer(SynchronizedQueue synchronizedQueue) {
        this.synchronizedQueue = synchronizedQueue;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;

        while (true) {
            synchronizedQueue.put(i++);
        }
    }
}
