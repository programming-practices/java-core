package memory_model;

//import javax.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;

/**
 * Sources: https://www.youtube.com/watch?v=inBUNUOrFVI&list=PLoij6udfBncilPJMzXtsOyUutDDULrtEm
 * start: 0:00 end...
 */
public class MemoryModel {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("\n-------- 1 ---------");
        int x = 0;
        int y = x;
        x = 1;
        System.out.println(x);
        System.out.println(y);

        System.out.println("\n--------- 2 --------");
        Integer x1 = new Integer(0);
        Integer y1 = x1;
        x1 = new Integer(1);
        System.out.println(x1);
        System.out.println(y1);

        System.out.println("\n--------- 3 --------");
        String s = "0";
        String s1 = s;
        s = "1";
        System.out.println(s);
        System.out.println(s1);

// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("\n--------- 4 --------");
        int[] arrayA = {1, 2, 3, 4};
        int[] arrayAA = arrayA;
        arrayA[0] = 10;
        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayAA));

        System.out.println("\n--------- 5 --------");
        int[] arrayB = {1, 2, 3, 4, 5};
        int[] arrayBB = arrayB;
        arrayB = null;
        System.out.println(Arrays.toString(arrayB));
        System.out.println(Arrays.toString(arrayBB));

        System.out.println("\n--------- 6 --------");
        int[] ints = {1, 2, 3, 4};
        System.out.println(Arrays.toString(ints));
        ints = method2(ints);
        System.out.println(Arrays.toString(ints));

// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("\n-------- 7 ---------");
        HolderValue<Integer> hvA = new HolderValue<>(0);
        HolderValue<Integer> hvB = hvA;
        hvA.setValue(1);
        System.out.println("integerHolderA = " + hvA);
        System.out.println("integerHolderB = " + hvB);

        System.out.println("\n--------- 8 --------");
        HolderValue<Integer> hvC = new HolderValue<>(0);
        System.out.println(hvC);
        hvC = method1(hvC);
        System.out.println(hvC);

        System.out.println("\n--------- 9 --------");
        HolderValue<Integer> hvD = new HolderValue<>(0);
        System.out.println(hvD);
        method3(hvD);
        System.out.println(hvD);

        System.out.println("\n--------- 10 --------");
        HolderValue<Integer> hvE = new HolderValue<>(0);
        System.out.println(hvE);
        method4(hvE);
        System.out.println(hvE);

        System.out.println("\n--------- 10 --------");
        HolderValue<Integer> hvF = new HolderValue<>(0);
        System.out.println(hvF);
        method5(hvF);
        System.out.println(hvF);

// ---------------------------------------------------------------------------------------------------------------------


// ---------------------------------------------------------------------------------------------------------------------


// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
    }

    private static void method5(HolderValue<Integer> hvF) {
        hvF.setValue(1);
    }

    private static void method4(HolderValue<Integer> hvE) {
        hvE = null;
    }

    private static void method3(HolderValue<Integer> hvi) {
        hvi = new HolderValue<>(1);
    }

    private static int[] method2(int[] array) {
        return new int[]{array[0] + 10, array[1] + 10, array[2] + 10, array[3] + 10};
    }

    private static HolderValue<Integer> method1(HolderValue<Integer> value) {
        return new HolderValue<>(value.getValue() + 1);
    }


}

class HolderValue<T> {
    private T value;

    public HolderValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}