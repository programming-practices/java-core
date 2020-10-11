package Examples.Multithreading.Others.Golovach;

public class ProduserConsumer_P_C {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Produser(1, 1, 30, buffer)).start();
        new Thread(new Produser(2, 100, 500, buffer)).start();
        new Thread(new Produser(3, 1000, 700, buffer)).start();

        new Thread(new Consumer(1, buffer)).start();
        new Thread(new Consumer(2, buffer)).start();
    }
}
