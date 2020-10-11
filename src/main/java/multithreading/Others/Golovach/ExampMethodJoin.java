package Examples.Multithreading.Others.Golovach;

public class ExampMethodJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ClassP.sillyWork();
                    System.out.println("One Thread work");
                }
            }
        });
        thread.start();
        for (int i = 0; i < 3; i++) {
            ClassP.sillyWork();
            System.out.println("Two thread work");
        }
        thread.join();
        System.out.println("That's all !!!");
    }
}
