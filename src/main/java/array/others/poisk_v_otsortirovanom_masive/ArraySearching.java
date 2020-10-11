package array.others.poisk_v_otsortirovanom_masive;

import array.others.heneratoru_dannux.RandomGenerator;
import array.others.primenenie_heneratorov_dlya_sozdania_masivov.ConvertTo;
import array.others.primenenie_heneratorov_dlya_sozdania_masivov.Generated;
import others.entities.Generator;

import java.util.Arrays;

public class ArraySearching {

    public static void main(String[] args) {

        Generator<Integer> gen = new RandomGenerator.Integer(1000);

        int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));

        Arrays.sort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));

        while (true) {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                System.out.println("Location of " + r + " is " + location +
                        ", a[" + location + "] = " + a[location]);
                break; // Out of while loop
            }
        }
    }
}
