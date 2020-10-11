package multithreading.Others.Pryebas_nasledovania_ot_Runable;

public class IherideRunableThread {

    public static void main(String[] args) {

        IherideRunable iherideRunable = new IherideRunable();
        iherideRunable.run();

        System.out.println("----------------------------------------------------------");
        InherideThread inherideThread = new InherideThread();
        inherideThread.start();

//        System.out.println(inherideThread.isAlive());
//        inherideThread.run();

//        Thread t = new Thread(ih);
//        t.start();

    }

}

class IherideRunable implements Runnable {

    @Override
    public void run() {
        System.out.println("Work from IheridedRunable ");
        System.out.println(Thread.currentThread().getName());
    }
}

class InherideThread extends Thread {

    @Override
    public void run() {
        System.out.println("Work from InheritedThread ");
        System.out.println(Thread.currentThread().getName());
    }
}

