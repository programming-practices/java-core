package Examples.Multithreading;

public class ExampleDeadLockOne {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
    }
}
