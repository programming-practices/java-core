package Examples.java_util_concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ExampleArrayBlockingQueue {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

        //Produser, Consumer

        BlockingQueue<Integer> queue = new ArrayBlockingQueue(16);
        //Produser
        new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (true) {
                    try {
                        Thread.sleep(500);
                        queue.put(++counter);
                        System.out.println("put: " + counter);
                    } catch (InterruptedException ignore) {/*NOP*/}
                }
            }
        }).start();

        // Consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("... wait for take");
                        int data = queue.take();        // block thread
//                        Integer data = queue.poll();  // null
//                        queue.remove();               // NoSuchElementException
                        System.out.println("take: " + data);
                    } catch (InterruptedException ignore) {/*NOP*/}
                }
            }
        }).start();

//---------------------------------------------------------------------------------------------------------------------
    }
}
