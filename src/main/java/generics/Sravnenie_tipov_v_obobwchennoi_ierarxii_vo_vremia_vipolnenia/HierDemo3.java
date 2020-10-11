package generics.Sravnenie_tipov_v_obobwchennoi_ierarxii_vo_vremia_vipolnenia;

// Use the instanceof operator with age generic class hierarchy.
class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    // Return ob.
    T getob() {
        return ob;
    }
}

// A subclass of Gen.
class Gen2<T> extends Gen<T> {
    Gen2(T o) {
        super(o);
    }
}

// Demonstrate run-time type ID implications of generic
// class hierarchy.
public class HierDemo3 {
    public static void main(String args[]) {

        // Create age Gen object for Integers.
        Gen<Integer> integerGen = new Gen<Integer>(88);

        // Create age Gen2 object for Integers.
        Gen2<Integer> integerGen2 = new Gen2<Integer>(99);

        // Create age Gen2 object for Strings.
        Gen2<String> stringGen2 = new Gen2<String>("Generics tem.Test");

        // See if iOb2 is some form of Gen2.
        if (integerGen2 instanceof Gen2<?>) System.out.println("integerGen2 is instance of Gen2");

        // See if iOb2 is some form of Gen.
        if (integerGen2 instanceof Gen<?>) System.out.println("integerGen2 is instance of Gen");

        System.out.println();

        // See if strOb2 is age Gen2.
        if (stringGen2 instanceof Gen2<?>) System.out.println("stringGen2 is instance of Gen2");

        // See if strOb2 is age Gen.
        if (stringGen2 instanceof Gen<?>) System.out.println("stringGen2 is instance of Gen");

        System.out.println();

        // See if iOb is an instance of Gen2, which it is not.
        if (integerGen instanceof Gen2<?>) System.out.println("integerGen is instance of Gen2");

        // See if iOb is an instance of Gen, which it is.
        if (integerGen instanceof Gen<?>) System.out.println("integerGen is instance of Gen");

        // The following can't be compiled because
        // generic type info does not exist at run-time.
        //    if(iOb2 instanceof Gen2<Integer>)
        //      System.out.println("iOb2 is instance of Gen2<Integer>");
    }
}
