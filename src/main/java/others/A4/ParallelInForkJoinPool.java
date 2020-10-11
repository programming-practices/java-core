package others.A4;

import java.util.concurrent.ForkJoinPool;

public class ParallelInForkJoinPool {
    public static void main(String[] args) {
        int[] array = Commons.prepareArray();

        ForkJoinPool poll = new ForkJoinPool();

        long startTime = System.currentTimeMillis();

        double sum;
    }
}
