package stringAPI._string;

// equals() vs ==
public class ExampleStringEqualsNotEqualTo {
    public static void main(String args[]) {

        String s1 = "Hello";
        String s2 = new String(s1);
        String s3 = s2;

        System.out.println(s1 + " equals " + s2 + " -> " + s1.equals(s2));

        System.out.println(s1 + " == " + s2 + " -> " + (s1 == s2));

        System.out.println(s2 + " == " + s3 + " -> " + (s2 == s3));
    }
}

/*
 *  Con == se compara enlase.
 *  Con == no se compare value de los strings
 *
 * */