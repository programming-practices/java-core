package Examples.Multithreading.Primenennie_sincronozirovanux_metodov;

// This program is not synchronized.
public class Callme_1 {
    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller_1 implements Runnable {
    String msg;
    Callme target;
    Thread thread;

    public Caller_1(Callme targ, String s) {
        target = targ;
        msg = s;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
