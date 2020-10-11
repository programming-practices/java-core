package oop;

public class LocalVariable {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
//        for (int i = 0; i < 10; i++) {
//            method(i);
//        }

// ---------------------------------------------------------------------------------------------------------------------
        int k = 0;
        while (k < 10) {
            final long time = System.currentTimeMillis();
            k++;
            System.out.println(time);
        }

// ---------------------------------------------------------------------------------------------------------------------
    }

    public static void method(int value) {
        final int age = value;
        System.out.println(age);
    }
}
