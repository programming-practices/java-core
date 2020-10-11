package multithreading.Others.Golovach;

public class ILP_1_1 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        double value = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            value = value * value;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(value);

    }
}
