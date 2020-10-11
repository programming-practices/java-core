package generics.anonimnue_vnytrennie_klassu;


import others.entities.Generator;

public class Teller {
    // A single Generator object:
    public static Generator<Teller> generator =
            new Generator<Teller>() {
                public Teller next() {
                    return new Teller();
                }
            };
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    public String toString() {
        return "Teller " + id;
    }
}
