package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_Multithreading_3_December_2013;

public class XXX_0x0 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    hello(tmp);
                }
            }).start();

        }
    }

    public synchronized static void hello(int id) {
        System.out.println(id + " - im here");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {/*NOP*/}
    }
}
