package array;

public class TestCopyLongArray {
    public static void main(String[] args) {
        long[] array = new long[1_000_000];
        testArraysCopy(array);
        testFor(array);
    }

    private static void testArraysCopy(long[] array) {
        long start = System.nanoTime();
        System.arraycopy(array, 0, array, 1, array.length - 1);
        long stop = System.nanoTime();
        System.out.printf("arraycopy: %,10d\n", stop - start);
    }

    private static void testFor(long[] array) {
        long start = System.nanoTime();
        for (int i = 0; i < array.length - 2; i++) {
            array[i + 1] = array[i];
        }
        long stop = System.nanoTime();
        System.out.printf("for:       %,10d\n", stop - start);
    }
}
