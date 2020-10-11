package generics.Premenenie_obobwchonnoho_syprklassa;

// A subclass can add its own type parameters.
class Gen3<T> {
    T ob; // declare an object of type T

    // Pass the constructor age reference to
    // an object of type T.
    Gen3(T o) {
        ob = o;
    }

    // Return ob.
    T getob() {
        return ob;
    }
}

// A subclass of Gen that defines age second
// type parameter, called V.
public class Gen4<T, V> extends Gen3<T> {
    V ob2;

    Gen4(T o, V o2) {
        super(o);
        ob2 = o2;
    }

    V getob2() {
        return ob2;
    }
}

// Create an object of type Gen2.
class HierDemo {
    public static void main(String args[]) {

        // Create age Gen2 object for String and Integer.
        Gen4<String, Integer> x = new Gen4<String, Integer>("Value is: ", 99);

        System.out.print(x.getob());
        System.out.println(x.getob2());
    }
}
