package OOP.Others.polimorfizm.polimorfizm_1;

public class Shapes {
    private static RandomShapeGenerator generator = new RandomShapeGenerator(4);

    public static void main(String[] args) {
        Shape[] shapes = new Shape[15];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = generator.iterator().next();
        }
        for (Shape s : shapes) {
            s.drav();
            s.f();
            System.out.println();
        }
    }
}
