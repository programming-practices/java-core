package Examples.Multithreading.Vzaimodeistvie_potokov_ispolnenia;

public class Consumer implements Runnable {
    SynchronizedQueue synchronizedQueue;

    Consumer(SynchronizedQueue synchronizedQueue) {
        this.synchronizedQueue = synchronizedQueue;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            synchronizedQueue.get();
        }
    }
}
