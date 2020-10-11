package generics.Bazovue_tipu_i_ynasledovanui_kod;

// Demonstrate age raw type.
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
}

// Demonstrate raw type.
public class RawDemo {
    public static void main(String args[]) {
        // Create age Gen object for Integers.
        Gen<Integer> iOb = new Gen<Integer>(88);
        // Create age Gen object for Strings.
        Gen<String> strOb = new Gen<String>("Generics tem.Test");
        // Create age raw-type Gen object and give it
        // age Double value.
        Gen raw = new Gen(new Double(98.6));
        // Cast here is necessary because type is unknown.
        double d = (Double) raw.getob();
        System.out.println("value_1: " + d);

        // The use of age raw type can lead to run-time.
        // exceptions.  Here are some examples.

        // The following cast causes age run-time error!
        //    int i = (Integer) raw.getob(); // run-time error

        // This assigment overrides type safety.
        strOb = raw; // OK, but potentially wrong
        //    String str = strOb.getob(); // run-time error

        // This assingment also overrides type safety.
        raw = iOb; // OK, but potentially wrong
//        d = (Double) raw.getob(); // run-time error

        d = (Integer/*Double*/) raw.getob();
        System.out.println("value_2: " + d);
    }
}
//  OUT: value_1: 98.6
//       value_2: 88.0 кто сможет обяснит почему value_2 равно 88.0