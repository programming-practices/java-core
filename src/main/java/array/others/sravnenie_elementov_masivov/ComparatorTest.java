package array.others.sravnenie_elementov_masivov;

import array.others.primenenie_heneratorov_dlya_sozdania_masivov.Generated;

import java.util.Arrays;
import java.util.Comparator;

class CompTypeComparator implements Comparator<CompType> {
    public int compare(CompType compType00, CompType compType01) {
        return (compType00.valueB < compType01.valueB ? -1 : (compType00.valueA == compType01.valueB ? 0 : 1));
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] arrayCompType = Generated.array(new CompType[12], CompType.generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(arrayCompType));
        Arrays.sort(arrayCompType, new CompTypeComparator());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(arrayCompType));

    }
}
