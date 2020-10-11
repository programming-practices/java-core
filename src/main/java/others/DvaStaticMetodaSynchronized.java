package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_osnovu;

public class DvaStaticMetodaSynchronized {
    public static void main(String[] args) {
        Thread thread_0 = new Thread(new Runnable() {
            @Override
            public void run() {
                Two.fTwo();
            }
        });

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Two.gTwo();
            }
        });

        thread_0.start();
        thread_1.start();
    }
}


class Two {
    public static synchronized void fTwo() {
        System.out.println("Method fArgInt() run time = " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void gTwo() {
        System.out.println("Method g() run time = " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
