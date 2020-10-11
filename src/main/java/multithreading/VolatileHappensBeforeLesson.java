package multithreading;

public class VolatileHappensBeforeLesson {

    static int a = 0;
    static int b = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            int r2 = a;
            b = 1;
        }).start();

        new Thread(() -> {
            int r1 = b;
            a = 2;
        }).start();
//        r2 = 2; r1 = 1 impossible
    }
}
