package Examples.Multithreading.Others.Golovach;

public class ZagryzkaProcesoraPotokami {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    ClassP.sillyWork();

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    ClassP.sillyWork();

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    ClassP.sillyWork();

                }
            }
        }).start();

        for (int i = 0; i < 1_000_000; i++) {
            ClassP.sillyWork();

        }
    }
}
