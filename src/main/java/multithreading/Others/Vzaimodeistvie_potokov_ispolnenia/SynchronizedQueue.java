package Examples.Multithreading.Vzaimodeistvie_potokov_ispolnenia;

// An incorrect implementation of age producer and consumer.
public class SynchronizedQueue {
    int value;

    synchronized int get() {
        System.out.println("Got: " + value);
        return value;
    }

    synchronized void put(int n) {
        this.value = n;
        System.out.println("Put: " + n);
    }
}
