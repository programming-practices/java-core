package YouTube_Channels.Computer_Science_Center.Mnoho_potochnost_v_java_sredstva_standartnoi_biblioteki;

import java.util.ArrayList;
import java.util.List;

public class SequenceGeneratorBrokenGood_1 {
    private static int counter = 0;

    public synchronized static int nextInt() {
        return counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; ++j) nextInt();
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter final value: " + counter);
    }
}
