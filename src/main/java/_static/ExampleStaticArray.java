package _static;

public class ExampleStaticArray {
    public static int[] arrays = new int[3];
}


class Main02 {
    public static void main(String[] args) {
        ExampleStaticArray.arrays = new int[6];
        System.out.println(ExampleStaticArray.arrays.length);
    }
}
