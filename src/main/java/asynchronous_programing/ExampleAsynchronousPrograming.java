package asynchronous_programing;

import java.util.concurrent.*;

// Асинхронное программирование в Java 8
// https://www.youtube.com/watch?v=PKLWcEysUuk
public class ExampleAsynchronousPrograming {
    // Java 1.0 - 1.4 Plain old Java multithreading
    private int result;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new ExampleAsynchronousPrograming().promiseTestInc();
        new ExampleAsynchronousPrograming().promiseTestCompose2();
    }

    // Composing Futures to create pipeline.
    public void promiseTestCompose2() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture
                .supplyAsync(this::slowInt)   // 1
                .thenApply(this::slowIcrement);   // 2

        CompletableFuture<Integer> thenCompose = future1.thenCompose(res -> CompletableFuture.supplyAsync(() -> res))
                .thenApply(this::slowIcrement);   // 3

        System.out.println(thenCompose.get());
    }

    // Using CompletableFuture to excute several task
    public void promiseTestInc() throws ExecutionException, InterruptedException {
        long start = System.nanoTime();
        CompletableFuture<?> future = CompletableFuture
                .supplyAsync(this::slowInt)      // 1
                .thenApply(this::slowIcrement)   // 2
                .thenApply(this::slowIcrement)   // 3
                .thenAccept(res -> System.out.println("async result: " + res));
        future.get();
        long elapsedTime = System.nanoTime() - start;
        System.out.printf("%d sec passed. ", TimeUnit.NANOSECONDS.toSeconds(elapsedTime));
    }

    // Using CompletableFuture to execute several tasks
    public void promiseTestNext() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(this::slowInt)
                .thenAccept((res) -> System.out.println("finished: " + res))
                .thenRun(() -> {
                    System.out.println("look at results");
                });
        future.get();
        System.out.println("promiseTestNext() is finished");
    }

    // Java 8: using CompletableFuture to run slowInt()
    // Zdes net necheho lydweho ot prededywcheho primera, esli crome toho chto kod stal nemnoho koroche.
    public void promiseTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(this::slowInt);
        Integer res = future.get();   // Zdes proisxodit blokirovanie, metod future.get() blokiryywchui
        System.out.println("promiseTest() is finished: " + res);
    }

    // Java 5 - 7: using Executor to run slowInt()
    public void futureTest() throws ExecutionException, InterruptedException {
        Callable<Integer> r = this::slowInt;
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> future = es.submit(r);
        Integer res = future.get();  // Zdes proisxodit blokirovanie, metod future.get() blokiryywchui
        System.out.println("futureTest() is finished: " + res);

    }

    public void testFutureOldStyle() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                result = slowInt();
            }
        };
        t.start();
        t.join();   // meethod join() blokiryewchii, poka deistvie ne sdelaetsa join() ne otpystit potok
        System.out.println("testFutureOldStyle() is finished: " + result);

    }


    public Integer slowInt() {
        System.out.println("started task slowInt()");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public Integer slowIcrement(Integer i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished increment with result " + (i + 1));
        return 1 + i;
    }
}
