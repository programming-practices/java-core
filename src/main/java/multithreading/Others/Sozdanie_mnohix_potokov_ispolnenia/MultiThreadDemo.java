package multithreading.Others.Sozdanie_mnohix_potokov_ispolnenia;

public class MultiThreadDemo {
    public static void main(String args[]) {

        // start threads
        new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");

        try {
            // wait for other threads to end
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Main thread exiting.");
    }
}
