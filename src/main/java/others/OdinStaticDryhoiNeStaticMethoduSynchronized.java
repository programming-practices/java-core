package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_osnovu;

public class OdinStaticDryhoiNeStaticMethoduSynchronized {
    public static void main(String[] args) {
        Thread thread_0 = new Thread(new Runnable() {
            @Override
            public void run() {
                Three three = new Three();
                three.gThree();
            }
        });

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Three.fThree();
            }
        });

        thread_0.start();
        thread_1.start();
    }
}


class Three {
    public static synchronized void fThree() {
        System.out.println("Method fArgInt() run time = " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void gThree() {
        System.out.println("Method g() run time = " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
