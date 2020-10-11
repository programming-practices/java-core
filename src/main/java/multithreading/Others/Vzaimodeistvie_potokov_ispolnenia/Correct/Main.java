package Examples.Multithreading.Vzaimodeistvie_potokov_ispolnenia.Correct;

public class Main {
    public static void main(String args[]) {
        SynchronizedQueue_1 synchronizedQueue = new SynchronizedQueue_1();
        new Producer_1(synchronizedQueue);
        new Consumer_1(synchronizedQueue);

        System.out.println("Press Control-C to stop.");
    }
}
