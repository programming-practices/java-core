package multithreading;

import java.util.concurrent.Executor;

public class ExampleThreadPool {
    public static void main(String[] args) {
        Executor executor = new ExampleMyThreadPool(2);
//        Executor executor = new ExampleMyThreadPool(3);
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        System.out.println("Buy");
    }

    private static Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread());
                while (true) ;
            }
        };
    }
}
