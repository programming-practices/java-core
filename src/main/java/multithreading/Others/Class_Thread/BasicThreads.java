package Examples.Multithreading.Class_Thread;

import Examples.Multithreading.Opredilenie_Zadach.LiftOff;

public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
