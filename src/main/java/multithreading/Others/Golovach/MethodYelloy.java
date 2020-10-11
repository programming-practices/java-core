package Examples.Multithreading.Others.Golovach;

public class MethodYelloy {
    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            ClassP.sillyWork();
            Thread.yield();
            System.out.println("Bye!");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    ClassP.sillyWork();
                    System.out.println("Hello!");
                }
            }
        }).start();
    }
}
