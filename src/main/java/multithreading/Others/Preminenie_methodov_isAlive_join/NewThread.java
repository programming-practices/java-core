package Examples.Multithreading.Preminenie_methodov_isAlive_join;

// Using join() to wait for threads to finish.
public class NewThread implements Runnable {
    String name; // name of thread
    Thread thread;

    NewThread(String threadname) {
        name = threadname;
        thread = new Thread(this, name);
        System.out.println("New thread: " + thread);
        thread.start(); // Start the thread
    }

    // This is the entry point for thread.
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }
}
