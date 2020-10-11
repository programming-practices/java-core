package OOP.Others.polimorfizm.polimorfizm_1;

public class Priamouholnik extends Shape {
    @Override
    protected void f() {
        System.out.println("Metod q classa Priamouholnik");
    }

    @Override
    protected void esrase() {
        System.out.println("Ydalaetsa Priamouholnik");
    }

    @Override
    protected void drav() {
        System.out.println("Resuetsa Priamouholnik");
    }
}
