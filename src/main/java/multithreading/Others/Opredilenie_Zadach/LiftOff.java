package Examples.Multithreading.Opredilenie_Zadach;

//: concurrency/LiftOff.java
// Demonstration of the Runnable interface.

public class LiftOff implements Runnable {

    private static int taskCount = 0;
    private final int id = taskCount++;
    protected int countDown = 10; // Default

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + ") Thread name: " + Thread.currentThread().getName() + ",  \n";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
