package Examples.Multithreading;

/*import javax.validation.constraints.NotNull;*/

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExampleThreadPoolExecutor {
    public static void main(String[] args) {
        // Fixed thread pool mozno postavit corePoolSize i maximumPoolSize odin i totze
        int corePoolSize = 4;
        int maximumPoolSize = 64;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(256);
        ThreadFactory threadFactory = new ThreadFactory() {
            private AtomicInteger couter = new AtomicInteger(0);

            @Override
            public Thread newThread(/*@NotNull*/ Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setName("MyPool-NORM_PRIORITY-" + couter.incrementAndGet());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ignore) {/*NOP*/}
                return thread;
            }
        };
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("All thread busy + task queue is full");
            }
        };

        Executor executor = new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize,
                keepAliveTime, unit,
                workQueue,
                threadFactory,
                rejectedExecutionHandler
        );

        for (int i = 0; i < 100; i++) {
            executor.execute(getTask());
        }
        for (int i = 0; i < 100; i++) {
            executor.execute(getTask());
        }
        for (int i = 0; i < 100; i++) {
            executor.execute(getTask());
        }

//        executor.execute(getTask());
//        executor.execute(getTask());
//        executor.execute(getTask());

    }

    private static Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread());
            }
        };
    }
}
