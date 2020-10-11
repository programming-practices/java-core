package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_osnovu;

public class Demo_1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            new HelloTread().start();
//            new HelloRunnabel().run();
//            new Thread(new HelloRunnabel()).start();
            new Thread(() -> System.out.println("Hello from " + Thread.currentThread().getName())).start();
        }
        System.out.println("Hello from main thread");
    }
}

class HelloTread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from " + getName());
    }
}

class HelloRunnabel implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}
