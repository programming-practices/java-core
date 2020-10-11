package Examples.Multithreading;

/*import org.jetbrains.annotations.NotNull;*/

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public class ExampleExecutor_ThreadPerTaskExecutor {
    public static void main(String[] args) {
        Executor executor = getExecutor();
        executor.execute(getTask());
        executor.execute(getTask());

        System.out.println("Hello from " + Thread.currentThread());
    }

    // ThreadPerTaskExecutor
    private static Executor getExecutor() {
        return new Executor() {
            private final AtomicLong index = new AtomicLong(0);
            private final ThreadGroup group = new ThreadGroup("MyGroup");

            @Override
            public void execute(/*@NotNull*/ Runnable command) {
                Thread thread = new Thread(group, command);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setDaemon(true);
                thread.setName("Thread-#" + index.getAndIncrement());
                thread.start();
            }
        };
    }

    private static Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                Thread me = Thread.currentThread();
                System.out.println("Hello from " + me +
                        ", my name " + me.getName() +
                        ", my Priority = " + me.getPriority() +
                        ", I'm demon " + me.isDaemon());
//                System.out.println("Hello from " + me);
            }
        };
    }
}
