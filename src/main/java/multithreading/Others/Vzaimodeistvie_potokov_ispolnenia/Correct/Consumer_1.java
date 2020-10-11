package Examples.Multithreading.Vzaimodeistvie_potokov_ispolnenia.Correct;

public class Consumer_1 implements Runnable {
    SynchronizedQueue_1 synchronizedQueue;

    Consumer_1(SynchronizedQueue_1 synchronizedQueue) {
        this.synchronizedQueue = synchronizedQueue;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            synchronizedQueue.get();
        }
    }
}
