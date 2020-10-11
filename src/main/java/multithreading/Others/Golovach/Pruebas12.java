package Examples.Multithreading.Others.Golovach;

public class Pruebas12 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }).start();
        System.out.println(Thread.activeCount());
    }

}
