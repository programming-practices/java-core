package Examples.Multithreading;

//import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;

public class ExampleExecutor_DirectExecutor {
    public static void main(String[] args) {
        Executor executor = getExecutor();
        executor.execute(getTask());
        executor.execute(getTask());

        System.out.println("Hello from " + Thread.currentThread());
    }

    // DirectExecutor
    // DirectExecutor blokiryiwchui
    private static Executor getExecutor() {
        return new Executor() {
            @Override
            public void execute(/*@NotNull*/ Runnable command) {
                command.run();
            }
        };
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
