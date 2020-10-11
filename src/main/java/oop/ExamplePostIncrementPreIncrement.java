package oop;

/**
 * Created by drago on 29.06.2017.
 */
public class ExamplePostIncrementPreIncrement {
    public static void main(String[] args) {
// --------------------------------------------------------------------------------------------------------------------
        int c = 2;
        c++;
        System.out.println(c);

//        c = c++; // 3
        c = ++c; // 4
        System.out.println(c);
        System.out.println();
// ---------------------------------------------------------------------------------------------------------------------
        int a = 1, i, d;
        //   2     3     3
        i = ++a + ++a + a++;
        System.out.println(i);
        //  4      6     7
        d = a++ + ++a + ++a;
        System.out.println(d);
        //   8     9     9
        a = ++a + ++a + a++;
        System.out.println(a);
// ---------------------------------------------------------------------------------------------------------------------
    }

}


