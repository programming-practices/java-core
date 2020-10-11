package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_Multithreading_3_December_2013;

public class Zagryzka_Procesora_0x0 {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println("sleep");
            Thread.sleep(5000);
            System.out.println("wakeup");
            double d = 2;
            for (int i = 0; i < 50_000_000; i++) {
                d = Math.sin(d);
            }
        }
    }
}
