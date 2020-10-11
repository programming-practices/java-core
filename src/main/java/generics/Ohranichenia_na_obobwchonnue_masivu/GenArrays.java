package generics.Ohranichenia_na_obobwchonnue_masivu;

import java.util.Arrays;

// Generics and arrays.
class Gen<T extends Number> {
    T ob;

    T vals[]; // OK

    Gen(T o, T[] nums) {
        ob = o;

        // This statement is illegal.
        // vals = new T[10]; // can't create an array of T

        // But, this statement is OK.
        vals = nums; // OK to assign reference to existent array
    }

    @Override
    public String toString() {
        return ob.getClass().getSimpleName() + "  end:  " + vals.getClass().getSimpleName();
    }
}

public class GenArrays {
    public static void main(String args[]) {
        Integer n[] = {1, 2, 3, 4, 5};

        Gen<Integer> iOb = new Gen<Integer>(50, n);

        // Can't create an array of type-specific generic references.
        // Gen<Integer> gens[] = new Gen<Integer>[10]; // Wrong!

        // This is OK.
        Gen<?> gens[] = new Gen<?>[10]; // OK
//        gens[0] = 1;    // ERROR

        Gen<?> gens1[] = {new Gen<Integer>(3, new Integer[3]), new Gen<Double>(5.9, new Double[1])};
        System.out.println(Arrays.toString(gens));
        System.out.println(Arrays.toString(gens1));
    }
}
