package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ExampleThreadVolatile {
    //---------------------------------------------------------------------------------------------------------------------
    private final static int N = 1_000_000;
    //---------------------------------------------------------------------------------------------------------------------
    static volatile int countVolatile = 0;
    static int countNotVolatile = 0;
    static AtomicInteger countAtomicInteger = new AtomicInteger(0);
    static volatile boolean startThreadOne = false;
    static volatile boolean startThreadTwo = false;
    private volatile static int counter = 0;

    // esli etot metod bydet bez syncronized to on bydet imet svoistvo "lost update"
    public static synchronized void inc() {
//        int tmp = countVolatile;
//        tmp = tmp + 1;
//        countVolatile = tmp;

//        int tmp = countNotVolatile;
//        tmp = tmp + 1;
//        countNotVolatile = tmp;

//        countVolatile++;
        countNotVolatile++;
    }

    public static synchronized int getCounter() {
        return countNotVolatile;
    }
//---------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws InterruptedException {
//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10_000_000; i++) {
////                    countVolatile++;
////                    countAtomicInteger.incrementAndGet();  // rewenie etoi problemu
//                    inc();   // ewcho odnoe rewenie etoi problemu
//                }
//                startThreadOne = true;
//            }
//        }).start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10_000_000; i++) {
////                    countVolatile++;
////                    countAtomicInteger.incrementAndGet();
//                    inc();
//                }
//                startThreadTwo = true;
//            }
//        }).start();
//
//        while (!startThreadOne || !startThreadTwo);
////        System.out.println(!startThreadOne);
////        System.out.println(!startThreadTwo);
////        while (!startThreadOne && !startThreadTwo);  //   ?????? problema
////        System.out.println(startThreadOne);
////        System.out.println(startThreadTwo);
//
//        System.out.println(countVolatile);
////        System.out.println(countAtomicInteger);

//---------------------------------------------------------------------------------------------------------------------

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10_000_000; i++) {
//                    inc();
//                }
//                startThreadOne = true;
//            }
//        }).start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10_000_000; i++) {
//                    inc();
//                }
//                startThreadTwo = true;
//            }
//        }).start();
//
//        // V danom slychai esli mu xochim nablydat za peremennoi couter iz potoka main ona dolzna bit volotail
//        while (true){
////            System.out.println(countNotVolatile); // eto owibka, zdes vosmozno compilator jvm ... mogyt
//            // zdelat optemizaciy i zamenit sout(countNotValue) na sout(0)
//            // i iz za etoho ves chas vivodit nol.
//
////            System.out.println(countVolatile);
////            System.out.println(countNotVolatile);
//
//            // Vozmozno ewcho tak rewit ety problemy
//            System.out.println(getCounter());
//        }
//---------------------------------------------------------------------------------------------------------------------
        Thread thread_1 = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < N; i++) {
                    counter++;
                }
            }
        });


        Thread thread_2 = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < N; i++) {
                    counter++;
                }
            }
        });

        thread_1.start();
        thread_2.start();

        thread_1.join();
        thread_2.join();

        System.out.println(counter);

//---------------------------------------------------------------------------------------------------------------------
    }
}
