package Examples.Multithreading.Priostanovka_vozobnovlenie_i_ostanovka_potokov_ispolnenia;

// Suspending and resuming age thread for Java 2
public class NewThread implements Runnable {

    String name; // name of thread
    Thread thread;
    boolean suspendFlag;

    NewThread(String threadname) {
        name = threadname;
        thread = new Thread(this, name);
        System.out.println("New thread: " + thread);
        suspendFlag = false;
        thread.start(); // Start the thread
    }

    // This is the entry point for thread.
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}
