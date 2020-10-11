package TypeInformation.instanceOf_i_sravnenie_obektov_class;

class Base {
}

class Derived extends Base {
}

public class FamilyVsExactType {

    static void test(Object x) {

        System.out.println("Testing tamanoPequenio of type   " + x.getClass());

        System.out.println("tamanoPequenio instanceof Base   " + (x instanceof Base));

        System.out.println("tamanoPequenio instanceof Derived   " + (x instanceof Derived));

        System.out.println("Base.isInstance(tamanoPequenio)   " + Base.class.isInstance(x));

        System.out.println("Derived.isInstance(tamanoPequenio)   " + Derived.class.isInstance(x));

        System.out.println("tamanoPequenio.getClass() == Base.class   " + (x.getClass() == Base.class));

        System.out.println("tamanoPequenio.getClass() == Derived.class   " + (x.getClass() == Derived.class));

        System.out.println("tamanoPequenio.getClass().equals(Base.class))   " + (x.getClass().equals(Base.class)));

        System.out.println("tamanoPequenio.getClass().equals(Derived.class))   " + (x.getClass().equals(Derived.class)));

    }

    public static void main(String[] args) {

        test(new Base());
        System.out.println();
        test(new Derived());
    }
}
