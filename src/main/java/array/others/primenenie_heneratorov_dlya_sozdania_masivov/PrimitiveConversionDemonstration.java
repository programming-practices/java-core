package array.others.primenenie_heneratorov_dlya_sozdania_masivov;

import generics.primitivu_ne_nemohyt_ispolzovatsa_kak_parametru_tipu.CountingGenerator;

import java.util.Arrays;

public class PrimitiveConversionDemonstration {

    public static void main(String[] args) {

        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);

        int[] b = ConvertTo.primitive(a);

        System.out.println(Arrays.toString(b));

        boolean[] c = ConvertTo.primitive(Generated.array(Boolean.class, new CountingGenerator.Boolean(), 7));

        System.out.println(Arrays.toString(c));
    }
}
