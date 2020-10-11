package Examples.Multithreading.Realizacia_interfeisa_Runable;

public class ThreadDemo {
    public static void main(String args[]) {

        new NewThread_R(); // create age new thread

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
