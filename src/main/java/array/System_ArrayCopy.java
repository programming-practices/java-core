package array;

import static java.lang.System.arraycopy;
import static java.lang.System.out;

import java.util.Arrays;


/**
 * Sources:
 * 1. https://www.youtube.com/watch?v=Rtbsced1Y9M&list=PLoij6udfBncjzPJ4yyysa4Fqz1BrZH3g9&index=4
 */
public class System_ArrayCopy {

    static byte lettersOfTheAlphabet[] = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74};
    static byte destinationArgs[] = {77, 77, 77, 77, 77, 77, 77, 77, 77, 77};

    public static void main(String args[]) {

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

        int[] arrNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrZeros = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

//        out.println("arr0 = " + Arrays.toString(arrNumbers));
//        out.println("arr1 = " + Arrays.toString(arrZeros));

//        out.println();
        arraycopy(arrNumbers, 1, arrZeros, 2, 3);
//        out.println("arr1 = " + Arrays.toString(arrZeros));

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

        int[] arr0 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        out.println("arr0 = " + Arrays.toString(arr0));

//        out.println();
        arraycopy(arr0, 1, arr0, 3, 3);
//        out.println("arr0 = " + Arrays.toString(arr0));

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

        String[] argsA = new String[7];
        String[] argsB = new String[10];

        Arrays.fill(argsA, "A");
        Arrays.fill(argsB, "B");

//        out.println("\n------------------------------------------------- 1");
//        out.println("argsA = " + Arrays.toString(argsA));
//        out.println("argsB = " + Arrays.toString(argsB));
        arraycopy(argsA, 0, argsB, 0, argsA.length);
//        out.println("argsB = " + Arrays.toString(argsB));

//        out.println("\n------------------------------------------------- 2");
        String[] argsC = new String[5];
        Arrays.fill(argsC, "C");
        arraycopy(argsA, 0, argsC, 0, argsC.length);
//        out.println("argsC = " + Arrays.toString(argsC));

        out.println("\n------------------------------------------------- 3");
        Arrays.fill(argsC, "C");
//        arraycopy(argsA, 0, argsC, 0, argsA.length);   // ERROR
//        out.println("argsC = " + Arrays.toString(argsC));

//        out.println("\n------------------------------------------------- 4");
        Arrays.fill(argsC, "C");
        arraycopy(argsC, 0, argsA, 0, argsC.length);
//        out.println("argsA = " + Arrays.toString(argsA));

//        out.println("\n------------------------------------------------- 5");
//         Objects:
        Integer[] argsD = new Integer[10];
        Integer[] argsE = new Integer[5];
        Arrays.fill(argsD, 47);
        Arrays.fill(argsE, 99);
//        out.println("argsD = " + Arrays.toString(argsD));
//        out.println("argsE = " + Arrays.toString(argsE));
        arraycopy(argsE, 0, argsD, argsD.length / 2, argsE.length);
//        out.println("argsD = " + Arrays.toString(argsD));

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

    }
}