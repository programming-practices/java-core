package multithreading.Others.Vzaimnaya_blokerovka;

public class Deadlock implements Runnable {
    Class_A class_a = new Class_A();
    Class_B class_b = new Class_B();

    Deadlock() {
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread(this, "RacingThread");
        t.start();

        class_a.foo(class_b); // get lock on class_a in this thread.
        System.out.println("Back in main thread");
    }

    public static void main(String args[]) {
        new Deadlock();
    }

    public void run() {
        class_b.bar(class_a); // get lock on class_b in other thread.
        System.out.println("Back in other thread");
    }
}
