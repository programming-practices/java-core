package collections;

public class ExampleIteration {
    public static void main(String[] args) {

//        for (int i = 0; i < 10; i++) {
//            System.out.print(i + " ");
//            i -=2;
//        }

//        for (int i = 0; i < 10; i++) {
////            System.out.print(i --  + " ");
//            System.out.print(i);
//            i--;
//        }

//        for (int i = 0; i < 8; i++) {
//        System.out.print(">> ");
//            for (int j = 0; j < 4; j++) {
//                System.out.print("{i = " + i + ", j = " + j + "} ");
//            }
//            System.out.println();
//        }


        int[] array = {0, 10, 20, 30, 40};
//        for (int i = 0; i < array.length; i++) {
//        System.out.print(">> ");
//            for (int j = 0; j <= i; j++) {
//                System.out.print(array[j] + " ");
//            }
//            System.out.println();
//        }

//        for (int i = array.length - 1; i >= 0; i--) {
//        System.out.print(">> ");
//            for (int j = i; j >= 0; j--) {
//                System.out.print(array[j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(">> ");
            for (int j = 0; j <= i; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();

        }
    }
}
