package _final;

import java.util.Arrays;

public class ExampleFinalArray {
    public static void main(String[] args) {
        int[] arr2 = new int[12];
        ClassA classA = new ClassA();

        // The reference to the final array can not be changed
//        finalArray.arr = arr2;     // ERROR

        // No dozvoleno izmenat vmestimoe array
        classA.arr[0] = 10;
        classA.arr[1] = 20;
        classA.arr[2] = 30;
        System.out.println(Arrays.toString(classA.arr));


    }

}

class ClassA {
    public final int[] arr = new int[3];
}