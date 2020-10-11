package Examples.Multithreading.Others.Golovach;

public class ProduserConsumer_P {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Produser(1, 1, 1000, buffer)).start();
//        new Thread(new Produser(2, 1, 1000, buffer)).start();
//        new Thread(new Produser(3, 1, 1000, buffer)).start();
    }
}
