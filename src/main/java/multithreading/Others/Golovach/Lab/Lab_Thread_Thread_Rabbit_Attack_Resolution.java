package YouTube_Channels.Golovach_Courses.Java_Core_October_2013.Core_Multithreading_3_October_2013.Lab;

public class Lab_Thread_Thread_Rabbit_Attack_Resolution {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("???");
                    birthEssence();
                }
            }
        });

        thread.start();

        thread.join();

    }


    public static void birthEssence() {
        Thread threadHijo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Birth Day -> " + Thread.currentThread().getName());
//                birthEssence();
            }
        });

        threadHijo.start();

    }

}
