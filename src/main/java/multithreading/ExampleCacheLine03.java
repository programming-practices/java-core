package Examples.Multithreading;

public class ExampleCacheLine03 {

    final static int ARRAY_SIZE = 16 * 1024 * 1024;

    public static void main(String[] args) {
        byte[] array = new byte[ARRAY_SIZE];
        for (int testIndex = 0; testIndex < 10; testIndex++) {
//        for (int testIndex = 0; testIndex < 5; testIndex++) {
            testMethod(array);
            System.out.println("------------------------------------");
        }
    }

    private static void testMethod(byte[] array) {
        for (int stepSize = 4; stepSize <= 512; stepSize *= 2) {
//        for (int stepSize = 2; stepSize <= 512; stepSize *= 2) {
//        for (int stepSize = 1; stepSize <= 512; stepSize *= 2) {
//        for (int stepSize = 1; stepSize <= 1024; stepSize *= 2) {
//        for (int stepSize = 1; stepSize <= 2048; stepSize *= 2) {
//        for (int stepSize = 1; stepSize <= 4096; stepSize *= 2) {
//        for (int stepSize = 1; stepSize <= 8192; stepSize *= 2) {
//        for (int stepSize = 1; stepSize <= 16384; stepSize *= 2) {
//        for (int stepSize = 1; stepSize <= 32768; stepSize *= 2) {
//        for (int stepSize = 1; stepSize <= 65536; stepSize *= 2) {
//        for (int stepSize = 1; stepSize <= 131072; stepSize *= 2) {
//        for (int stepSize = 4; stepSize <= 262144; stepSize *= 2) {
//        for (int stepSize = 2; stepSize <= 512; stepSize += 16) {
            int sum = 0;

            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < array.length; j += stepSize) {
                    sum += array[j];
                }
            }
            long endTime = System.nanoTime();

            if (sum > 0) {
                throw new Error();
            }
            int step_count = ARRAY_SIZE / stepSize;
            System.out.println(stepSize + ". dT / step_count: " + (endTime - startTime) / step_count);

        }
    }
}


