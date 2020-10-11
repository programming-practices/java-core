package Examples.Multithreading.Others.Golovach;

public class ClassP {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    sillyWork();
                    System.out.println("Hello!");
                }
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            sillyWork();
            System.out.println("Bye!");
        }


//        for(int i = 0; i < 5; i++){
//            sillyWork();
//            System.out.println("Hello");
//        }
    }

    public static void sillyWork() {
        double d = 2.0;
        for (int i = 0; i < 19_999_000; i++) {
            d = Math.sin(d);
        }
    }
}
