package multithreading.Others.Vzaimnaya_blokerovka;

// An example of deadlock.
public class Class_A {

    synchronized void foo(Class_B class_b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " entered A.foo");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("A Interrupted");
        }

        System.out.println(name + " trying to call B.last()");
        class_b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}
