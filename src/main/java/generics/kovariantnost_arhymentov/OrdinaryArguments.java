package generics.kovariantnost_arhymentov;

class OrdinarySetter {

    void set(Base base) {
        System.out.println("OrdinarySetter.set(Base)");
    }
}

class DerivedSetter extends OrdinarySetter {

    //  OVERLOADED
    void set(Derived derived) {
        System.out.println("DerivedSetter.set(Derived)");
    }
}

public class OrdinaryArguments {

    public static void main(String[] args) {

        Base base = new Base();

        Derived derived = new Derived();

        DerivedSetter derivedSetter = new DerivedSetter();

        derivedSetter.set(derived);

        derivedSetter.set(base); // Compiles: overloaded, not overridden!

    }
}
