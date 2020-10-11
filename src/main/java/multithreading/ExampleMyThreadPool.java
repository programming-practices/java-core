package multithreading;

//import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;

public class ExampleMyThreadPool implements Executor {
    // Esli sozdat "new ArrayBlockingQueue<>(256)" to sozdaetsa ochered v kororyy vlaziet 256 elementov
    // A esli sozdat "new ArrayBlockingQueue<>()" to sozdastsa ochered s neohranichenim kolichestvi=om elementov
//    private final BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(256);
//    private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingDeque<>();
    private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingDeque<>(1);

    private final Thread[] pool;

    public ExampleMyThreadPool(int threadCount) {
        this.pool = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            pool[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            // block
                            Runnable nextTask = taskQueue.take();

                            // NoSuchElementException
//                            Runnable nextTask = taskQueue.remove();

                            //return null;
                            // Runnable nextTask = taskQueue.poll();
                            nextTask.run();
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            });
            pool[i].start();
        }
    }


    @Override
    public void execute(/*@NotNull*/ Runnable command) {
        //OFFER demo
//        if (!taskQueue.offer(command)){
//            System.out.println("Rejected!");
//        }

        //Put demo
        try {
            //if full - not reject but block
            taskQueue.put(command);
        } catch (InterruptedException e) {
            throw new Error("NEVER!", e);
        }

        // ADD demo
//        try {
//            taskQueue.add(command);
//        }catch (IllegalStateException e){
//            System.out.println("Rejected!");
//        }
    }
}
