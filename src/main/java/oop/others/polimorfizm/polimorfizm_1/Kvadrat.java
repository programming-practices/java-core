package OOP.Others.polimorfizm.polimorfizm_1;

public class Kvadrat extends Shape {
    @Override
    protected void drav() {
        System.out.println("Resuetsa Kvadrat");
    }

    @Override
    protected void esrase() {
        super.esrase();
        System.out.println("Ydalaetsa Kvadrat");
    }

    @Override
    protected void f() {
        System.out.println("Metod q calssa Kvadrat");
    }
}
