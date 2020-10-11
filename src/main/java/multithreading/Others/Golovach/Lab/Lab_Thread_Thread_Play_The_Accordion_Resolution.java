package YouTube_Channels.Golovach_Courses.Java_Core_October_2013.Core_Multithreading_3_October_2013.Lab;

public class Lab_Thread_Thread_Play_The_Accordion_Resolution {
    public static void main(String[] args) throws InterruptedException {
        Thread threadEncargado = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    // A + B
                    Runnable printerA = new PrintRunnable("A    .", 100);
                    Thread threadA = new Thread(printerA);
                    threadA.start();

                    Runnable printerB = new PrintRunnable(".   B", 99);
                    Thread threadB = new Thread(printerB);
                    threadB.start();

                    try {
                        threadA.join();
                        threadB.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // C
                    System.out.println("-----------");

                    Runnable printerC = new PrintRunnable("    C", 100);
                    Thread threadC = new Thread(printerC);
                    threadC.start();

                    try {
                        threadC.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("-----------");
                }

            }
        });

        threadEncargado.start();

        threadEncargado.join();

        System.out.println("Finish work!!!");


    }
}
