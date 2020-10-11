package Examples.Multithreading.Others.Golovach;

public class ILP_2_2 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        double value01 = 1;
        double value02 = 1;
        for (int i = 0; i < 1_000_000_000; i++) {
            value01 = value01 * value02;
            value02 = value01 * value02;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(value02 - value01);

    }
}
