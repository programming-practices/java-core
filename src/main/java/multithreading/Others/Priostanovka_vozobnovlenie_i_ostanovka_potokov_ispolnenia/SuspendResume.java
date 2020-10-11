package Examples.Multithreading.Priostanovka_vozobnovlenie_i_ostanovka_potokov_ispolnenia;

public class SuspendResume {
    public static void main(String args[]) {
        NewThread threadOne = new NewThread("One");
        NewThread threadTwo = new NewThread("Two");

        try {
            Thread.sleep(1000);
            threadOne.mysuspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            threadOne.myresume();
            System.out.println("Resuming thread One");

            threadTwo.mysuspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            threadTwo.myresume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            threadOne.thread.join();
            threadTwo.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Main thread exiting.");
    }
}
