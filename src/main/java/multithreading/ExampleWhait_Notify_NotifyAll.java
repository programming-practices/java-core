package Examples.Multithreading;

public class ExampleWhait_Notify_NotifyAll {
    public static void main(String[] args) throws InterruptedException {
//        method0();
//        method1();
//        method2();
//        method3();
//        method4();
        method5();

    }

    public static synchronized void method5() throws InterruptedException {
        Object ref0 = new Object();
        Object ref1 = new Object();
        Object ref2 = new Object();
        synchronized (ref0) {
            synchronized (ref1) {
                synchronized (ref2) {

                    ref0.notify();
                    ref1.notify();
                    ref0.wait(1000);
                    ref2.notifyAll();
                }

            }
        }
    }

    public static synchronized void method4() throws InterruptedException {
        Object ref0 = new Object();
        Object ref1 = ref0;
        synchronized (ref1) {
            ref0.notify();
        }
    }

    public static synchronized void method3() throws InterruptedException {
        Object ref = new Object();
        synchronized (ref) {
            synchronized (ref) {
                synchronized (ref) {
                    //  reentrant lock
                    ref.notify();
                }
            }
        }
    }

    public static synchronized void method2() throws InterruptedException {
        synchronized (new Object()) {
            new Object().notify();
        }
    }

    public static synchronized void method1() throws InterruptedException {
        new Object().wait(1000);
    }

    public static synchronized void method0() throws InterruptedException {
        Object o = new Object();
        synchronized (o) {
            o.wait(1000);
        }
        new Object().notify();
        new Object().notifyAll();
    }


}
