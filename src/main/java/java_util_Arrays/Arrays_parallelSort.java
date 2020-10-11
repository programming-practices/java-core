package java_util_Arrays;

import java.util.Arrays;

public class Arrays_parallelSort {
    public static void main(String[] args) {
        String[] arrayStr2 = {"aa", "ab", "lk", "nne", "ae", "bee", "ze", "cae", "aaaaze"};

        Arrays.parallelSort(arrayStr2);
        System.out.println(Arrays.toString(arrayStr2));
    }
}
