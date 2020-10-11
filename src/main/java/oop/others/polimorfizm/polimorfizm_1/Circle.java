package OOP.Others.polimorfizm.polimorfizm_1;

public class Circle extends Shape {
    @Override
    protected void drav() {
        System.out.println("Resuetsa Circle");
    }

    @Override
    protected void esrase() {
        super.esrase();
        System.out.println("Ydalaetsa Circle");
    }

    @Override
    protected void f() {
        System.out.println("Metod q calssa Circle");
    }
}
