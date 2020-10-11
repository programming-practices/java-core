package Examples.Multithreading.Vzaimodeistvie_potokov_ispolnenia.Correct;

public class Producer_1 implements Runnable {
    SynchronizedQueue_1 synchronizedQueue;

    Producer_1(SynchronizedQueue_1 synchronizedQueue) {
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
