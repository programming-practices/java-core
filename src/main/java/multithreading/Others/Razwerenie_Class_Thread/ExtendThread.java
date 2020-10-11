package Examples.Multithreading.Razwerenie_Class_Thread;

public class ExtendThread {
    public static void main(String args[]) {

        new NewThread_T(); // create age new thread

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread exiting.");
    }
}
