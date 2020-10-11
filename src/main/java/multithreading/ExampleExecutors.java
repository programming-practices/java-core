package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExampleExecutors {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        };
        //
//        new Thread(task).start();

//---------------------------------------------------------------------------------------------------------------------

//        Executor executor00 = getExecutor00();
//        // Dve zadachi na executor 1
//        executor00.execute(getTask00());
//        executor00.execute(getTask00());
//
//        Executor executor01 = getExecutor00();
//        // Tri zadachi na executor 2
//        executor01.execute(getTask00());
//        executor01.execute(getTask00());
//        executor01.execute(getTask00());

//---------------------------------------------------------------------------------------------------------------------

//        Executor executor = Executors.newSingleThreadExecutor();
//        Executor executor = Executors.newFixedThreadPool(3);
        Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        Executor executor = Executors.newCachedThreadPool();

        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());

//---------------------------------------------------------------------------------------------------------------------
    }

//---------------------------------------------------------------------------------------------------------------------

    // Executor eto samaia prosteiwaia abstrakcia ispolnitelei (kakoito rabotu)
    private static Executor getExecutor00() {
        throw new UnsupportedOperationException();
    }

    // Runnable eto samaiia prosteiwaia abstrakcia robotu
    private static Runnable getTask00() {
        throw new UnsupportedOperationException();
    }

//---------------------------------------------------------------------------------------------------------------------

    private static Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread());
            }
        };
    }

//---------------------------------------------------------------------------------------------------------------------
}
