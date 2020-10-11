package dataType;

import static java.lang.System.out;

/**
 * Link sources of information:
 * 1. https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html
 * 2. https://www.w3schools.com/java/java_data_types.asp
 * 3. https://www.youtube.com/watch?v=inBUNUOrFVI&list=PLoij6udfBncilPJMzXtsOyUutDDULrtEm    Golovach
 */
public class NotPrimitiveDataTypes {
    public static void main(String[] args) {

//======================================================================================================================
//====================================================== String ========================================================
//======================================================================================================================

        // The String data type is used to store a sequence of characters (text). String values must be surrounded
        // by double quotes:
        String greeting = "Hello World";
//        System.out.println(greeting);

        // The String data type is so much used and integrated in Java, that some call it "the special ninth type".
        // A String in Java is actually a non-primitive data type, because it refers to an object. The String object
        // has methods that is used to perform certain operations on strings.

//======================================================================================================================
//============================================ transfer by reference ===================================================
//======================================================================================================================

        int[] argsX = {0, 1, 2};
        int[] argsY = argsX;
        argsX[0] = 10;
//        out.println("argsX = " + Arrays.toString(argsX));
//        out.println("argsY = " + Arrays.toString(argsY));

        int[] argsXX = {0, 1, 2};
        int[] argsYY = argsXX;
        argsXX = null;
//        out.println("argsXX = " + Arrays.toString(argsXX));
//        out.println("argsYY = " + Arrays.toString(argsYY));

        IntHolder intHolder = new IntHolder(0);
        out.println(intHolder);
        intHolder = method_1(intHolder);
        out.println(intHolder);

        IntHolder intHolder_1 = new IntHolder(0);
        out.println(intHolder_1);
        method_2(intHolder_1);
        out.println(intHolder_1);

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================


    }

    public static IntHolder method_1(IntHolder intHolder) {
        return new IntHolder(intHolder.value + 1);
    }

    public static void method_2(IntHolder intHolder) {
        intHolder.value = intHolder.value + 1;
    }

}

class IntHolder {

    public int value;

    public IntHolder(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntHolder{" +
                "value=" + value +
                '}';
    }
}


/*

Non-primitive data types - such as Classes, AbstractClasses, Interfaces, Arrays, Enums...

Non-primitive data types are called reference types because they refer to objects.

The main difference between primitive and non-primitive data types are:
        * Primitive types are predefined (already defined) in Java. Non-primitive types are created by the programmer
          and is not defined by Java (except for String).
        * Non-primitive types can be used to call methods to perform certain operations, while primitive types cannot.
        * A primitive type has always a value, while non-primitive types can be null.
        * A primitive type starts with a lowercase letter, while non-primitive types starts with an uppercase letter.
        * The size of a primitive type depends on the data type, while non-primitive types have all the same size.

*/