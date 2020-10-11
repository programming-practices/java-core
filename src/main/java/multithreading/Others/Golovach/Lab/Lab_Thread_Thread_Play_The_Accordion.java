package YouTube_Channels.Golovach_Courses.Java_Core_October_2013.Core_Multithreading_3_October_2013.Lab;

public class Lab_Thread_Thread_Play_The_Accordion {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            // A + B
            Runnable printerA = new PrintRunnable("A    .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();

            Runnable printerB = new PrintRunnable(".   B", 100);
            Thread threadB = new Thread(printerB);
            threadB.start();

            threadA.join();
            threadB.join();
            // C
            System.out.println("-----------");
            Runnable printerC = new PrintRunnable("    C", 100);
            printerC.run();
            System.out.println("-----------");
        }
    }
}
