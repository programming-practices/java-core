package Examples.Multithreading.Primenennie_sincronozirovanux_metodov;

public class Synch {
    public static void main(String args[]) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");

//         wait for threads to end
        try {
            ob1.thread.join();
            ob2.thread.join();
            ob3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println();

        Callme_1 target1 = new Callme_1();
        Caller_1 ob11 = new Caller_1(target, "Hello");
        Caller_1 ob22 = new Caller_1(target, "Synchronized");
        Caller_1 ob33 = new Caller_1(target, "World");

//         wait for threads to end
        try {
            ob11.thread.join();
            ob22.thread.join();
            ob33.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
