package generics.biblioteka_kortezei;


public class TupleTest {

    public static TwoTuple<String, Integer> f() {
        // Autoboxing converts the int to Integer:
        return new TwoTuple<String, Integer>("hi", 47);
    }


    public static ThreeTuple<Amphibian, String, Integer> threeTuple() {
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }


    public static FourTuple<Vehicle, Amphibian, String, Integer> fourTuple() {
        return new FourTuple<Vehicle, Amphibian, String, Integer>(new Vehicle(), new Amphibian(), "hi", 47);
    }


    public static FiveTuple<Vehicle, Amphibian, String, Integer, Double> fiveTuple() {
        return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }


    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        // ttsi.first = "there"; // Compile error: final
        System.out.println(threeTuple());
        System.out.println(fourTuple());
        System.out.println(fiveTuple());
    }
}
