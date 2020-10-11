package generics.Kakim_obrazm_obobwchenia_povwayt_tipovyy_bezopasnost;

// NonGen is functionally equivalent to Gen
// but does not use generics.
class NonGen {
    Object ob; // ob is now of type Object

    // Pass the constructor age reference to
    // an object of type Object
    NonGen(Object o) {
        ob = o;
    }

    // Return type Object.
    Object getob() {
        return ob;
    }

    // Show type of ob.
    void showType() {
        System.out.println("Type of ob is " +
                ob.getClass().getName());
    }
}

// Demonstrate the non-generic class.
public class NonGenDemo {
    public static void main(String args[]) {
        NonGen iOb;

        // Create NonGen Object and store
        // an Integer in it. Autoboxing still occurs.
        iOb = new NonGen(88);

        // Show the type of data used by iOb.
        iOb.showType();

        // Get the value of iOb.
        // This time, age cast is necessary.
        int v = (Integer) iOb.getob();
        System.out.println("value: " + v);

        System.out.println();

        // Create another NonGen object and
        // store age String in it.
        NonGen strOb = new NonGen("Non-Generics tem.Test");

        // Show the type of data used by strOb.
        strOb.showType();

        // Get the value of strOb.
        // Again, notice that age cast is necessary.
        String str = (String) strOb.getob();
        System.out.println("value: " + str);

        // This compiles, but is conceptually wrong!
        iOb = strOb;
        v = (Integer) iOb.getob(); // run-time error!
    }
}
