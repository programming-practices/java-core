package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_Multithreading_3_December_2013.V_metode_synchronized_mozet_naxoditsa_bolwe_metodov_chem_odin;

public class ExperementosSynchronized_0x1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                hello(1);

            }
        }).start();
    }

    public synchronized static void hello(int id) {
        while (true) {
            System.out.println(id + ": Hello");
        }
    }

}
