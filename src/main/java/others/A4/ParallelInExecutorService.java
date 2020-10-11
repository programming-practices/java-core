package others.A4;

import java.util.concurrent.*;

public class ParallelInExecutorService {
    public ParallelInExecutorService() throws ExecutionException, InterruptedException {
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = Commons.prepareArray();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();

        Future<Double> future_1 = executor.submit(new PratialCal(array, 0, array.length / 2));
        Future<Double> future_2 = executor.submit(new PratialCal(array, array.length / 2, array.length));

        double sum = future_1.get() + future_2.get();

        long endTime = System.currentTimeMillis();

        System.out.println("sum " + sum);
        System.out.println("time " + (endTime - startTime) + " ms");

        executor.shutdown();
    }

    private static class PratialCal implements Callable<Double> {

        private final int[] array;
        private final int start;
        private final int end;

        public PratialCal(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Double call() throws Exception {
            return Commons.calculate(array, start, end);
        }
    }
}
