package java_util_Arrays;

import java.util.Arrays;

public class Arrays_BinarySearch {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        int[] arg = {10, 20, 30, 40};
        int pos = Arrays.binarySearch(arg, 20);
        System.out.println(pos);
        System.out.println(arg[pos]);
        System.out.println("--------------------------");
        pos = Arrays.binarySearch(arg, 25);
        // Esli binary search ne naxodit elementa to on vozvrawchaer minusovui index hde mozno raspolozit iskaimoe
        // znachenie (no pri etom nado vzat etot minusovui index i otniat -1)
        // Smotret video: https://www.youtube.com/watch?v=xP90b2zSl8M&list=PLoij6udfBncjzPJ4yyysa4Fqz1BrZH3g9&index=2
        //                https://www.youtube.com/watch?v=MlcoKlJ40Sg&index=3&list=PLoij6udfBncjzPJ4yyysa4Fqz1BrZH3g9
        // S 36:40 do ..
        System.out.println(pos);
        System.out.println("--------------------------");
        System.out.println(Arrays.binarySearch(arg, 10));
        System.out.println(Arrays.binarySearch(arg, 15));
        System.out.println(Arrays.binarySearch(arg, 20));
        System.out.println(Arrays.binarySearch(arg, 25));
        System.out.println(Arrays.binarySearch(arg, 30));
        System.out.println(Arrays.binarySearch(arg, 35));
        System.out.println(Arrays.binarySearch(arg, 40));
        System.out.println(Arrays.binarySearch(arg, 45));

// --------------------------------------------------------------------------------------------------------------------
        int size = 5;
        int[] array = {20, 30, 40, 50, 60, 0, 0, 0, 0, 0, 0, 0, 0};
//        System.out.println(Arrays.toString(args));
        int[] insert = {15, 95, 30};

//        for(int newElement : insert){
//            int newPosition = Arrays.binarySearch(array, 0, size, newElement);
//            if(newPosition < 0){
//                newPosition = -newPosition - 1;
//            }
//            System.arraycopy(array, newPosition, array, newPosition - 3, 1);    // no work
//            array[newPosition] = newElement;
//            System.out.println(Arrays.toString(array));
//            size++;
//        }
        /*
         * [20, 30, 40, 50, 60, 0, 0, 0, 0, 0, 0, 0, 0]
         * [15, 20, 30, 40, 50, 60, 0, 0, 0, 0, 0, 0, 0, 0]
         * [15, 20, 30, 40, 50, 60, 95, 0, 0, 0, 0, 0, 0, 0, 0]
         * [15, 20, 30, 30, 40, 50, 60, 95, 0, 0, 0, 0, 0, 0, 0, 0]
         * */

// --------------------------------------------------------------------------------------------------------------------
    }
}


/*

  binarySearch(x) -> position encounter:       0, 1, 2, 3, ...
  binarySearch(x) -> position not encounter:  -1, -2, -3, -4, ...

*/