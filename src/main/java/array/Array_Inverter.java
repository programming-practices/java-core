package array;

import java.util.Arrays;

public class Array_Inverter {
    public static void main(String[] args) {
        int[] arg = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(arg));

        Array_Inverter.invert_InPlace(arg);
//        ArrayInverter.invert_OutOfPlace(arg);
//        ArrayInverter.invert_Recursion(arg, 0);

        System.out.println(Arrays.toString(arg));
    }


    /**
     * Invert array with recursion
     *
     * @param array array to invert
     * @param index inicial index of array
     */
    public static void invert_Recursion(int[] array, int index) {
        if (index < ((array.length - 1) / 2)) {
            int tmp = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = tmp;
            invert_Recursion(array, index + 1);
        }
    }

    /**
     * Algorithm out of place - This means that for this implementation another array will be used to store the inverted array.
     * int[] a = {1,2,3,4,5}  int[] b = {5,4,3,2,1}
     * This algorithm takes up more space.
     */
    public static void invert_OutOfPlace(int[] arg) {
        int[] tmp = Arrays.copyOf(arg, arg.length);     // bilwe zanimae pamiati, a wchot toho wo sozdae novui masiv tmp
        int index = 0;
        for (int i = tmp.length - 1; i >= 0; i--) {     // i povunen proitu celuimasiv
            arg[index] = tmp[i];
            index++;
        }
    }

    /**
     * Algorithm in place - Means that the inversion of the array will occur in the same array.
     * But the original array will be lost.
     * int[] a = {1,2,3,4,5}   a[] = {5,4,3,2,1}
     * This implementation takes up less space than the "out of place" algorithm.
     */
    public static void invert_InPlace(int[] arg) {
        for (int index = 0; index < arg.length / 2; index++) {
            int tmp = arg[index];
            arg[index] = arg[arg.length - 1 - index];
            arg[arg.length - 1 - index] = tmp;
        }
    }
}
