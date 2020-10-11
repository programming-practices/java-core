package multithreading.Others.Vzaimnaya_blokerovka;

public class Class_B {

    synchronized void bar(Class_A age) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.bar");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("B Interrupted");
        }

        System.out.println(name + " trying to call A.last()");
        age.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}
