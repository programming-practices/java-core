package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_osnovu;

public class DvaNeStaticMetodaSynchronized {
    public static void main(String[] args) {

        Thread thread_0 = new Thread(new Runnable() {
            @Override
            public void run() {
                One one = new One();
                one.fOne();
            }
        });

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                One one = new One();
                one.gOne();
            }
        });
        thread_0.start();
        thread_1.start();
    }
}


class One {
    public synchronized void fOne() {
        System.out.println("Method fArgInt() run time = " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void gOne() {
        System.out.println("Method g() run time = " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
