package array.others.poisk_v_otsortirovanom_masive;

import array.others.heneratoru_dannux.RandomGenerator;
import array.others.primenenie_heneratorov_dlya_sozdania_masivov.Generated;

import java.util.Arrays;

public class AlphabeticSearch {

    public static void main(String[] args) {

        String[] sa = Generated.array(new String[30], new RandomGenerator.String(5));

        System.out.println(Arrays.toString(sa));

        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);

        System.out.println(Arrays.toString(sa));

        int index = Arrays.binarySearch(sa, sa[10], String.CASE_INSENSITIVE_ORDER);

        System.out.println("Index: " + index + "\n" + sa[index]);

    }
}
