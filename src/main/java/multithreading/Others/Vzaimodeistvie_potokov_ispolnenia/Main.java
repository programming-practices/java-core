package Examples.Multithreading.Vzaimodeistvie_potokov_ispolnenia;

public class Main {
    public static void main(String args[]) {
        SynchronizedQueue synchronizedQueue = new SynchronizedQueue();
        new Producer(synchronizedQueue);
        new Consumer(synchronizedQueue);

        System.out.println("Press Control-C to stop.");
    }
}
