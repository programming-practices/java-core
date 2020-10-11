package Examples.OOP.Others.polimorfizm.polimorfizm_3;

public class A {
    A() {
        System.out.println("Constructor baxovoho classa");
    }

    void method1() {
        System.out.println("methodA bazovoho classa");
        method2();
    }

    void method2() {
        System.out.println("methodB bazovoho classa");
    }
}
