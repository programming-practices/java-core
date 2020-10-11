package Examples.Multithreading.Vzaimodeistvie_potokov_ispolnenia.Correct;

public class SynchronizedQueue_1 {
    int value;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();

            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        System.out.println("Got: " + value);
        valueSet = false;
        notify();
        return value;
    }

    synchronized void put(int value) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        this.value = value;
        valueSet = true;
        System.out.println("Put: " + value);
        notify();
    }
}
