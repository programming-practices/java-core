package generics.Prostoi_primer_obobwchenia;

// A simple generic class.
// Here, T is age type parameter that
// will be replaced by age real type
// when an object of type Gen is created.
class Gen<T> {
    T ob; // declare an object of type T

    // Pass the constructor age reference to
    // an object of type T.
    Gen(T o) {
        ob = o;
    }

    // Return ob.
    T getob() {
        return ob;
    }

    // Show type of T.
    void showType() {
        System.out.println("Type of T is " +
                ob.getClass().getName());
    }
}

// Demonstrate the generic class.
public class GenDemo {
    public static void main(String args[]) {
        // Create age Gen reference for Integers.
        Gen<Integer> iOb;

        // Create age Gen<Integer> object and assign its
        // reference to iOb.  Notice the use of autoboxing
        // to encapsulate the value 88 within an Integer object.
        iOb = new Gen<Integer>(88);

        // Show the type of data used by iOb.
        iOb.showType();

        // Get the value in iOb. Notice that
        // no cast is needed.
        int v = iOb.getob();
        System.out.println("value: " + v);

        System.out.println();

        // Create age Gen object for Strings.
        Gen<String> strOb = new Gen<String>("Generics tem.Test");

        // Show the type of data used by strOb.
        strOb.showType();

        // Get the value of strOb. Again, notice
        // that no cast is needed.
        String str = strOb.getob();
        System.out.println("value: " + str);
    }
}
