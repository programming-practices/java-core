package Examples.Multithreading;

public class ExampleThreadGetState {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(new Thread().getState());

        Thread thread = new Thread();
        thread.start();
        thread.join();

        System.out.println(thread.getState());
    }
}
