package multithreading;

/*

    java.util.concurrent:
                            - Queue
                            - Collections
                            - Syncronizers
                            - Atomics
                            - ???

*/

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ExampleJavaUtilConcurrent {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

//        // Produser, Consumer
//
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue(16);
//        //Produser
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int counter = 0;
//                while (true){
//                    try {
//                        Thread.sleep(1000);
//                        queue.put(++counter);
//                        System.out.println("put: " + counter);
//                    }catch (InterruptedException ignore){/*NOP*/}
//                }
//             }
//        }).start();
//
//        // Consumer
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        System.out.println("... wait for ta ke");
//                        int data = queue.take();        // block thread
////                        Integer data = queue.poll();  // null
////                        queue.remove();               // NoSuchElementException
//                        System.out.println("take: " + data);
//                    } catch (InterruptedException ignore) {/*NOP*/}
//                }
//            }
//        }).start();

//---------------------------------------------------------------------------------------------------------------------

//        // Produser, Consumer@
//
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue(16);
//        //Produser
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int counter = 0;
//                while (true){
//                    // Esli vuletaet Exception v potoke to etot Exception ostanovliaet tolko
//                    // etot potok, drygoi potok kavisait v ozidanii etoho potoka
//                    throw new Error();
//                }
//            }
//        }).start();
//
//        // Consumer
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        System.out.println("... wait for ta ke");
//                        int data = queue.take();
//                        System.out.println("take: " + data);
//                    } catch (InterruptedException ignore) {/*NOP*/}
//                }
//            }
//        }).start();

//---------------------------------------------------------------------------------------------------------------------

//        // Produser, Consumer@
//
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue(16);
//        //Produser
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int counter = 0;
//                while (true){
//                    // Esli vuletaet Exception v potoke to etot Exception ostanovliaet tolko
//                    // etot potok, drygoi potok kavisait v ozidanii etoho potoka
//                    throw new Error();
//                }
//            }
//        }).start();
//
//        // Consumer
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        System.out.println("... wait for ta ke");
//                        Integer data = queue.poll(1, TimeUnit.SECONDS);
//                        // Zdes nado opredilat wto nado delat, esli drugoi potok brosaet
//                        // isklychenie, ili ne imeet dannux
//                        if (data == null){
//                            System.out.println("NO Data");
//                        }
//                    } catch (InterruptedException ignore) {/*NOP*/}
//                }
//            }
//        }).start();

//---------------------------------------------------------------------------------------------------------------------

        // Produser, Consumer@

//        BlockingQueue<Integer> queue = new ArrayBlockingQueue(16);
//        //Produser
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int counter = 0;
//                while (true){
//                    try {
//                        Thread.sleep(300);
//                        queue.put(++counter);
//                        System.out.println("put: " + counter);
//                    }catch (InterruptedException ignore){/*NOP*/}
//                }
//            }
//        }).start();
//
//        // Consumer
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                while (true){
//                for (int i = 0; i < 3; i++) {
//                    try {
////                        Thread.sleep(5000);
//                        int data = queue.take();
//                        System.out.println("take: " + data);
//                    } catch (InterruptedException ignore) {/*NOP*/}
//                }
//            }
//        }).start();

//---------------------------------------------------------------------------------------------------------------------

        final BlockingQueue<String> queue = new ArrayBlockingQueue(16);
        //Produser
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int counter = 0;
                    while (true) {
                        try {
                            Thread.sleep(300L + 1000 * finalI);
                            String data = "element - " + finalI + " / " + ++counter;
                            queue.put(data);
                            System.out.println("put: " + data);
                        } catch (InterruptedException ignore) {/*NOP*/}
                    }
                }
            }).start();
        }

        // Consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                for (int i = 0; i < 3; i++) {
                    try {
//                        Thread.sleep(5000);
                        String data = queue.take();
                        System.out.println("take: " + data);
                    } catch (InterruptedException ignore) {/*NOP*/}
                }
            }
        }).start();

//---------------------------------------------------------------------------------------------------------------------
    }
}
