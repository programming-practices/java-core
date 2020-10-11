package Examples.Multithreading.Others.Golovach;

public class MethodSetDemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) { /* NOP */}
            }
        });
//        thread.setDaemon(false);
        thread.setDaemon(true);
        thread.start();
        System.out.println("Bye!!!");
//        System.exit(42);
//        System.exit(0);
    }

//    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().isDaemon());
//    }

}
