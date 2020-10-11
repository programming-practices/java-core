package array.others.primenenie_heneratorov_dlya_sozdania_masivov;

import generics.primitivu_ne_nemohyt_ispolzovatsa_kak_parametru_tipu.RandomGenerator;

import java.util.Arrays;

public class TestArrayGeneration {

    public static void main(String[] args) {

        int size = 6;

        boolean[] a1 = ConvertTo.primitive(Generated.array(Boolean.class, new RandomGenerator.Boolean(), size));
        System.out.println("java.a1 = " + Arrays.toString(a1));

        byte[] a2 = ConvertTo.primitive(Generated.array(Byte.class, new RandomGenerator.Byte(), size));
        System.out.println("a2 = " + Arrays.toString(a2));

        char[] a3 = ConvertTo.primitive(Generated.array(Character.class, new RandomGenerator.Character(), size));
        System.out.println("a3 = " + Arrays.toString(a3));

        short[] a4 = ConvertTo.primitive(Generated.array(Short.class, new RandomGenerator.Short(), size));
        System.out.println("a4 = " + Arrays.toString(a4));

        int[] a5 = ConvertTo.primitive(Generated.array(Integer.class, new RandomGenerator.Integer(), size));
        System.out.println("a5 = " + Arrays.toString(a5));

        long[] a6 = ConvertTo.primitive(Generated.array(Long.class, new RandomGenerator.Long(), size));
        System.out.println("a6 = " + Arrays.toString(a6));

        float[] a7 = ConvertTo.primitive(Generated.array(Float.class, new RandomGenerator.Float(), size));
        System.out.println("a7 = " + Arrays.toString(a7));

        double[] a8 = ConvertTo.primitive(Generated.array(Double.class, new RandomGenerator.Double(), size));
        System.out.println("a8 = " + Arrays.toString(a8));
    }
}
