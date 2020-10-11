package Examples.Multithreading.Others.Golovach;

public class ProduserConsumer_3x2 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1, 300, buffer)).start();
        new Thread(new Producer(100, 500, buffer)).start();
        new Thread(new Producer(1000, 700, buffer)).start();

        new Thread(new Consumer(1, buffer)).start();
        new Thread(new Consumer(2, buffer)).start();
    }
}
