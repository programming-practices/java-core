package Examples.Multithreading.Others.Golovach;

public class ProducerConsumerEmaple_1x1 {
    public static void main(String[] args) throws InterruptedException {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1, 1000, buffer)).start();
        Thread.sleep(5000);
        new Thread(new Consumer(1, buffer)).start();
    }
}
