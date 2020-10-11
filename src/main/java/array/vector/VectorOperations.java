package array.vector;

import java.util.Random;

public final class VectorOperations {
    private static Random random = new Random();

    private VectorOperations() {
    }

    /**
     * Filling in vector.
     *
     * @param boundOfRandomNumbers the upper bound (exclusive) for random numbers.  Must be positive.
     */
    public static void fillingVector(int[] vector, int boundOfRandomNumbers) {
        for (int i = 0; i < vector.length; i++) vector[i] = random.nextInt(boundOfRandomNumbers);
    }

    /**
     * Show vector
     *
     * @param vector vector to show
     */
    public static void showVector(int[] vector) {
        System.out.println("\nVector: ");
        for (int i = 0; i < vector.length; i++) System.out.println("      " + vector[i]);
    }

    /**
     * Show vector
     *
     * @param vector vector to show
     * @param title  is it name of vector
     */
    public static void showVector(int[] vector, String title) {
        System.out.println("\n" + title + ": ");
        for (int i = 0; i < vector.length; i++) System.out.println("      " + vector[i]);
    }
}
