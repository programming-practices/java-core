package oop;

public class VidimostiPeremennux {

    static int variable;
    static int[] array;
    static Object obj;

    public static void main(String[] args) {

        int[] localArray;
        int[] localArray2 = new int[12];
        int localVariable;
        Object localObj;

        int[] localarray3 = {1, 2, 3};

//        System.out.println(localVariable);            // Error
        System.out.println(variable);

//        System.out.println(localArray);              // Error
        System.out.println(array);

//        System.out.println(localObj);                // ERROR
        System.out.println(obj);

        System.out.println(localArray2[1]);

        System.out.println(localarray3[0]);
        System.out.println(localarray3[1]);
        System.out.println(localarray3[2]);
//        System.out.println(localarray3[-1]);
//        System.out.println(localarray3[10]);
    }
}

