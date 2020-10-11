package OOP.Others.polimorfizm.polimorfizm_1;

import java.util.Iterator;
import java.util.Random;

public class RandomShapeGenerator implements Iterable {
    private int amountOfElements = 0;
    private Random random = new Random(47);

    public RandomShapeGenerator(int amountOfElements) {
        this.amountOfElements = amountOfElements;
    }

    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int index = 0;

            public boolean hasNext() {
                return index < amountOfElements;
            }

            public Shape next() {
                switch (random.nextInt(5)) {
                    default:
                    case 0:
                        return new Circle();
                    case 1:
                        return new Triangulo();
                    case 2:
                        return new Kvadrat();
                    case 3:
                        return new Priamouholnik();
//                    case 4: return new Rhomboid();
                }
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

}
