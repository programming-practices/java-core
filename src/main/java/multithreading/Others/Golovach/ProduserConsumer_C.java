package Examples.Multithreading.Others.Golovach;

public class ProduserConsumer_C {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Consumer(1, buffer)).start();
    }
}
