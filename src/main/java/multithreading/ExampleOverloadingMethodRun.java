package Examples.Multithreading;

public class ExampleOverloadingMethodRun {
    public static void main(String[] args) {
        new MyThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" --> run()");
            }
        }).start();

        System.out.println("Bye  from --> " + Thread.currentThread().getName());
    }


    static class MyThread extends Thread {

        public MyThread(Runnable target) {
            super(target);
        }

        @Override
        public void run() {
            System.out.println("Hello from --> " + Thread.currentThread().getName());
        }
    }
}
