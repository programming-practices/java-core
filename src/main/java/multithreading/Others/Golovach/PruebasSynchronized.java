package YouTube_Channels.Golovach_Courses.Java_Core_October_2013.Core_Multithreading_3_October_2013;

public class PruebasSynchronized {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                methodF();
            }
        });

        thread.start();

        methodD();
    }


    public static synchronized void methodF() {
        System.out.println("methodF() --> " + Thread.currentThread().getName());
        methodD();
    }

    public static synchronized void methodD() {
        System.out.println("methodD() --> " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
