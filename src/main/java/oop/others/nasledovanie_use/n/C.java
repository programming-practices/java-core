package Examples.OOP.Others.nasledovanie_use.n;

public class C extends A {
    B b = new B(2);

    C() {
        super(1);
        System.out.println("Constructor classa C");
    }
}
