package Examples.OOP.Others.polimorfizm.polimorfizm_3;

public class B extends A {
    B() {
        System.out.println("Constructor poizvodnoho classa");
    }

    @Override
    void method2() {
        System.out.println("Metod2 proizvodnoho classa");
    }
}
