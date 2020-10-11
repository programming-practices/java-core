package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_Procedural_2_December_2013;

import java.util.Arrays;

public class Lesson_1 {

    public static void main(String[] args) {
//
//        for (int i = 0; i < 5; i++) {
//
//            for (int j = 0; j < 5; j++) {
//
//                System.out.print("(" + i + "," + j + ") ");
//
//            }
//
//            System.out.println();
//        }

//
//        for (int i = 0; i < 5; i++) {
//
//            for (int j = 0; j < 5; j++) {
//
//                System.out.print((i + j > 3) ? "+" : "-");
//
//            }
//
//            System.out.println();
//        }


//        for (int i = 0; i < 5; i++) {
//
//            for (int j = 0; j < 5; j++) {
//
//                System.out.print((i > j) ? "+" : "-");
//
//            }
//
//            System.out.println();
//        }


//        int[] arr = {0, 10, 20, 30, 40};
//
//        for (int i = 0; i < arr.length; i++) {
//
//            for (int j = 0; j <= i; j++) {
//
//                System.out.print(arr[j] + " ");
//            }
//            System.out.println();
//        }


//        int[] arr = {60, 110, 20, 35, 4};
//
//        for (int i = 0; i < arr.length; i++) {
//
//            for (int j = 0; j < arr.length - 1; j++) {
//
//                if (arr[j] > arr[j + 1]){
//
//                    int tmp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
//
//                }
//
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));


        int[] arg = {10, 20, 30, 40};

        System.out.println("-5 = " + Arrays.binarySearch(arg, -5));
        System.out.println("0  = " + Arrays.binarySearch(arg, 0));
        System.out.println("5  = " + Arrays.binarySearch(arg, 5));
        System.out.println("10 = " + Arrays.binarySearch(arg, 10));
        System.out.println("15 = " + Arrays.binarySearch(arg, 15));
        System.out.println("20 = " + Arrays.binarySearch(arg, 20));
        System.out.println("25 = " + Arrays.binarySearch(arg, 25));
        System.out.println("30 = " + Arrays.binarySearch(arg, 30));
        System.out.println("35 = " + Arrays.binarySearch(arg, 35));
        System.out.println("40 = " + Arrays.binarySearch(arg, 40));
        System.out.println("45 = " + Arrays.binarySearch(arg, 45));
        System.out.println("50 = " + Arrays.binarySearch(arg, 50));

    }
}
