package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_Multithreading_2_December_2013;

public class Pruebas {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("Hello");
        }


        Thread thread1 = Thread.currentThread();
        System.out.println("main(): " + thread1.getName());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run(): " + Thread.currentThread().getName());
            }
        });
        thread.start();


//        Runnable  runnable = new RunnableImpl();
//        runnable.run();
//
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("run()");
//            }
//        };
//        runnable1.run();
//        System.out.println(runnable1.getClass().getName());
    }

}
