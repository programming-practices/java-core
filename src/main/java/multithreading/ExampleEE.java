package multithreading;

public class ExampleEE {

    private static int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int[] array2 = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
    private static volatile int sum = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < array1.length; i++) {
                sum += array1[i];
                System.out.println(sum);
            }
        }) {

        }.start();

        new Thread(() -> {
            for (int i = 0; i < array2.length; i++) {
                sum += array2[i];
                System.out.println(sum);
            }
        }) {

        }.start();

        System.out.println(sum);
    }

}
