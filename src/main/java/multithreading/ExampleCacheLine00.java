package Examples.Multithreading;

public class ExampleCacheLine00 {

    final static int ARRAY_SIZE = 64 * 1024 * 1024;

    public static void main(String[] args) {
        byte[] array = new byte[ARRAY_SIZE];
        for (int stepSize = 4; stepSize <= 160; stepSize += 4) {
            long startTime = System.nanoTime();
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < array.length; j += stepSize) {
                    sum += array[j];
                }
            }
            if (sum > 0) {
                throw new Error();
            }
            long endTime = System.nanoTime();
            int step_count = ARRAY_SIZE / stepSize;
            System.out.println(stepSize + ". dT // step_count: " + (endTime - startTime) / step_count);

        }
    }
}
