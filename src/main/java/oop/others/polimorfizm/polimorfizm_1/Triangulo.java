package OOP.Others.polimorfizm.polimorfizm_1;

public class Triangulo extends Shape {
    @Override
    protected void drav() {
        System.out.println("Resuetsa Triangullo");
    }

    @Override
    protected void esrase() {
        super.esrase();
        System.out.println("Ydalaensa Triangulo");
    }

    @Override
    protected void f() {
        System.out.println("Metod q calssa Triangule");
    }
}
