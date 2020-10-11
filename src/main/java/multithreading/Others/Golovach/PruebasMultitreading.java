package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_Multithreading_1_Deciember_2013;

public class PruebasMultitreading {

    public static final int N = 1_000_000;
    public static volatile int counter = 0;

    public synchronized static void inc() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) inc();
            }
        });
        t0.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) inc();
            }
        });
        t1.start();

        t0.join();
        t1.join();

        System.out.println(counter);


    }

}
