package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_Procedural_1_December_2013;

import java.util.Arrays;

public class _3_Lesson {

    public static void main(String[] args) {

        int[] array = {5, 1, 3, 4, 0, 8, 9, 7, 6, 2};

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            conditionalSwap(array, i, i + 1);
        }
        System.out.println(Arrays.toString(array));
    }


    public static void conditionalSwap(int[] array, int fst, int snd) {

        if (array[fst] > array[snd]) {

            int tmp = array[fst];

            array[fst] = array[snd];

            array[snd] = tmp;

        }
    }


//    public static void main(String[] args) {
//
//        int[] array = {5, 1, 3, 4, 0, 8, 9, 7, 6, 2};
//
//        System.out.println(Arrays.toString(array));
//
//        for (int i = 0; i < array.length - 1; i++) {
//            conditionalSwap(array, i, i + 1);
//        }
//        System.out.println(Arrays.toString(array));
//    }
//
//
//    public static void conditionalSwap(int[] array, int fst, int snd){
//
//        int tmp = array[fst];
//
//        array[fst] = array[snd];
//
//        array[snd] = tmp;
//
//    }


//    public static void main(String[] args) {
//
//        for (int i = 0; i < 5; i++) {
//
//            for (int j = 0; j < 5; j++) {
//
//                System.out.print("(" + i + "," + j + ") ");
//
//            }
//            System.out.println();
//        }
//    }


//    public static void main(String[] args) {

//        String s = "Hola";
////        System.out.println(s);
////        System.out.println(StringInverter.stringInverter2(s));
//
//
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i));
//        }
//
//        System.out.println();
//
//        // ERROR
//        for (int i = s.length() - 1; i > 0; i++) {
//            System.out.println(s.charAt(i));
//        }


//
//        StringBuilder s = new StringBuilder("Hola");
//
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i));
//        }
//
//        System.out.println();
//
//        // ERROR
//        for (int i = s.length() - 1; i > 0; i++) {
//            System.out.println(s.charAt(i));
//        }
//    }

}
