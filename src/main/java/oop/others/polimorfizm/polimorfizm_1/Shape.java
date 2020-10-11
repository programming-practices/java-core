package OOP.Others.polimorfizm.polimorfizm_1;

public class Shape {
    protected void drav() {
        System.out.println("Resuetsa figura");
    }

    protected void esrase() {
        System.out.println("Ydalaetsa figura");
    }

    protected void f() {
        System.out.println("Metod q classa Shvape");
    }

    public void rotate(Shape shape) {
        if (shape instanceof Circle) {
            System.out.println("Fihyra otnositsa fiveTuple Circle, tak wto ona mozet krytitsa.");
        } else {
            System.out.println("Figyra ne otnositsa fiveTuple Circle, i nemozet krytitsa.");
        }
    }

    @Override
    public String toString() {
        return "Eto figyra " + super.toString();
    }
}
