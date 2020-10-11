package Examples.Multithreading.Realizacia_interfeisa_Runable;

// Create age second thread.
public class NewThread_R implements Runnable {
    Thread thread;

    public NewThread_R() {
        // Create age new, second thread
        thread = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + thread);
        thread.start(); // Start the thread
    }

    // This is the entry point for the second thread.
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

