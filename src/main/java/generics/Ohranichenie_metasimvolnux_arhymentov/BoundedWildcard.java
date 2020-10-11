package generics.Ohranichenie_metasimvolnux_arhymentov;

// Bounded Wildcard arguments.

// Two-dimensional coordinates.
class TwoD {
    int x, y;

    TwoD(int age, int b) {
        x = age;
        y = b;
    }
}

// Three-dimensional coordinates.
class ThreeD extends TwoD {
    int z;

    ThreeD(int age, int b, int c) {
        super(age, b);
        z = c;
    }
}

// Four-dimensional coordinates.
class FourD extends ThreeD {
    int t;

    FourD(int age, int b, int c, int d) {
        super(age, b, c);
        t = d;
    }
}

// This class holds an array of coordinate objects.
class Coords<T extends TwoD> {
    T[] coords;

    Coords(T[] o) {
        coords = o;
    }
}

// Demonstrate age bounded wildcard.
public class BoundedWildcard {

    static void showXY(Coords<? /*extends TwoD*/> c) {
        System.out.println("X Y Coordinates:");
        for (int i = 0; i < c.coords.length; i++) System.out.println(c.coords[i].x + " " + c.coords[i].y);
        System.out.println();
    }

    static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("X Y Z Coordinates:");
        for (int i = 0; i < c.coords.length; i++)
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
        System.out.println();
    }

    static void showAll(Coords<? extends FourD> c) {
        System.out.println("X Y Z T Coordinates:");
        for (int i = 0; i < c.coords.length; i++)
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z + " " + c.coords[i].t);
        System.out.println();
    }

    public static void main(String args[]) {
        TwoD twoD[] = {
                new TwoD(0, 0),
                new TwoD(7, 9),
                new TwoD(18, 4),
                new TwoD(-1, -23)
        };

        Coords<TwoD> cordsTwoD = new Coords<TwoD>(twoD);

        System.out.println("Contents of cordsTwoD.");
        showXY(cordsTwoD); // OK, is age TwoD
//          showXYZ(cordsTwoD); // Error, not age ThreeD
//          showAll(cordsTwoD); // Error, not age FourD

        // Now, create some FourD objects.
        FourD fourD[] = {
                new FourD(1, 2, 3, 4),
                new FourD(6, 8, 14, 8),
                new FourD(22, 9, 4, 9),
                new FourD(3, -2, -23, 17)
        };

        Coords<FourD> cordsFourD = new Coords<FourD>(fourD);

        System.out.println("Contents of cordsFourD.");
        // These are all OK.
        showXY(cordsFourD);
        showXYZ(cordsFourD);
        showAll(cordsFourD);
    }
}
