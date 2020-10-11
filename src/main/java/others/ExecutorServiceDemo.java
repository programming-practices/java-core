package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_sredstva_standartnoi_biblioteki;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Submit worker 1");
        Future<String> future1 = executor.submit(new Worker("worker_1"));

        System.out.println("Submit worker 2");
        Future<String> future2 = executor.submit(new Worker("worker_2"));


        System.out.println("Result from worker_1: " + future1.get());
        System.out.println("Result from worker_2: " + future2.get());


        System.out.println("------------------------------");


        System.out.println("Submit workers using invokeAll()");
        List<Future<String>> futures = executor.invokeAll(
                Arrays.asList(new Worker("woeker_3"), new Worker("worker_4"), new Worker("worker_5")));


        System.out.println("Exited invokeAll");
        for (Future<String> future : futures) {
            System.out.println("Result fro worker: " + future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10L, TimeUnit.SECONDS);

    }


    private static class Worker implements Callable<String> {

        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            long sleepTime = (long) (Math.random() * 10000L);
            System.out.println(name + " started, going to sleep for ");
            Thread.sleep(sleepTime);
            System.out.println(name + " finished");
            return name;
        }
    }

}
