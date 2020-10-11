package array.others.sravnenie_elementov_masivov;

import array.others.primenenie_heneratorov_dlya_sozdania_masivov.Generated;
import others.entities.Generator;

import java.util.Arrays;
import java.util.Random;


public class CompType implements Comparable<CompType> {

    private static int count = 1;
    private static Random random = new Random(47);
    int valueA;
    int valueB;

    public CompType(int valueA, int valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            public CompType next() {
                return new CompType(random.nextInt(100), random.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {

        CompType[] a = Generated.array(new CompType[12], generator());

        System.out.println("before sorting:");

        System.out.println(Arrays.toString(a));

        Arrays.sort(a);

        System.out.println("after sorting:");

        System.out.println(Arrays.toString(a));

    }

    public String toString() {
        String result = "[valueA = " + valueA + ", valueB = " + valueB + "]";
//        if(count++ % 3 == 0)
//            result += "\n";
        return result;
    }

    public int compareTo(CompType compType) {
        return (valueA < compType.valueA ? -1 : (valueA == compType.valueA ? 0 : 1));
    }
}
