package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_Multithreading_3_December_2013.V_metode_synchronized_mozet_naxoditsa_bolwe_metodov_chem_odin;

public class ExperementosSynchronized_0x4 {
    public static void main(String[] args) {
        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello(1);

            }
        });

        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                hello(2);
            }
        });

        thread_1.start();
        thread_2.start();
    }

    public static void hello(int id) {
        System.out.println(id + " - im here A");
        synchronized (ExperementosSynchronized_0x4.class) {
            System.out.println(id + " - im here B");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignore) {/* NOP */}
        }
    }

}
